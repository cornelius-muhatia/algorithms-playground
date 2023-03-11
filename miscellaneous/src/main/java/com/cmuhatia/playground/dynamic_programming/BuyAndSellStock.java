/*
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cmuhatia.playground.dynamic_programming;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day. <br />
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. <br />
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * @version 1.0.0, 30/07/2022
 * @see <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/572/">LeetCode</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BuyAndSellStock {
    public static int getMaximumProfitRecursively(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        return getMaximumProfitRecursively(prices, 1, 0, 0);
    }

    private static int getMaximumProfitRecursively(int[] prices, int idx, int selectedIdx, int profit) {
        if (idx >= prices.length) {
            return profit;
        }

        int currentIdxProfit = Math.max(profit, prices[idx] - prices[selectedIdx]);

        return Math.max(
                getMaximumProfitRecursively(prices, idx + 1, idx, currentIdxProfit),
                getMaximumProfitRecursively(prices, idx + 1, selectedIdx, profit)
        );
    }

    public static int getMaximumProfitBottomUp(int[] prices) {
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
