package com.cmuhatia.playground.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeIntervalsTest {

    @Test
    void of() {
        assertArrayEquals(new int[0][0], MergeIntervals.of(new int[0][0]));
    }

    @Test
    void of2() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(
                new int[][]{{1, 6}, {8, 10}, {15, 18}},
                MergeIntervals.of(intervals)
        );
    }

    @Test
    void of3() {
        int[][] intervals = {{1, 4}, {4, 5}};
        assertArrayEquals(
                new int[][]{{1, 5}},
                MergeIntervals.of(intervals)
        );
    }
}