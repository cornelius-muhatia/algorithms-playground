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

/**
 * Rod cutting implementation from Introduction to Algorithms Fourth #dition by Thomas H. Cormen <br />
 * Chapter 14.1
 *
 * @version 1.0.0, 28/08/2022
 */
public class RodCutter {

    public static int cutTopDown(int[] prices, int length) {
        int revenue = 0;
        for (int i = 1; i <= length; i++) {
            revenue = Math.max(revenue, prices[i] + cutTopDown(prices, length - i));
        }

        return revenue;
    }

    public static int cutMemoizedTopDown(int[] prices, int length) {
        int[] cache = new int[prices.length];

        return cutMemoizedTopDown(prices, length, cache);
    }

    public static int cutMemoizedTopDown(int[] prices, int length, int[] cache) {
        if (length == 0) {
            return 0;
        }

        if (cache[length - 1] > 0) {
            return cache[length - 1];
        }

        int revenue = 0;
        for (int i = 1; i <= length; i++) {
            revenue = Math.max(revenue, prices[i] + cutTopDown(prices, length - i));
        }

        cache[length - 1] = revenue;

        return revenue;
    }

    public static int cutBottomUp(int[] prices, int length) {
        int[] cache = new int[length + 1];

        for (int j = 1; j <= length; j++) {
            int revenue = 0;
            for (int i = 1; i <= j; i++) {
                revenue = Math.max(revenue, prices[i] + cache[j - i]);
            }

            cache[j] = revenue;
        }

        return cache[length];
    }

}
