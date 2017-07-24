package tech.dreamfund.util;

import tech.dreamfund.model.Diary;

import java.util.List;

/**
 * Created by Elvira on 2017/6/19.
 */
public class ToJson {
    public static String diaryToJson(Diary diary){
        StringBuilder sb=new StringBuilder();
        sb.append("{");
        sb.append("\"id\":\""+diary.getId()+"\",");
        sb.append("\"title\":\""+diary.getTitle()+"\",");
        sb.append("\"leftContent\":\""+diary.getLeftContent()+"\",");
        sb.append("\"rightContent\":\""+diary.getRightContent()+"\"");
        sb.append("}");
        return  sb.toString();
    }
  /*  public static String diaryToJson(Diary diary){
        StringBuilder sb=new StringBuilder();
        sb.append("{\"diary\":[");
        sb.append(diaryJson(diary));
        sb.append("]}");
        return  sb.toString();
    }*/
    public static String diaryListToJson(List<Diary> list){
        StringBuilder sb=new StringBuilder();
        sb.append("{\"list\":[");
        for (Diary diary:list){
            sb.append(diaryToJson(diary));
            sb.append(",");
        }
        if (list.size()!=0)
        sb.deleteCharAt(sb.length()-1);
        sb.append("]}");
        return sb.toString();
    }
}
