package com.cmuhatia.playground.strategies.sliding_window;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MaximumSubArraySum {
    public static int of(int[] arr, int range) {
        if (range > arr.length) {
            return -1;
        }

        int maxSum = 0;
        for (int i = 0; i < range; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        for (int i = range; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - range];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
