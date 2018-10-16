package com.sun.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by sun on 18/1/3.
 */

public class DateUtil {
    //获取日历样式
    public static final String STYLE1 = "yyyy-MM-dd HH:mm:ss";
    public static final String STYLE2 = "yyyy年MM月dd日 HH:mm:ss";
    public static final String STYLE3 = "yyyy-MM-dd";
    public static final String STYLE4 = "yyyy年MM月dd日";
    public static final String STYLE5 = "yyyy-MM";
    public static final String STYLE6 = "yyyy年MM月";
    public static final String STYLE7 = "HH:mm:ss";
    public static final String STYLE8 = "HH:mm";
    public static final String STYLE9 = "yyyy-MM-dd HH:mm";
    public static final String STYLE10 = "MM月dd日";
    //getSingleDate(String title)用
    public static final String SINGLE_YEAR = "single_year";
    public static final String SINGLE_MONTH = "single_month";
    public static final String SINGLE_DAY = "single_day";
    public static final String SINGLE_HOUR = "single_hour";
    public static final String SINGLE_MINUTE = "single_minute";
    public static final String SINGLE_SECOND = "single_second";

    //getSingleDate(long time, String title)用
    public static final String SINGLE_YEAR1 = "yyyy";
    public static final String SINGLE_MONTH1 = "MM";
    public static final String SINGLE_DAY1 = "dd";
    public static final String SINGLE_HOUR1 = "HH";
    public static final String SINGLE_MINUTE1 = "mm";
    public static final String SINGLE_SECOND1 = "ss";


    /**
     * @param style 格式   yyyy-MM-dd   或      yyyy年MM月dd日
     * @return 2018-01-01 星期一       或      2018年1月1日 星期一
     */
    public static String getDateAndWeek(String style) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(style);
        String date = simpleDateFormat.format(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String week = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
        switch (week) {
            case "1":
                date = date + " 星期日";
                break;
            case "2":
                date = date + " 星期一";
                break;
            case "3":
                date = date + " 星期二";
                break;
            case "4":
                date = date + " 星期三";
                break;
            case "5":
                date = date + " 星期四";
                break;
            case "6":
                date = date + " 星期五";
                break;
            case "7":
                date = date + " 星期六";
                break;
        }
        return date;
    }

    /**
     * @param style 格式  yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd   或      yyyy年MM月dd日  或  HH:mm:ss  或   HH:mm
     * @return 2018-01-01   或      2018年01月01日
     */
    public static String getDateAndTime(String style) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(style);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    /**
     * @param style 格式  yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd   或      yyyy年MM月dd日  或  HH:mm:ss  或   HH:mm
     * @return 2018-01-01   或      2018年01月01日
     */
    public static String getDateAndTime(String style, long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(style);
        String str = simpleDateFormat.format(time);
        return str;
    }

    /**
     * 获取当日星期
     *
     * @return
     */
    public static String getWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String week = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
        switch (week) {
            case "1":
                return "星期日";
            case "2":
                return "星期一";
            case "3":
                return "星期二";
            case "4":
                return "星期三";
            case "5":
                return "星期四";
            case "6":
                return "星期五";
            case "7":
                return "星期六";
        }
        return "";
    }

    /**
     * 获取某一天星期几
     *
     * @param date 如：2018-01-02
     * @return
     */
    public static String getWeekOfOneDay(String date) {
        SimpleDateFormat format = new SimpleDateFormat(STYLE3);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String week = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
        switch (week) {
            case "1":
                return "星期日";
            case "2":
                return "星期一";
            case "3":
                return "星期二";
            case "4":
                return "星期三";
            case "5":
                return "星期四";
            case "6":
                return "星期五";
            case "7":
                return "星期六";
        }
        return "";
    }

    /**
     * @param type 年月日时分秒 SINGLE_YEAR，SINGLE_MONTH，SINGLE_DAY，SINGLE_HOUR，SINGLE_MINUTE，SINGLE_SECOND
     * @return
     */
    public static int getSingleDate(String type) {
        Calendar calendar = Calendar.getInstance();
        switch (type) {
            case SINGLE_YEAR:
                return calendar.get(Calendar.YEAR);
            case SINGLE_MONTH:
                return calendar.get(Calendar.MONTH) + 1;
            case SINGLE_DAY:
                return calendar.get(Calendar.DAY_OF_MONTH);
            case SINGLE_HOUR:
                return calendar.get(Calendar.HOUR_OF_DAY);
            case SINGLE_MINUTE:
                return calendar.get(Calendar.MINUTE);
            case SINGLE_SECOND:
                return calendar.get(Calendar.SECOND);
            default:
                return 0;
        }

    }

    /**
     * @param time 时间戳
     * @param type yyyy,MM,dd,HH,mm,ss
     * @return 2018, 04.15, 12, 12, 12
     */

    public static int getSingleDate1(long time, String type) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);//设置日期格式
        String t = simpleDateFormat.format(new Date(time));// new Date()为获取当前系统时间，也可使用当前时间戳
        return Integer.parseInt(t);
    }

    /**
     * @param time 毫秒为单位
     * @param type HH,mm,ss
     * @return 12, 12, 12
     */

    public static int getSingleDate(long time, String type) {
        long tempTime = time / 1000;

        switch (type) {
            case SINGLE_HOUR1:
                return (int) (tempTime / 3600);
            case SINGLE_MINUTE1:
                return (int) ((tempTime % 3600) / 60);
            case SINGLE_SECOND1:
                return (int) ((tempTime % 3600) % 60);
        }
        return 0;

    }

    /**
     * date类型转换为String类型
     *
     * @param data
     * @param formatType
     * @return
     */
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    /**
     * long类型转换为String类型
     *
     * @param currentTime
     * @param formatType
     * @return
     * @throws ParseException
     */
    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        Date date = longToDate(currentTime, formatType); // long类型转成Date类型
        String strTime = dateToString(date, formatType); // date类型转成String
        return strTime;
    }

    /**
     * string类型转换为date类型
     * strTime的时间格式必须要与formatType的时间格式相同
     * @param strTime
     * @param formatType
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }


    /**
     * long转换为Date类型
     *
     * @param currentTime
     * @param formatType
     * @return
     * @throws ParseException
     */
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    /**
     * string类型转换为long类型
     * strTime的时间格式和formatType的时间格式必须相同
     * @param strTime
     * @param formatType
     * @return
     * @throws ParseException
     */
    public static long stringToLong(String strTime, String formatType)
            throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }


    /**
     * date类型转换为long类型
     *
     * @param date
     * @return
     */
    public static long dateToLong(Date date) {
        return date.getTime();
    }

}
