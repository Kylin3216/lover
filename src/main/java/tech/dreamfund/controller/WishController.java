package tech.dreamfund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tech.dreamfund.model.Account;
import tech.dreamfund.model.MemoryDay;
import tech.dreamfund.model.Wish;
import tech.dreamfund.service.WishService;
import tech.dreamfund.util.ConstantsString;
import tech.dreamfund.util.RequestString;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by xiasu on 2017/6/29.
 */
@Controller
@SessionAttributes({"account"})
public class WishController {
    @Autowired
    private WishService wishService;

    @RequestMapping("/saveWish")
    public String saveWish(String content, ModelMap map, HttpServletResponse response) {
        Account account = (Account) map.get("account");
        Wish wish = new Wish(content, new Date(), 0, account.getId());
        wishService.saveWish(wish);
        try {
            response.getWriter().write(ConstantsString.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/finishWish")
    public String finishWish(int id, int state, HttpServletResponse response) {
        Wish wish = wishService.queryWishById(id);
        wish.setIsFinished(state);
        wishService.updateWish(wish);
        try {
            response.getWriter().write(ConstantsString.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/deleteWish")
    public String deleteWish(int id,  HttpServletResponse response) {
        wishService.deleteWish(id);
        try {
            response.getWriter().write(ConstantsString.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/wish")
    public String wish(ModelMap map) {
        Account account = (Account) map.get("account");
        if (account == null || account.getId() == 0) {
            return "redirect:/index";
        }
        List<Wish> wishList = wishService.queryWishByAid(account.getId());
        map.put("wishList", wishList);
        map.put("nav","wish");
        return "wish";
    }
}
