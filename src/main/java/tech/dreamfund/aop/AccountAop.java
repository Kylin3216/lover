package tech.dreamfund.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import tech.dreamfund.model.Account;
import tech.dreamfund.service.AccountService;

/**
 * Created by xiasu on 2017/7/9.
 */
@Aspect
@Component
public class AccountAop {
    @Autowired
    private AccountService accountService;

    @After(value = "execution(* tech.dreamfund.controller.*.*(..))&& args(modelMap,..)")
    public void updateUserAction(ModelMap modelMap) {
        Account account = (Account) modelMap.get("account");
        if (account!=null&&account.getId()>0){
            modelMap.put("loginUser", accountService.queryAccountById(account.getId()));
        }
    }
}
