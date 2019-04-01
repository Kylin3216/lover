package tech.dreamfund.util;

/**
 * Created by Elvira on 2017/6/18.
 */
public class Common {
    public static String toCnMonth(int num){
        String[] strs={"一","二","三","四","五","六","七","八","九","十","十一","十二",};
        return strs[num-1]+"月";
    }
    public static String monthToNum(String month){
        String[] strs={"一","二","三","四","五","六","七","八","九","十","十一","十二",};
        for (int i=0;i<strs.length;i++){
            if (strs[i].equals(month)){
                if (i<9){
                    return "0"+(i+1);
                }else {
                    return ""+(i+1);
                }
            }

        }
        return "0";
    }
    public static String getNum(String source){
        String result="";
        for (int i=0;i<source.length();i++){
            if (source.charAt(i)>=48&&source.charAt(i)<=57){
                result+=source.charAt(i);
            }
        }
        return result;
    }
}
