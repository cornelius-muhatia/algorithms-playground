package com.cmuhatia.playground.leetcode.intervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NonOverlappingIntervalsTest {

    @Test
    void eraseOverlapIntervals() {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        assertEquals(1, NonOverlappingIntervals.eraseOverlapIntervals(intervals));
    }

    @Test
    void eraseOverlapIntervals2() {
        int[][] intervals = {
                {1, 2},
                {1, 2},
                {1, 2}
        };

        assertEquals(2, NonOverlappingIntervals.eraseOverlapIntervals(intervals));
    }

    @Test
    void eraseOverlapIntervals3() {
        int[][] intervals = {
                {1, 2},
                {2, 3}
        };

        assertEquals(0, NonOverlappingIntervals.eraseOverlapIntervals(intervals));
    }

    @Test
    void eraseOverlapIntervals4() {
        int[][] intervals = {
                {-5, -4},
                {0, 2},
                {-2, 1},
                {-4, 0}
        };

        assertEquals(1, NonOverlappingIntervals.eraseOverlapIntervals(intervals));
    }

    @Test
    void eraseOverlapIntervals5() {
        int[][] intervals = {
                {1, 100},
                {11, 22},
                {1, 11},
                {2, 12}
        };

        assertEquals(2, NonOverlappingIntervals.eraseOverlapIntervals(intervals));
    }

    @Test
    void eraseOverlapIntervals6() {
        int[][] intervals = {
                {0, 1},
                {3, 4},
                {1, 2}
        };

        assertEquals(0, NonOverlappingIntervals.eraseOverlapIntervals(intervals));
    }
}