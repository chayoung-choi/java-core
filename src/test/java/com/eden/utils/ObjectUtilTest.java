package com.eden.utils;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ObjectUtilTest {

  @Test
  void isEmpty() {
    assertThat(ObjectUtil.isEmpty(null)).isTrue();
    assertThat(ObjectUtil.isEmpty("")).isTrue();
    assertThat(ObjectUtil.isEmpty(Arrays.asList())).isTrue();

    assertThat(ObjectUtil.isEmpty("  ")).isFalse();
    assertThat(ObjectUtil.isEmpty("str")).isFalse();
    assertThat(ObjectUtil.isEmpty(" str ")).isFalse();
  }
}
