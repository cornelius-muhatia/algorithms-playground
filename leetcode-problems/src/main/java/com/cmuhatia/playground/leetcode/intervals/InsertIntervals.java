package com.cmuhatia.playground.leetcode.intervals;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [start<sub>i</sub>, end<sub>i</sub>] represent the start and the end of the ith interval and intervals is sorted in ascending order by start<sub>i</sub>.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * </p>
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by start<sub>i</sub> and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/insert-interval">LeetCode Insert Intervals</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InsertIntervals {

    /**
     * @see <a href="https://youtu.be/A8NUOmlwOlM">Original Solution From Youtube NeetCode Channel</a>
     */
    public static int[][] of(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            return new int[0][0];
        }

        List<int[]> output = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                output.add(newInterval);
                append(output, intervals, i);

                return mapListToIntervals(output);
            }

            if (newInterval[0] > intervals[i][1]) {
                output.add(intervals[i]);
                continue;
            }

            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
        }

        output.add(newInterval);

        return mapListToIntervals(output);
    }

    private static void append(List<int[]> output, int[][] intervals, int startIdx) {
        for (int i = startIdx; i < intervals.length; i++) {
            output.add(intervals[i]);
        }
    }

    private static int[][] mapListToIntervals(List<int[]> output) {
        return output.toArray(new int[output.size()][2]);
    }
}
