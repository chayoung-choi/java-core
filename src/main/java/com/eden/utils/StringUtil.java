package com.eden.utils;

public class StringUtil {

  private StringUtil() {
  }

  /**
   * <p>
   * 해당 값이 null, 공백문자(""), whitespace(" ")이면 true 값을 반환한다.
   * </p>
   *
   * <pre>
   * isBlank(null)    = true
   * isBlank("")      = true
   * isBlank("   ")   = true
   * isBlank("str")   = false
   * isBlank(" str ") = false
   * </pre>
   *
   * @param o (문자형, 숫자형 객체)
   * @return boolean (체크결과)
   */
  public static boolean isBlank(Object o) {
    String str = (o == null) ? "" : String.valueOf(o).trim();
    return str.length() == 0;
  }
}
