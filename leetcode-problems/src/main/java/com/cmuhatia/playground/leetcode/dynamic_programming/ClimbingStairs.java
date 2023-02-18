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

        if (n == 2) {
            return 2;
        }

        int j = 1;
        int k = 2;

        for (int i = 3; i <= n; i++) {
            int temp = k + j;
            j = k;
            k = temp;
        }

        return k;

    }
}
