package com.cmuhatia.playground.leetcode.intervals;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/non-overlapping-intervals/description/">Leetcode - Non-overlapping Intervals</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NonOverlappingIntervals {

    /**
     * Credits to <a href="https://walkccc.me/LeetCode/problems/435/#__tabbed_1_2">LeetCode Solutions</a>
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[1]));

        int count = 0;
        int previous = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (previous > intervals[i][0]) {
                count++;

                continue;
            }

            previous = intervals[i][1];
        }

        return count;
    }
}
