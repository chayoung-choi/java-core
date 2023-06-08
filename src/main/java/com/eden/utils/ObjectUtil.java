package com.eden.utils;


import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class ObjectUtil {

  private ObjectUtil() {
  }

  /**
   * <p>
   * 해당 값이 null, 공백문자, length=0이면 true 값을 반환한다.
   * </p>
   *
   * <pre>
   * isEmpty(null)    = true
   * isEmpty("")      = true
   * isEmpty("   ")   = false
   * isEmpty("str")   = false
   * isEmpty(" str ") = false
   * </pre>
   *
   * @param o 객체
   * @return boolean (체크결과)
   */
  public static boolean isEmpty(Object o) {
    if (o == null) {
      return true;
    } else if (o instanceof Optional) {
      return ((Optional<?>) o).isEmpty();
    } else if (o instanceof String string) {
      return string.length() == 0;
    } else if (o.getClass().isArray()) {
      return Array.getLength(o) == 0;
    } else if (o instanceof Collection) {
      return ((Collection<?>) o).isEmpty();
    } else if (o instanceof Map) {
      return ((Map<?, ?>) o).isEmpty();
    }
    return false;
  }

  /**
   * <p>
   * 해당 값이 빈값(null, 공백, length=0)이 아니면 true 값을 반환한다.
   * </p>
   *
   * @param o 객체
   * @return boolean (체크결과)
   */
  public static boolean isNotEmpty(Object o) {
    return !isEmpty(o);
  }

  /**
   * <p>
   * 객체가 null 일경우 새로운 객체를 반환하고, 그 외는 해당 객체를 리턴한다.
   * </p>
   *
   * <pre>
   * replaceNull(null, null)      = null
   * replaceNull(null, "")        = ""
   * replaceNull(null, "zz")      = "zz"
   * replaceNull("abc", *)        = "abc"
   * replaceNull(Boolean.TRUE, *) = Boolean.TRUE
   * </pre>
   *
   * @param o    (적용될 객체)
   * @param newO (새로운 객체)
   * @return Object (적용후 객체)
   */
  public static Object replaceNull(Object o, Object newO) {
    return (o != null) ? o : newO;
  }
}
