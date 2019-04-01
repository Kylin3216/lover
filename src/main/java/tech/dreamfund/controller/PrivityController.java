package tech.dreamfund.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.dreamfund.model.Account;
import tech.dreamfund.util.RequestString;

/**
 * Created by xiasu on 2017/7/9.
 */
@Controller
public class PrivityController {
    @RequestMapping("/navToPrivity")
    public String navToPrivity(ModelMap map) {
        return RequestString.navToRegister(map, "privity", "privity");
    }

    @RequestMapping("/privity")
    public String privity(ModelMap map) {
        Account account = (Account) map.get("account");
        if (account == null || account.getId() == 0) {
            return "redirect:/index";
        }
        map.put("nav","privity");
        return "privity";
    }
}
