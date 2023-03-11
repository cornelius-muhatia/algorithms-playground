package com.cmuhatia.playground.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumBuyAndSellStockProfitTest {

    @Test
    void of() {
        assertEquals(1, MaximumBuyAndSellStockProfit.of(new int[]{1, 2}));
    }

    @Test
    void of2() {
        assertEquals(0, MaximumBuyAndSellStockProfit.of(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    void of3() {
        assertEquals(5, MaximumBuyAndSellStockProfit.of(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    void of4() {
        assertEquals(0, MaximumBuyAndSellStockProfit.of(new int[]{7}));
    }

    @Test
    void of5() {
        assertEquals(0, MaximumBuyAndSellStockProfit.of(null));
        assertEquals(0, MaximumBuyAndSellStockProfit.of(new int[0]));
    }

}