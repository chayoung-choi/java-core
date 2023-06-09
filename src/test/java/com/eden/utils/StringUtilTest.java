package com.eden.utils;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
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
