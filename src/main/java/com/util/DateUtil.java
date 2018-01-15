package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author sdyang
 * @create 2017-11-12 10:25
 **/
public class DateUtil {

    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * Long类型时间转字符串
     * @param time
     * @return
     */
    public static String toString(Long time){
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Date date = new Date(time);
       return format.format(date);
    }

    /**
     * 当前时间
     * @return
     */
    public static String getNow(){
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Date date = new Date();
        return format.format(date);
    }

    /**
     * 日期转字符串
     * @param date
     * @return
     */
    public static String toString(Date date){
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return format.format(date);
    }

    /**
     * 增加分钟数
     * @param date
     * @param minute
     * @return
     */
    public static String addMinute(Date date,int minute){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE,minute);
        return  toString(calendar.getTime());
    }

    /**
     * 增加秒数
     * @param date
     * @param second
     * @return
     */
    public static String addSecond(Date date,int second){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND,second);
        return toString(calendar.getTime());
    }

    /**
     * 字符串转日期
     * @param dateStr
     * @return
     */
    public static Date toDate(String dateStr){
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
