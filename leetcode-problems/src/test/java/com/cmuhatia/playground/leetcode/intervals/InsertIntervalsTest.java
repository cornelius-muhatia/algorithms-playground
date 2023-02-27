package com.cmuhatia.playground.leetcode.intervals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertIntervalsTest {

    @Test
    void of() {
        assertArrayEquals(new int[0][0], InsertIntervals.of(null, null));
    }

    @Test
    void of2() {
        int[][] intervals = {
                {1, 3},
                {6, 9}
        };
        int[] newInterval = {2, 5};

        int[][] output = {
                {1, 5},
                {6, 9}
        };

        assertArrayEquals(output, InsertIntervals.of(intervals, newInterval));
    }

    @Test
    @DisplayName("Can insert interval at the beginning of the intervals")
    void of3() {
        int[][] intervals = {
                {3, 6},
                {7, 9}
        };
        int[] newInterval = {1, 2};

        int[][] output = {
                {1, 2},
                {3, 6},
                {7, 9}
        };

        assertArrayEquals(output, InsertIntervals.of(intervals, newInterval));
    }
}