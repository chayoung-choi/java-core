package com.eden.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DateUtilTest {

  @Test
  void test() {
    assertThat(DateUtil.parseDate("2023-06-09")).isInSameDayAs("2023-06-09");
  }
}
