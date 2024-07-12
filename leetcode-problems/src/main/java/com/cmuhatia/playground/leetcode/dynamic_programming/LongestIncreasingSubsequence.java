package com.cmuhatia.playground.leetcode.dynamic_programming;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/longest-increasing-subsequence/">LeetCode - Longest Increasing Subsequence</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LongestIncreasingSubsequence {

    /**
     * Credits to <a href="https://youtu.be/CE2b_-XfVDk?si=u4wZnDpEDIh69zjx">Tushar Roy - Coding Made Simple</a>
     */
    public static int of(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int[] dp = new int[numbers.length];
        dp[0] = 1;

        int maxLength = 1;

        for (int i = 1; i < numbers.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
