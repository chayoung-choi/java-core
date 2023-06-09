package com.eden.utils;

import static com.eden.utils.ObjectUtil.isEmpty;

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

  /**
   * <p>
   * 해당 값에서 특정 문자가 몇개인지 체크후 리턴한다.
   * </p>
   *
   * <pre>
   * StringUtil.countMatches(null, *)    = 0
   * StringUtil.countMatches("", *)      = 0
   * StringUtil.countMatches(*, null)    = 0
   * StringUtil.countMatches(*, "")      = 0
   * StringUtil.countMatches("abb1", 1)  = 1
   * StringUtil.countMatches("abb", "b") = 2
   * StringUtil.countMatches(1237377, 7) = 3
   * </pre>
   *
   * @param obj     (검색할 문자형, 숫자형 객체)
   * @param keyword (문자형, 숫자형 검색어)
   * @return int (메칭되는 수)
   */
  public static int countMatches(Object obj, Object keyword) {
    if (isEmpty(obj) || isEmpty(keyword)) {
      return 0;
    }
    int count = 0;
    int idx = 0;
    String objStr = obj.toString();
    String keywordStr = keyword.toString();

    while ((idx = objStr.indexOf(keywordStr, idx)) != -1) {
      count++;
      idx += keywordStr.length();
    }
    return count;
  }
}
