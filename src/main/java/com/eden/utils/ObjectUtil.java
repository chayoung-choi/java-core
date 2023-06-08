package com.eden.utils;


public class ObjectUtil {
  private ObjectUtil() {}

  /**
   * <p>
   * 해당 값이 null, 공백문자("")이면 true 값을 반환한다.
   * </P>
   *
   * <pre>
   * StringUtil.isEmpty(null)    = true
   * StringUtil.isEmpty("")      = true
   * StringUtil.isEmpty("   ")   = false
   * StringUtil.isEmpty("str")   = false
   * StringUtil.isEmpty(" str ") = false
   * </pre>
   *
   * @param obj (문자형, 숫자형 객체)
   * @return boolean (체크결과)
   */
  public static boolean isEmpty(Object obj) {
    return obj == null || String.valueOf(obj).length() == 0;
  }

  /**
   * <p>
   * 해당 값이 null, 공백문자(""), whitespace(" ")이면 true 값을 반환한다.
   * </p>
   *
   * <pre>
   * StringUtil.isBlank(null)    = true
   * StringUtil.isBlank("")      = true
   * StringUtil.isBlank("   ")   = true
   * StringUtil.isBlank("str")   = false
   * StringUtil.isBlank(" str ") = false
   * </pre>
   *
   * @param obj (문자형, 숫자형 객체)
   * @return boolean (체크결과)
   */
  public static boolean isBlank(Object obj) {
    String str = (obj == null) ? "" : String.valueOf(obj).trim();
    return str.length() == 0;
  }

  /**
   * <p>
   * 객체가 null 일경우 새로운 객체를 반환하고, 그 외는 해당 객체를 리턴한다.
   * </p>
   *
   * <pre>
   * ObjectUtil.replaceNull(null, null)      = null
   * ObjectUtil.replaceNull(null, "")        = ""
   * ObjectUtil.replaceNull(null, "zz")      = "zz"
   * ObjectUtil.replaceNull("abc", *)        = "abc"
   * ObjectUtil.replaceNull(Boolean.TRUE, *) = Boolean.TRUE
   * </pre>
   *
   * @param obj (적용될 객체)
   * @param newObj (새로운 객체)
   * @return Object (적용후 객체)
   */
  public static Object replaceNull(Object obj, Object newObj) {
    return (obj != null) ? obj : newObj;
  }
}
