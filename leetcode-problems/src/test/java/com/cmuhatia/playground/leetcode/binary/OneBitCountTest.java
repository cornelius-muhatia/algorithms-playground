package com.cmuhatia.playground.leetcode.binary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OneBitCountTest {

    @Test
    void of() {
        assertEquals(0, OneBitCount.of(0));
    }

    @Test
    void of2() {
        assertEquals(2, OneBitCount.of(9));
    }

    @Test
    void of3() {
        assertEquals(9, OneBitCount.of(11111));
    }

    @Test
    void of4() {
        assertEquals(31, OneBitCount.of(Integer.MAX_VALUE));
    }
}