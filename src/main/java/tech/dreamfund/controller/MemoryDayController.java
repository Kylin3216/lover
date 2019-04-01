package tech.dreamfund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tech.dreamfund.model.Account;
import tech.dreamfund.model.MemoryDay;
import tech.dreamfund.service.MemoryDayService;
import tech.dreamfund.util.ConstantsString;
import tech.dreamfund.util.RequestString;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by xiasu on 2017/6/24.
 */
@Controller
@SessionAttributes({"account"})
public class MemoryDayController {
    @Autowired
    private MemoryDayService memoryDayService;

    @RequestMapping("/saveOrUpdateMemoryDay")
    public String saveOrUpdateMemoryDay( String memoryName,String memoryDate,String id, ModelMap map) {
        Account account = (Account) map.get("account");
        System.out.println(id);
        try {
            Date date=  new SimpleDateFormat("yyyy-MM-dd").parse(memoryDate);
            MemoryDay memoryDay=new MemoryDay(date,memoryName,account.getId());
            if (Integer.parseInt(id)!=0){
                memoryDay.setId(Integer.parseInt(id));
                memoryDayService.updateMemoryDay(memoryDay);
            }else {
                memoryDayService.saveMemoryDay(memoryDay);
            }

            if (account != null && account.getId() != 0) {
                List<MemoryDay> memoryDayList = memoryDayService.queryMemoryDayByAid(account.getId());
                map.put("memoryDayList", memoryDayList);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/memoryday";
    }

    @RequestMapping("/memoryday")
    public  String memoryday(ModelMap map){
        Account account = (Account) map.get("account");
        if (account == null || account.getId() == 0) {
            return "redirect:/index";
        }
        List<MemoryDay> memoryDayList = memoryDayService.queryMemoryDayByAid(account.getId());
        map.put("memoryDayList", memoryDayList);
        map.put("nav","memoryday");
        return "memoryday";
    }
}
