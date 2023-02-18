package com.cmuhatia.playground.strategies.branch_and_bound;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class JobAssignmentTest {

    @Test
    void of() {
        int[][] m = {
                {9, 3, 4},
                {7, 8, 4},
                {10, 5, 2}
        };

        assertArrayEquals(new int[]{1, 0, 2}, JobAssignment.of(m));
    }

    @Test
    void of2() {
        int[][] m = {
                {9, 2, 7, 8},
                {6, 4, 3, 7},
                {5, 8, 1, 8},
                {7, 6, 2, 4}
        };

        assertArrayEquals(new int[]{1, 0, 2, 3}, JobAssignment.of(m));
    }

    @Test
    void of3() {
        assertArrayEquals(new int[0], JobAssignment.of(new int[0][0]));
    }
}