package com.cmuhatia.playground.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 28/08/2022
 */
class RodCutterTest {

    int[] priceList = new int[]{0, 1, 5, 8, 8, 10, 17, 20, 24, 30};

    @Test
    public void testCutTopDown() {
        assertEquals(10, RodCutter.cutTopDown(priceList, 4));
    }

    @Test
    public void testCutMemoizedTopDown() {
        assertEquals(10, RodCutter.cutMemoizedTopDown(priceList, 4));
    }

    @Test
    public void testCutBottomUp() {
        assertEquals(10, RodCutter.cutBottomUp(priceList, 4));
    }
}