package com.racing.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jodd.datetime.JDateTime;

public class DateUtil {

  public static final String DateFormat_HHmm = "HH:mm";

  /**
   * 格式 20150807
   */
  public static final String DateFormat_yyyyMMdd = "yyyyMMdd";

  /**
   * 格式 2015-08-07
   */
  public static final String DateFormat_yyyy_MM_dd = "yyyy-MM-dd";

  /**
   * 格式 2015-08-07 11:44:18:591
   */
  public static final String DateFormat_yyyyMMddHHmmssSSS = "yyyy-MM-dd HH:mm:ss.SSS";

  /**
   * 格式 2015-08-07 11:44:18
   */
  public static final String DateFormat_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";

  /**
   * 日期加秒
   * 
   * @param date
   * @param days
   * @return
   */
  public static Date addSecond(Date date, int second) {
    JDateTime JDateTime = new JDateTime(date);
    JDateTime.addSecond(second);
    return JDateTime.convertToDate();
  }

  /**
   * 计算两个时间的天数之差(不存在负数)
   * 
   * @param date1
   * @param date2
   * @return
   */
  public static int daysBetweenTwoDate(Date date1, Date date2) {
    JDateTime JDateTime1 = new JDateTime(date1);
    JDateTime JDateTime2 = new JDateTime(date2);
    int days = JDateTime1.daysBetween(JDateTime2);
    return days;
  }

  /**
   * 日期转化为字符串
   * 
   * @param str
   * @param format
   * @return
   */
  public static String parseToString(Date date, String format) {
    DateFormat df = new SimpleDateFormat(format);
    String strDate = df.format(date);
    return strDate;
  }

  /**
   * 字符串日期转化为日期
   * 
   * @param str
   * @param format
   * @return
   * @throws ParseException
   */
  public static Date parseToDate(String dateStr, String format) throws ParseException {
    DateFormat df = new SimpleDateFormat(format);
    Date date = df.parse(dateStr);
    return date;
  }

  /**
   * 设置日期的时分秒
   * 
   * @param date
   * @return
   * @throws ParseException
   */
  public static Date setDateHHmmss(Date date, int h, int m, int s) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, h);
    calendar.set(Calendar.MINUTE, m);
    calendar.set(Calendar.SECOND, s);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  /**
   * 设置日期的毫秒值为0
   * 
   * @param date
   * @return
   * @throws ParseException
   */
  public static Date setDateMillisecondZero(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  /**
   * 计算两个时间的秒之差(不存在负数)考虑秒数
   * 
   * @param date1
   * @param date2
   * @return
   */
  public static long secondBetweenTwoDate(Date date1, Date date2) {
    if (date1 == null || date2 == null) {
      throw new RuntimeException("比较秒数差的两个日期都不能为空");
    } else {
      long longValue1 = date1.getTime();
      long longValue2 = date2.getTime();
      long difference = longValue1 - longValue2;
      long differenceSecond = Math.abs(difference) / (1000);
      return differenceSecond;
    }
  }

  /**
   * 获取某天开始（yyyy-MM-dd 00:00:00）
   * 
   * @param date
   * @return
   * 
   */
  public static Date getBeginOfDay(Date date) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat(DateFormat_yyyy_MM_dd);
    String temp = sdf.format(date);
    date = sdf.parse(temp);
    return date;
  }

  /**
   * 获取某天结束（yyyy-MM-dd 23:59:59）
   * 
   * @param date
   * @return
   * @throws ParseException
   * 
   */
  public static Date getEndOfDay(Date date) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat(DateFormat_yyyy_MM_dd);
    SimpleDateFormat sdf2 = new SimpleDateFormat(DateFormat_yyyyMMddHHmmss);
    String temp = sdf.format(date);
    Date newDate = sdf2.parse(temp + " 23:59:59");
    return newDate;
  }


  /**
   * 日期加天数
   * 
   * @param date
   * @param days
   * @return
   */
  public static Date addDay(Date date, int days) {
    JDateTime JDateTime = new JDateTime(date);
    JDateTime.addDay(days);
    return JDateTime.convertToDate();
  }


  /**
   * 获取日期的星期几
   * 
   * @param date
   * @return
   */
  public static String getWeekOfDate(Date date) {
    String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
    if (w < 0)
      w = 0;
    return weekDays[w];
  }

  /**
   * 判断当前是不是星期天
   * 
   * @param date
   * @return
   */
  public static boolean isSunday(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
    if (w < 0)
      w = 0;
    return w == 0;
  }

  /**
   * 设置日期所在周的周一(主意程序中周日是第一天)
   * 
   * @param date
   * @return
   */
  private static Date getDayForWeekFirstDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    return calendar.getTime();
  }

  /**
   * 设置日期所在周的周日(主意程序中周日是第一天)
   * 
   * @param date
   * @return
   */
  private static Date getDayForWeekLastDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    return calendar.getTime();
  }

  /**
   * 获取上周的周一
   * 
   * @param date
   * @return
   */
  public static Date getPreviousWeekFirstDate(Date date) {
    if (isSunday(date)) {
      date = addDay(date, -1);
    }
    date = addDay(date, -7);
    return getDayForWeekFirstDay(date);
  }

  /**
   * 
   * @param date
   * @return
   */
  public static Date getWeekLastDate(Date date) {
    if (isSunday(date)) {
      return date;
    }
    date = addDay(date, 7);
    return getDayForWeekLastDay(date);
  }

}
