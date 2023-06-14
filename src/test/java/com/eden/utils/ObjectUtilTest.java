package com.eden.utils;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

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
