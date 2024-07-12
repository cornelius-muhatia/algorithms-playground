package com.cmuhatia.playground.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingSubsequenceTest {

    @Test
    void of() {
        assertEquals(4, LongestIncreasingSubsequence.of(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    @Test
    void of2() {
        assertEquals(4, LongestIncreasingSubsequence.of(new int[]{0, 1, 0, 3, 2, 3}));
    }

    @Test
    void of3() {
        assertEquals(1, LongestIncreasingSubsequence.of(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    @Test
    void of4() {
        assertEquals(5, LongestIncreasingSubsequence.of(new int[]{9, 2, 4, 5, 100, 7, 8}));
    }

    @Test
    void of5() {
        assertEquals(4, LongestIncreasingSubsequence.of(new int[]{3, 4, -1, 0, 6, 2, 3}));
    }

    @Test
    void of6() {
        assertEquals(0, LongestIncreasingSubsequence.of(new int[]{}));
    }

    @Test
    void of7() {
        assertEquals(1, LongestIncreasingSubsequence.of(new int[]{0}));
    }
}