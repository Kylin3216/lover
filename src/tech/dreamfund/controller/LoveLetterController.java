package tech.dreamfund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tech.dreamfund.model.Account;
import tech.dreamfund.model.LoveLetter;
import tech.dreamfund.service.LoveLetterService;
import tech.dreamfund.util.ConstantsString;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
@Controller
@SessionAttributes({"account"})
public class LoveLetterController {
    @Autowired
    private LoveLetterService loveLetterService;

    @RequestMapping("/saveLoveLetter")
    public String saveLoveLetter(String content, ModelMap map, HttpServletResponse response) {
        Account account = (Account) map.get("account");
        LoveLetter loveLetter = new LoveLetter(content, account.getId(), new Date());
        loveLetter.setSendTime(new Date());
        loveLetterService.saveLetter(loveLetter);
        try {
            response.getWriter().write(ConstantsString.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/deleteLetter")
    public String deleteLetter(int id, HttpServletResponse response) {
        loveLetterService.deleteLetter(id);
        try {
            response.getWriter().write(ConstantsString.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/saveAndSendLoveLetter")
    public String saveAndSendLoveLetter(String content, ModelMap map, HttpServletResponse response) {
        try {
            Account account = (Account) map.get("account");
            LoveLetter loveLetter = new LoveLetter(content, account.getId(), new Date());
            loveLetter.setSendTime(new Date());
            if (account.getLoverId() > 0) {
                loveLetter.setLoverId(account.getLoverId());
                loveLetter.setState(1);
                loveLetterService.saveLetter(loveLetter);
                response.getWriter().write(ConstantsString.OK);
            } else {
                loveLetterService.saveLetter(loveLetter);
                response.getWriter().write(ConstantsString.Error);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/navToBox")
    public String navToBox(int state, ModelMap map) {
        Account account = (Account) map.get("account");
        List<LoveLetter> loveLetterList = new ArrayList<>();
        if (state == 0) {
            map.put("title", "我收到的情书");
            loveLetterList = loveLetterService.queryLetter(account.getLoverId(), 1);
        } else if (state == 1) {
            map.put("title", "我寄出的情书");
            loveLetterList = loveLetterService.queryLetter(account.getId(), 1);
        } else if (state == 2) {
            map.put("title", "我的草稿箱");
            loveLetterList = loveLetterService.queryLetter(account.getId(), 0);
        }
        map.put("loveLetterList", loveLetterList);
        return "forward:/diary?mode=2";
    }


}

