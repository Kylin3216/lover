package tech.dreamfund.util;

import org.springframework.ui.ModelMap;
import tech.dreamfund.model.Account;
import tech.dreamfund.model.KeyValuePair;

/**
 * Created by Elvira on 2017/6/17.
 */
public class RequestString {
    public static String navToRegister(ModelMap map, String nav, String navTo,KeyValuePair... pairs){
        Account account = (Account) map.get("account");
        if (account==null||account.getId()==0){
            map.put("user","null");
            map.put("nav","index");
            return "redirect:/index";
        }else {
            if (pairs.length!=0){
                for (KeyValuePair pair:pairs){
                    map.put(pair.getKey(),pair.getValue());
                }
            }
            map.put("nav",nav);
            return "forward:/"+navTo;
        }
    }
}
