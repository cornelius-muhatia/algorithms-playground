package com.cmuhatia.playground.leetcode.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    @Test
    void of() {
        Assertions.assertArrayEquals(new int[0], TwoSum.bruteForce(new int[]{3}, 3));
        Assertions.assertArrayEquals(new int[0], TwoSum.of(new int[]{3}, 3));
    }

    @Test
    void of2() {
        Assertions.assertArrayEquals(new int[]{1, 2}, TwoSum.bruteForce(new int[]{3, 2, 4}, 6));
        Assertions.assertArrayEquals(new int[]{1, 2}, TwoSum.of(new int[]{3, 2, 4}, 6));
    }

    @Test
    void of3() {
        Assertions.assertArrayEquals(new int[]{0, 1}, TwoSum.bruteForce(new int[]{3, 3}, 6));
        Assertions.assertArrayEquals(new int[]{0, 1}, TwoSum.of(new int[]{3, 3}, 6));
    }
}