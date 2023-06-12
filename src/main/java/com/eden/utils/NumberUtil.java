package com.eden.utils;

public class NumberUtil {

  private NumberUtil() {
  }

  /**
   * <p>
   * 숫자(0123456789)로만 구성되어 있는지 체크한다.
   * </p>
   *
   * <pre>
   * NumberUtil.isNumber(null)     = false
   * NumberUtil.isNumber("")       = false
   * NumberUtil.isNumber("   ")    = false
   * NumberUtil.isNumber("111.1")  = false
   * NumberUtil.isNumber("12345 ") = false
   * NumberUtil.isNumber("12345")  = true
   * NumberUtil.isNumber("01234")  = true
   * </pre>
   *
   * @param obj (체크할 문자형, 숫자형 객체)
   * @return boolean (체크 결과)
   */
  public static boolean isNumber(Object obj) {
    if (StringUtil.isBlank(obj)) {
      return false;
    }
    String str = obj.toString();
    return str.matches("\\d*");
  }
}
