package com.xinglib;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @version :
 * <p>
 * desc :
 * @author: Java
 * <p>
 * 纵然万劫不复，纵然相思入骨，我依然待你眉眼如初，岁月如故。
 * <p>
 * <p>
 * @date : 2019/5/5
 *
 * 正则表达式
 * <p>
 */
public class RegexUtils {


    /**
     * 是否为身份证号码
     * @param number
     * @return
     */
    public static boolean isIdCard(String number) {
        if(TextUtils.isEmpty(number)) {
            return false;
        }

        String rgx = "^\\d{15}|^\\d{17}([0-9]|X|x)$";
        return isCorrect(rgx, number);
    }


    /**
     * 是否为手机号码
     * @param mobiles
     * @return
     */
    public static boolean isMobileNo(String mobiles) {
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        }

        return isCorrect("^[1][123456789][0-9]{9}$", mobiles);
    }


    /**
     * 是否满足正则表达式
     * 正则验证
     */
    public static boolean isCorrect(String rgx, String res) {
        Pattern p = Pattern.compile(rgx);
        Matcher m = p.matcher(res);
        return m.matches();
    }


}
