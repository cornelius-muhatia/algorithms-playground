package com.cmuhatia.playground.leetcode.dynamic_programming;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>
 * You are given an integer array coins representing coins of different denominations and an integer amount
 * representing a total amount of money.
 * </p>
 *
 * <p>
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * </p>
 *
 * <p>You may assume that you have an infinite number of each kind of coin.</p>
 *
 * @see <a href="https://leetcode.com/problems/coin-change/">LeetCode - Coin Change</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoinChange {

    /**
     * Credits to <a href="https://youtu.be/H9bfqozjoqs">NeetCode</a>
     */
    public static int of(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }

        Integer[] subProblems = new Integer[amount + 1];
        subProblems[0] = 0;

        for (int amt = 1; amt < subProblems.length; amt++) {
            for (int coin : coins) {
                int rem = amt - coin;

                if (rem >= 0 && subProblems[rem] != null) {
                    int currentChange = 1 + subProblems[rem];
                    subProblems[amt] = (subProblems[amt] == null)
                            ? currentChange
                            : Math.min(subProblems[amt], currentChange);
                }
            }
        }

        return subProblems[amount] == null ? -1 : subProblems[amount];
    }
}
