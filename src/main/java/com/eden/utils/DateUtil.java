package com.eden.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtil {

  private static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
  private static final String DATE_FORMAT_SHORT = "yyyy-MM-dd";

  private DateUtil() {
  }


  /**
   * <p>
   * 날짜형식 문자 또는 Date 객체에 해당하는 날짜 포멧을 리턴한다.
   * </p>
   *
   * <pre>
   * DateUtil.getFormat(null)                  = ""
   * DateUtil.getFormat("")                    = ""
   * DateUtil.getFormat("   ")                 = ""
   * DateUtil.getFormat("2023601")             = ""
   * DateUtil.getFormat("20230601")            = "yyyyMMdd"
   * DateUtil.getFormat("2023 06 01")          = "yyyy MM dd"
   * DateUtil.getFormat("2023-06-01")          = "yyyy-MM-dd"
   * DateUtil.getFormat("2023.06.01")          = "yyyy.MM.dd"
   * DateUtil.getFormat("2023/06/01")          = "yyyy/MM/dd"
   * DateUtil.getFormat("2023-06-01 14")       = "yyyy-MM-dd HH"
   * DateUtil.getFormat("2023-06-01 14:21")    = "yyyy-MM-dd HH:mm"
   * DateUtil.getFormat("2023-06-01 14:21:34") = "yyyy-MM-dd HH:mm:ss"
   * DateUtil.getFormat(Date)                  = "yyyy-MM-dd HH:mm:ss"
   * </pre>
   *
   * @param obj (날짜형식 문자 또는 Date 객체)
   * @return String (날짜 포멧)
   */
  public static String getFormat(Object obj) {
    if (obj == null) {
      return "";
    }

    if (obj instanceof Date) {
      return DATE_FORMAT_FULL;
    }

    String str = ((String) obj).trim();
    if (str.length() < 8) {
      return "";
    }

    if (NumberUtil.isNumber(str) && str.length() == 8) {
      return "yyyyMMdd";
    }

    String format;
    if (str.contains("-")) {
      format = DATE_FORMAT_SHORT;
    } else if (str.contains(".")) {
      format = "yyyy.MM.dd";
    } else if (str.contains("/")) {
      format = "yyyy/MM/dd";
    } else {
      format = "yyyy MM dd";
    }

    if (str.length() > 10) {
      if (StringUtil.countMatches(str, ":") == 2) {
        format += " HH:mm:ss";
      } else if (StringUtil.countMatches(str, ":") == 1) {
        format += " HH:mm";
      } else {
        format += " HH";
      }
    }
    return format;
  }

  /**
   * <p>
   * 해당 객체를 Date 객체로 형변환 하거나 String 객체일 경우 Date 객체로 변경하고 리턴한다.
   * </p>
   *
   * @param o (날짜형식 문자 또는 Date 객체)
   * @return Date (Date 객체)
   */
  public static Date parseDate(Object o) {
    if (o == null) {
      return null;
    }
    if (o instanceof Date d) {
      return d;
    }

    Date date = null;
    if (o instanceof String s) {
      String str = s.trim();
      if (StringUtil.isBlank(str)) {
        return null;
      }
      try {
        DateFormat sdf = new SimpleDateFormat(getFormat(str));
        date = sdf.parse(str);
      } catch (ParseException e) {
        log.error("지원하지 않는 날짜형식 입니다.");
      }
    }
    return date;
  }

  /**
   * <p>
   * 날짜형식 문자 또는 Date 객체를 원하는 날짜 형식으로 변경후 리턴한다.
   * </p>
   *
   * @param o      (날짜형식 문자 또는 Date 객체)
   * @param format (변경할 포멧)
   * @return String (변경후 날짜)
   */
  public static String toDateFormat(Object o, String format) {
    if (o == null) {
      return "";
    }
    if (StringUtil.isBlank(format)) {
      format = DATE_FORMAT_FULL;
    }
    Date date = null;
    if (o instanceof String) {
      date = parseDate(o);
      if (date == null) {
        return "";
      }
    } else if (o instanceof Date d) {
      date = d;
    }
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(date);
  }

  /**
   * <p>
   * 오늘의 날짜를 구해서 'yyyy-MM-dd' 포멧으로 리턴한다.
   * </p>
   *
   * <pre>
   * DateUtil.getToday() = "2023-06-09"
   * </pre>
   *
   * @return String (현재 날짜)
   */
  public static String getToday() {
    return getToday(DATE_FORMAT_SHORT);
  }

  /**
   * <p>
   * 오늘의 날짜를 구해서 해당 날짜 포멧으로 리턴한다.
   * </p>
   *
   * <pre>
   * DateUtil.getToday("yyyy-MM-dd") = "2009-12-20"
   * DateUtil.getToday("yyyy.MM.dd") = "2009.12.20"
   * DateUtil.getToday("yyyy/MM/dd") = "2009/12/20"
   * DateUtil.getToday("yyyy MM dd") = "2009 12 20"
   * DateUtil.getToday("MM-dd-yyyy") = "12-20-2009"
   * DateUtil.getToday("MM.dd.yyyy") = "12.20.2009"
   * </pre>
   *
   * @param format (날짜 포멧)
   * @return String (현재 날짜)
   */
  public static String getToday(String format) {
    return toDateFormat(new Date(), format);
  }

  /**
   * <p>
   * 현재의 날짜와 시간을 구해서 'yyyy-MM-dd HH:mm:ss' 포멧으로 리턴한다.
   * </p>
   *
   * <pre>
   * DateUtil.getNowAll() = "2009-12-20 20:15:57"
   * </pre>
   *
   * @return String (현재 날짜와 시간)
   */
  public static String getNow() {
    return getNow(DATE_FORMAT_FULL);
  }

  /**
   * <p>
   * 현재의 날짜와 시간을 구해서 해당 날짜 포멧으로 리턴한다.
   * </p>
   *
   * <pre>
   * DateUtil.getNowAll("yyyy-MM-dd HH:mm:ss") = "2009-12-20 20:15:57"
   * DateUtil.getNowAll("yyyy.MM.dd HH:mm:ss") = "2009.12.20 20:15:57"
   * DateUtil.getNowAll("yyyy/MM/dd HH:mm:ss") = "2009/12/20 20:15:57"
   * DateUtil.getNowAll("yyyy MM dd HH:mm:ss") = "2009 12 20 20:15:57"
   * DateUtil.getNowAll("MM-dd-yyyy HH:mm:ss") = "12-20-2009 20:15:57"
   * DateUtil.getNowAll("MM.dd.yyyy HH:mm:ss") = "12.20.2009 20:15:57"
   * </pre>
   *
   * @param format (날짜 포멧)
   * @return String (현재 날짜와 시간)
   */
  public static String getNow(String format) {
    return toDateFormat(new Date(), format);
  }
}
