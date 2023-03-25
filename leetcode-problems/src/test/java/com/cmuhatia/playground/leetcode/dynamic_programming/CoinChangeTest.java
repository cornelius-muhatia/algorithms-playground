package com.cmuhatia.playground.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {

    @Test
    void of() {
        assertEquals(-1, CoinChange.of(null, 0));
    }

    @Test
    void of1() {
        assertEquals(0, CoinChange.of(new int[]{5, 10, 20}, 0));
    }

    @Test
    void of2() {
        assertEquals(3, CoinChange.of(new int[]{1, 2, 5}, 11));
    }

    @Test
    void of3() {
        assertEquals(-1, CoinChange.of(new int[]{2}, 3));
    }

    @Test
    void of4() {
        assertEquals(2, CoinChange.of(new int[]{1, 3, 4, 5}, 7));
    }
}