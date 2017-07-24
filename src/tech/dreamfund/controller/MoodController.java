package tech.dreamfund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tech.dreamfund.model.Account;
import tech.dreamfund.model.Mood;
import tech.dreamfund.service.MoodService;
import tech.dreamfund.util.ConstantsString;
import tech.dreamfund.util.RequestString;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
@Controller
@SessionAttributes({"account"})
public class MoodController {
    @Autowired
    private MoodService moodService;
    @RequestMapping("/diary")
    public String diary(String mode,ModelMap map) {
        Account account = (Account) map.get("account");
        if (account == null || account.getId() == 0) {
            return "redirect:/index";
        }
        List moodList = moodService.queryAllMood(account.getId());
        map.put("moodList", moodList);
        map.put("nav","diary");
        map.put("mode",mode);
        return "diary";
    }
    @RequestMapping("/saveMood")
    public String saveMood(String content, ModelMap map, HttpServletResponse response){
        try {
            Account account= (Account) map.get("account");
            Mood mood=new Mood(content,new Date(),account.getId());
            moodService.saveMood(mood);
            response.getWriter().write(ConstantsString.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/deleteMood")
    public String deleteMood(int id, HttpServletResponse response){
        try {
            moodService.deleteMood(id);
            response.getWriter().write(ConstantsString.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
