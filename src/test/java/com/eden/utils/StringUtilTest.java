package com.eden.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringUtilTest {

  @Test
  void isBlank() {
    assertThat(StringUtil.isBlank(null)).isTrue();
    assertThat(StringUtil.isBlank("")).isTrue();
    assertThat(StringUtil.isBlank("  ")).isTrue();

    assertThat(StringUtil.isBlank("str")).isFalse();
    assertThat(StringUtil.isBlank(" str ")).isFalse();
  }
}
