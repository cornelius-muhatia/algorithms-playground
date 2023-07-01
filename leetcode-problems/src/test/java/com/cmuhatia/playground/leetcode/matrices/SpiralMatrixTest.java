package com.cmuhatia.playground.leetcode.matrices;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpiralMatrixTest {

    @Test
    void of() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), SpiralMatrix.of(matrix));
    }

    @Test
    void of2() {
        int[][] matrix = new int[0][0];

        assertTrue(SpiralMatrix.of(matrix).isEmpty());
    }

    @Test
    void of3() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {4, 6, 7, 8},
                {9, 10, 11, 12}
        };

        assertEquals(
                List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 4, 6, 7),
                SpiralMatrix.of(matrix)
        );
    }

    @Test
    void of4() {
        int[][] matrix = {
                {1, 2, 3, 4}
        };

        assertEquals(List.of(1, 2, 3, 4), SpiralMatrix.of(matrix));
    }

    @Test
    void of5() {
        int[][] matrix = {
                {1}
        };

        assertEquals(List.of(1), SpiralMatrix.of(matrix));
    }

    @Test
    void of6() {
        int[][] matrix = {
                {1},
                {2},
                {3},
                {4}
        };

        assertEquals(List.of(1, 2, 3, 4), SpiralMatrix.of(matrix));
    }

    @Test
    void of7() {
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };

        assertEquals(List.of(1, 2, 4, 6, 8, 7, 5, 3), SpiralMatrix.of(matrix));
    }
}