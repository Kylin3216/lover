package tech.dreamfund.util;

/**
 * Created by xiasu on 2017/6/5.
 */
public class EncryptAndDecrypt {
    public static String EncryptPassword(String password){
       StringBuilder encryptPassword=new StringBuilder();
       for (int i=0;i<password.length();i++){
           char c=password.charAt(i);
           if (c/2==0){
               encryptPassword.append((char)(c+2));
               encryptPassword.append((char)(c-2));
           }else if (c/3==0){
               encryptPassword.append((char)(c/3));
               encryptPassword.append((char)(c/2));
           }else {
               encryptPassword.append((char)(c-2));
               encryptPassword.append((char)(c+2));
           }
       }
       return encryptPassword.toString();
    }

    public static String DecryptPassword(String encryptPassword){
        StringBuilder decryptPassword=new StringBuilder();
        for (int i=0;i<encryptPassword.length();i+=2){
            char c=encryptPassword.charAt(i);
            if (c/2==0){
                decryptPassword.append((char)(c-2));
            }else if (c/3==0){
                decryptPassword.append((char)(c*2));
            }else {
                decryptPassword.append((char)(c+2));
            }
        }
        return decryptPassword.toString();
    }
}
