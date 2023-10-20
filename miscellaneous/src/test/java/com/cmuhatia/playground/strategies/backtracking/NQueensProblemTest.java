package com.cmuhatia.playground.strategies.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NQueensProblemTest {

    @Test
    void of() {
        assertTrue(NQueensProblem.of(new int[0][0]));
    }

    @Test
    void of3() {
        int[][] arr = new int[4][4];

        boolean result = NQueensProblem.of(arr);
        assertTrue(result);

        int[][] solution = {
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 0, 1, 0}
        };
        assertArrayEquals(solution, arr);
    }
}