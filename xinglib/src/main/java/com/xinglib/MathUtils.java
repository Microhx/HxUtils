package com.xinglib;

import android.text.TextUtils;

/**
 * @version : v0.0.9
 * <p>
 * desc :
 * @author: Java
 * <p>
 * 纵然万劫不复，纵然相思入骨，我依然待你眉眼如初，岁月如故。
 * <p>
 * <p>
 * @date : 2019/5/5
 *
 * 封装平时使用的基础框架
 *
 * <p>
 */
public class MathUtils {

    /**
     * 安全型 字符串转byte
     * @param byteStr     目标字符串
     * @param defaultValue  默认值
     * @return
     */
    public static byte safeParseByte(String byteStr, byte defaultValue) {
        if(TextUtils.isEmpty(byteStr)) return defaultValue;

        try {
          return  Byte.parseByte(byteStr);
        }catch (NumberFormatException ignore){
            return defaultValue;
        }
    }

    public static byte safeParseByte(String byteStr) {
        return safeParseByte(byteStr, (byte) 0);
    }


    /**
     * 获取安全型的 Char
     * @param charStr   字符串
     * @param defaultValue 目标Char值
     * @return
     */
    public static char safeParseChar(String charStr, char defaultValue) {
        if(TextUtils.isEmpty(charStr)) return defaultValue;
        return charStr.charAt(0);
    }


    public static char safeParseChar(String charStr) {
        return safeParseChar(charStr,' ');
    }


    /**
     * 安全型的 字符转
     * @param intStr      目标字符串
     * @param defaultValue  默认字符
     * @return
     */
    public static int safeParseInt(String intStr, int defaultValue) {
        if(TextUtils.isEmpty(intStr)) return defaultValue;

        try {
            return Integer.parseInt(intStr);
        }catch (NumberFormatException ignore) {
            return defaultValue;
        }
    }

    public static int safeParseInt(String intStr) {
        return safeParseInt(intStr,0);
    }

    /**
     * 安全型的 字符串转 float
     * @param floatStr  目标字符
     * @param defaultValue  默认字符串
     * @return
     */
    public static float safeParseFloat(String floatStr, float defaultValue) {
        if(TextUtils.isEmpty(floatStr)) return defaultValue;

        try {
            return Float.parseFloat(floatStr);
        }catch (NumberFormatException ignore) {
            return defaultValue;
        }
    }

    public static float safeParseFloat(String floatStr) {
        return safeParseFloat(floatStr,0f);
    }


    /**
     * 安全型 字符串转 double
     * @param doubleStr    目标字符串
     * @param defaultValue 默认值
     * @return
     */
    public static double safeParseDouble(String doubleStr, double defaultValue) {
        if(TextUtils.isEmpty(doubleStr)) return defaultValue;

        try {
            return Double.parseDouble(doubleStr);
        }catch (NumberFormatException ignore) {
            return defaultValue;
        }
    }


    public static double safeParseDouble(String doubleStr) {
        return safeParseDouble(doubleStr,0d);
    }





}
