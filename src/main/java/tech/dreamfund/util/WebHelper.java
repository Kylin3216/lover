package tech.dreamfund.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by xiasu on 2017/7/8.
 */
public class WebHelper {
    public  static  String setLocation(int user,String sex){
        if (user==0){
            if (sex.equals("男")){
                return  "boy-information";
            }else if(sex.equals("女")){
                return "girl-information";
            }
        }else {
            if (sex.equals("男")){
                return "girl-information";
            }else if(sex.equals("女")){
                return  "boy-information";
            }
        }
        return "";
    }
    public  static  String setMainLocation(int user,String sex){
        if (user==0){
            if (sex.equals("男")){
                return "col-md-pull-9";
            }
        }else {
           if(sex.equals("男")){
               return  "col-md-push-9";
           }
        }
        return "";
    }
    public  static  String setHead(int user,String sex){
        if (user==0){
            if (sex.equals("男")){
                return "boy";
            }
            if(sex.equals("女")){
                return  "girl";
            }
        }else {
            if(sex.equals("女")){
                return  "boy";
            }
            if (sex.equals("男")){
                return "girl";
            }
        }
        return "";
    }

    public static long getCountdownTime(Date date){
        long days;
        Calendar calendar=new GregorianCalendar();
        Calendar calendarNow=new GregorianCalendar();
        calendar.setTime(date);
        calendarNow.setTime(new Date());
        calendar.set(Calendar.YEAR,calendarNow.get(Calendar.YEAR));
        if (calendar.getTimeInMillis()<calendarNow.getTimeInMillis()){
            calendar.set(Calendar.YEAR,calendarNow.get(Calendar.YEAR)+1);
        }
        days=(calendar.getTimeInMillis()-calendarNow.getTimeInMillis())/1000;
        return days;
    }
    public static int getCountdownDays(Date date){
        long seconds=getCountdownTime(date);
        return (int) (seconds/(3600*24));
    }
    public static int getCountdownHours(Date date){
        long seconds=getCountdownTime(date);
        return (int) (seconds%(3600*24)/3600);
    }
    public static int getCountdownMinutes(Date date){
        long seconds=getCountdownTime(date);
        return (int) (seconds%3600/60);
    }
    public static int getCountdownSeconds(Date date){
        long seconds=getCountdownTime(date);
        return (int) (seconds%(3600*24)%3600%60);
    }

}
