package com.cmuhatia.playground.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsTest {

    @Test
    void of1() {
        assertEquals(0, ClimbingStairs.of(0));
    }

    @Test
    void of2() {
        assertEquals(1, ClimbingStairs.of(1));
    }

    @Test
    void of3() {
        assertEquals(2, ClimbingStairs.of(2));
    }

    @Test
    void of4() {
        assertEquals(3, ClimbingStairs.of(3));
    }

    @Test
    void of5() {
        assertEquals(8, ClimbingStairs.of(5));
    }
}