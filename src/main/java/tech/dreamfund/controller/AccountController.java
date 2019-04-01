package tech.dreamfund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tech.dreamfund.model.Account;
import tech.dreamfund.service.AccountService;
import tech.dreamfund.util.ConstantsString;
import tech.dreamfund.util.EncryptAndDecrypt;
import tech.dreamfund.util.RequestString;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by xiasu on 2017/6/4.
 */
@Controller
@SessionAttributes({"account"})
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/login")
    public String login(String nameOrPhoneOrEmail, String password, ModelMap map, ServletResponse response) {
        try {
            PrintWriter pw = response.getWriter();
            String encryptPassword = EncryptAndDecrypt.EncryptPassword(password);
            Account account;
            if ((account = accountService.confirmByTelephone(nameOrPhoneOrEmail, encryptPassword)) != null
                    || (account = accountService.confirmByEmail(nameOrPhoneOrEmail, encryptPassword)) != null
                    || (account = accountService.confirmByAccountName(nameOrPhoneOrEmail, encryptPassword)) != null) {
                map.put("account", account);
                return "redirect:/index";
            }
            pw.write(ConstantsString.AccountError);
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @RequestMapping("/register")
    public String register(String phoneOrEmail, String password, boolean check,ModelMap map, HttpServletResponse response) {
        try {
            PrintWriter pw = response.getWriter();
            if (accountService.queryByTelephone(phoneOrEmail) != null) {
                pw.write(ConstantsString.IsPhoneRepeat);
                return null;
            } else if (accountService.queryByEmail(phoneOrEmail) != null) {
                pw.write(ConstantsString.IsEmailRepeat);
                return null;
            } else {
                Account account;
                Integer id = accountService.queryLastId();
                if (id == null) {
                    id = 1001;
                } else {
                    id++;
                }
                try {
                    Long.parseLong(phoneOrEmail);
                    account = new Account(id, "用户" + id, "", phoneOrEmail, EncryptAndDecrypt.EncryptPassword(password), 1, new Date());
                } catch (NumberFormatException e) {
                    account = new Account(id, "用户" + id, phoneOrEmail, "", EncryptAndDecrypt.EncryptPassword(password), 1, new Date());
                }
                account.setLastLoginTime(new Date());
                accountService.addAccount(account);
                Account a=accountService.queryAccountById(id);
                map.put("account",a);
                pw.write(ConstantsString.OK);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @RequestMapping("/queryAccount")
    public String queryAccount(String nameOrPhoneOrEmail, ServletResponse response) {
        Account account;
        try {
            if ((account = accountService.queryByTelephone(nameOrPhoneOrEmail)) != null
                    || (account = accountService.queryByEmail(nameOrPhoneOrEmail)) != null
                    || (account = accountService.queryByAccountName(nameOrPhoneOrEmail)) != null) {
                String name;
                if (account.getUserDetail() == null||account.getUserDetail().getNickName()==null) {
                    name = "该用户尚未设置昵称";
                }else {
                    name = account.getUserDetail().getNickName();
                }
                response.getWriter().write(name + "|" + account.getId());
            }else {
                response.getWriter().write(ConstantsString.Error);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/bind")
    public String bind(int id,int loverId) {
            Account account=accountService.queryAccountById(id);
            Account lover=accountService.queryAccountById(loverId);
            account.setLoverId(loverId);
            lover.setLoverId(id);
            accountService.updateLover(account);
            accountService.updateLover(lover);
            return "redirect:/message";
    }

    @RequestMapping("/exit")
    public String exit(ModelMap map) {
        map.put("account", new Account());
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.put("nav", "index");
        return "index";
    }
}
