package com.xinglib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
 * <p>
 * 时间工具
 *
 * <p>
 */
public class TimeUtils {

    //yyyy-MM-dd HH:mm:ss
    //yyyy-MM-dd Hh:mm
    //yyyy-MM-dd
    //yyyy年MM月dd日
    private static Map<String, SimpleDateFormat> mapContainer = new HashMap<>();

    /**
     * 格式化全局数据 2019-05-05 16:42:49
     *
     * @param timeMillis 当前时间数（单位毫秒）
     * @return
     */
    public static String parseFullTimeStr(long timeMillis) {
        return parseTimeByFormat(timeMillis, "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 时间格式化数据 2019-05-05 16:42
     *
     * @param timeMillis
     * @return
     */
    public static String parseYearMonthDayMinutes(long timeMillis) {
        return parseTimeByFormat(timeMillis, "yyyy-MM-dd HH:mm");
    }


    /**
     * 时间格式化数据 16:42
     *
     * @param timeMillis
     * @return
     */
    public static String parseMinutesSecond(long timeMillis) {
        return parseTimeByFormat(timeMillis, "HH:mm");
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentDate(){
        return parseFullTimeStr(System.currentTimeMillis());
    }

    /**
     * 特定格式 格式化时间
     * @param timeMillis 时间数
     * @param format    特定的时间格式
     * @return
     */
    public static String parseTimeByFormat(long timeMillis, String format) {
        SimpleDateFormat targetSimpleDate = getSimpleDateFormat(format);

        //加锁，避免线程不安全
        return targetSimpleDate.format(new Date(timeMillis));
    }


    private static SimpleDateFormat getSimpleDateFormat(String format) {
        SimpleDateFormat simpleDateFormat = mapContainer.get(format);
        if (null == simpleDateFormat) {
            simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
            mapContainer.put(format, simpleDateFormat);
        }

        return simpleDateFormat;
    }

}
