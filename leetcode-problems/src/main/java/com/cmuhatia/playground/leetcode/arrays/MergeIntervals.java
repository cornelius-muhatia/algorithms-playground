package com.cmuhatia.playground.leetcode.arrays;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MergeIntervals {

    /**
     * Credits to: <a href="https://youtu.be/44H3cEC2fFM">Merge Intervals - Sorting - Leetcode 56</a>
     */
    public static int[][] of(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        List<int[]> output = new ArrayList<>(intervals.length);
        output.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] latestEntry = getLatestEntry(output);
            if (latestEntry[1] >= intervals[i][0]) {
                latestEntry[1] = Math.max(latestEntry[1], intervals[i][1]);
            } else {
                output.add(intervals[i]);
            }

        }

        return output.toArray(new int[output.size()][2]);
    }

    private static int[] getLatestEntry(List<int[]> output) {
        return output.get(output.size() - 1);
    }
}
