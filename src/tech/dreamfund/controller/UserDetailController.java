package tech.dreamfund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tech.dreamfund.model.Account;
import tech.dreamfund.model.UserDetail;
import tech.dreamfund.service.UserDetailService;
import tech.dreamfund.util.ConstantsString;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiasu on 2017/6/4.
 */
@Controller

@SessionAttributes({"account"})
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;

    @RequestMapping("/setSex")
    public String setSex(String sex, ModelMap map, HttpServletResponse response) {
        try {
            Account account = (Account) map.get("account");
            UserDetail userDetail = new UserDetail(account.getId(), sex);
            userDetailService.saveDetail(userDetail);
            account.setUserDetail(userDetail);
            map.put("account",account);
            response.getWriter().write(ConstantsString.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/updateDetail")
    public String updateDetail(String nickName, ModelMap map, HttpServletResponse response) {
        try {
            Account account = (Account) map.get("account");
            UserDetail userDetail=account.getUserDetail();
            userDetail.setNickName(nickName);
            userDetailService.updateDetail(userDetail);
            response.getWriter().write(ConstantsString.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
