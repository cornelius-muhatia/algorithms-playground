package com.cmuhatia.playground.leetcode.dynamic_programming;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">LeetCode Climbing Stairs</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClimbingStairs {

    public static int of(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int oneStep = 1;
        int twoStep = 2;

        for (int i = (n - 2); i > 0; i--) {
            int ways = twoStep + oneStep;
            oneStep = twoStep;
            twoStep = ways;
        }

        return twoStep;
    }
}
