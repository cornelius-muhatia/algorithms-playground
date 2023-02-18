package com.cmuhatia.playground.dynamic_programming;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MaximumSubArray {

    /**
     * Kadane's algorithm algorithm
     */
    public static int getMaximumSum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int sum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int j : arr) {
            currentSum = Math.max(j, currentSum + j);
            sum = Math.max(sum, currentSum);
        }

        return sum;
    }

}
