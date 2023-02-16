package com.cmuhatia.playground.leetcode.binary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumIntegersTest {

    @Test
    void of() {
        assertEquals(3, SumIntegers.of(1, 2));
    }

    @Test
    void of2() {
        assertEquals(5, SumIntegers.of(2, 3));
    }

    @Test
    void of3() {
        assertEquals(1900, SumIntegers.of(1000, 900));
    }

    @Test
    void of4() {
        assertEquals(-100, SumIntegers.of(-1000, 900));
    }
}