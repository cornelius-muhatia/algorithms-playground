package com.cmuhatia.playground.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 23/07/2022
 */
class ClimbingStairsTest {

    @Test
    void getAscendingMethods() {
        assertEquals(2, ClimbingStairs.getAscendingMethods(2));

        assertEquals(3, ClimbingStairs.getAscendingMethods(3));
    }
}