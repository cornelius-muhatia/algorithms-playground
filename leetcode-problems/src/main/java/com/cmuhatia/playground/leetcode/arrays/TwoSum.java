package com.cmuhatia.playground.leetcode.arrays;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Given an array of integers n and an integer target, return indices of the two numbers such that they add up to target.
 * </p>
 *
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TwoSum {

    public static int[] bruteForce(int[] n, int target) {
        if (n.length < 2) {
            return new int[0];
        }

        int[] ans = new int[2];
        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {

                long sum = n[i] + (long) n[j];
                if (sum == target) {
                    ans[0] = i;
                    ans[1] = j;

                    return ans;
                }

            }
        }

        return new int[0];
    }

    public static int[] of(int[] n, int target) {
        if (n.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> temp = new HashMap<>(n.length, 1);
        for (int i = 0; i < n.length; i++) {
            int value = target - n[i];
            if (temp.containsKey(value)) {
                return new int[]{temp.get(value), i};
            }

            temp.put(n[i], i);
        }

        return new int[0];
    }
}
