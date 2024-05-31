package com.cmuhatia.playground.leetcode.binary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountingBitsTest {

    @Test
    void of() {
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, CountingBits.of2(5));
    }

    @Test
    void of2() {
        assertArrayEquals(new int[]{0, 1, 1,}, CountingBits.of(2));
    }

}