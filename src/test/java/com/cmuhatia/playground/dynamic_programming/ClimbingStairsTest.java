package com.cmuhatia.playground.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 23/07/2022
 */
class ClimbingStairsTest {

    @Test
    void getAscendingMethods() {
        assertEquals(0, ClimbingStairs.getTopDownAscendingMethods(0));
        assertEquals(1, ClimbingStairs.getTopDownAscendingMethods(1));
        assertEquals(2, ClimbingStairs.getTopDownAscendingMethods(2));
        assertEquals(3, ClimbingStairs.getTopDownAscendingMethods(3));
        assertEquals(8, ClimbingStairs.getTopDownAscendingMethods(5));
    }

    @Test
    void getBottomUpAscendingMethods() {
        assertEquals(0, ClimbingStairs.getBottomUpAscendingMethods(0));
        assertEquals(1, ClimbingStairs.getBottomUpAscendingMethods(1));
        assertEquals(2, ClimbingStairs.getBottomUpAscendingMethods(2));
        assertEquals(3, ClimbingStairs.getBottomUpAscendingMethods(3));
        assertEquals(8, ClimbingStairs.getBottomUpAscendingMethods(5));
    }
}