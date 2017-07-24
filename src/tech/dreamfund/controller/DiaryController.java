package tech.dreamfund.controller;

import com.sun.javafx.image.impl.IntArgb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tech.dreamfund.model.Account;
import tech.dreamfund.model.Diary;
import tech.dreamfund.service.DiaryService;
import tech.dreamfund.util.Common;
import tech.dreamfund.util.ConstantsString;
import tech.dreamfund.util.RequestString;
import tech.dreamfund.util.ToJson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Elvira on 2017/6/17.
 */
@Controller
@SessionAttributes({"account"})
public class DiaryController {
    @Autowired
    private DiaryService diaryService;
    /**
     * 保存日记
     * @param title 日记名称
     * @param content1 第一页内容
     * @param content2 第二页内容
     **/
    @RequestMapping("/saveDiary")
    public  String saveDiary(String title, String content1, String content2, ModelMap map,HttpServletResponse response){
        try {
            PrintWriter printWriter=response.getWriter();
            Account account= (Account) map.get("account");
            int id=Integer.parseInt(new SimpleDateFormat("yyMMdd").format(new Date()));
            Diary diary =new Diary(id,title,content1,content2,new Date(),account.getId());
            diaryService.saveDiary(diary);
            printWriter.write(ConstantsString.OK);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }
    /**
     * 删除日记
     * @param date 传入日记时间格式为yyyy-mm-dd
     **/
    @RequestMapping("/deleteDiary")
    public String deleteDiary(String date, HttpServletResponse response){
        try {
            PrintWriter printWriter=response.getWriter();
            String[] strs=date.split("-");
            int id=Integer.parseInt(strs[0].substring(2)+strs[1]+strs[2]);
            diaryService.deleteDiary(id);
            printWriter.write(ConstantsString.OK);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }
    /**
     * 显示一年内的月日记列表
     * @param year 传入的年份
     * */
    @RequestMapping("/showDiaryMonthList")
    public String showDiaryMonthList(String year,HttpServletResponse response){
        Map<Integer,Integer> map=diaryService.queryMonthList(year);
        Set<Map.Entry<Integer, Integer>> monthList = map.entrySet();
        StringBuilder sb=new StringBuilder();
        for (Map.Entry<Integer,Integer> m:monthList){
            sb.append(Common.toCnMonth(m.getKey())+","+m.getValue()+"$");
        }
        if (sb.length()!=0)
        sb.deleteCharAt(sb.length()-1);
        try {
            response.getWriter().write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
    /**
     * 显示年日记列表
     **/
    @RequestMapping("/showDiaryYearList")
    public String showDiaryYearList(HttpServletResponse response){
        Map<Integer,Integer> map=diaryService.queryYearList();
        Set<Map.Entry<Integer, Integer>> monthList = map.entrySet();
        StringBuilder sb=new StringBuilder();
        for (Map.Entry<Integer,Integer> m:monthList){
            sb.append(m.getKey()+"年"+","+m.getValue()+"$");
        }
        if (sb.length()!=0)
        sb.deleteCharAt(sb.length()-1);
        try {
            response.getWriter().write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
    /**
     * 显示一个月内的日记列表
     * @param yearMonth 传入的月份*/
    @RequestMapping("/showDiaryDayList")
    public String showDiaryDay(String yearMonth,HttpServletResponse response){
        List<Diary> list=diaryService.queryDiaryList(yearMonth.substring(5,7)+Common.monthToNum(yearMonth.substring(8,9))+"%");
        StringBuilder sb=new StringBuilder();
        for (Diary m:list){
            sb.append(m.getTitle()+","+(m.getId()+"").substring(2)+"$");
        }
        if (sb.length()!=0)
            sb.deleteCharAt(sb.length()-1);
        try {
            response.getWriter().write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;

    }
    @RequestMapping("/showDiaryContent")
    public String showDiaryContent(String time,HttpServletResponse response){
        Diary diary=diaryService.queryDiaryById(Integer.parseInt(time));
        try {
            response.getWriter().write(ToJson.diaryToJson(diary));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;

    }
}
