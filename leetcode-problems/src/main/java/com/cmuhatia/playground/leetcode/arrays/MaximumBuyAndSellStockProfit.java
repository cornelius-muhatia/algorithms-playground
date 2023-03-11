package com.cmuhatia.playground.leetcode.arrays;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * </p>
 *
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">LeetCode - Best Time to Buy and Sell Stock</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MaximumBuyAndSellStockProfit {

    public static int of(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int profit = 0;
        int selectedDay = prices[prices.length - 1];

        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] < selectedDay) {
                profit = Math.max((selectedDay - prices[i]), profit);
                continue;
            }

            if (prices[i] > selectedDay) {
                selectedDay = prices[i];
            }
        }

        return profit;
    }
}
