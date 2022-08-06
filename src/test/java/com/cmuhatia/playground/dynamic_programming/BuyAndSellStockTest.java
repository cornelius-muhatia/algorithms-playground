package com.cmuhatia.playground.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 30/07/2022
 */
class BuyAndSellStockTest {

    @Test
    void getMaximumProfitTopDown() {
        assertEquals(0, BuyAndSellStock.getMaximumProfitRecursively(new int[]{7, 6, 4, 3, 1}));
        assertEquals(5, BuyAndSellStock.getMaximumProfitRecursively(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    void getMaximumProfitBottomUp() {
        assertEquals(1, BuyAndSellStock.getMaximumProfitBottomUp(new int[]{1, 2}));
        assertEquals(0, BuyAndSellStock.getMaximumProfitBottomUp(new int[]{7, 6, 4, 3, 1}));
        assertEquals(5, BuyAndSellStock.getMaximumProfitBottomUp(new int[]{7, 1, 5, 3, 6, 4}));
    }
}