package com.eden.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberUtilTest {

  @Test
  void isNumber() {
    assertThat(NumberUtil.isNumber(123)).isTrue();
    assertThat(NumberUtil.isNumber("123")).isTrue();
    assertThat(NumberUtil.isNumber("687354232")).isTrue();

    assertThat(NumberUtil.isNumber(null)).isFalse();
    assertThat(NumberUtil.isNumber("")).isFalse();
    assertThat(NumberUtil.isNumber("1a")).isFalse();
    assertThat(NumberUtil.isNumber("*1")).isFalse();
  }
}
