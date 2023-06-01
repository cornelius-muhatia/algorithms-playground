package com.cmuhatia.playground.leetcode.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseScheduleTest {

    @Test
    void of() {
        assertTrue(CourseSchedule.of(2, new int[][]{{1, 0}}));
    }

    @Test
    void of2() {
        int[][] input = {
                {1, 0},
                {0, 1}
        };
        assertFalse(CourseSchedule.of(2, input));
    }

    @Test
    void of3() {
        int[][] input = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {3, 4}
        };
        assertTrue(CourseSchedule.of(5, input));
    }
}