package com.cmuhatia.playground.leetcode.matrices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MatrixZeroesTest {

    @Test
    void of() {
        int[][] matrix = null;
        MatrixZeroes.of(matrix);

        assertNull(matrix);

        int[][] matrix2 = new int[0][0];
        MatrixZeroes.of(matrix2);

        assertArrayEquals(new int[0][0], matrix2);
    }

    @Test
    void of2() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        MatrixZeroes.of(matrix);

        int[][] output = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        assertArrayEquals(output, matrix);
    }

    @Test
    void of3() {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        MatrixZeroes.of(matrix);

        int[][] output = {
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
        };
        assertArrayEquals(output, matrix);
    }

    @Test
    void of4() {
        int[][] matrix = {
                {1, 0, 3, 1}
        };
        MatrixZeroes.of(matrix);

        int[][] output = {
                {0, 0, 0, 0}
        };
        assertArrayEquals(output, matrix);
    }

    @Test
    void of5() {
        int[][] matrix = {
                {1},
                {0},
                {3},
                {1}
        };
        MatrixZeroes.of(matrix);

        int[][] output = {
                {0},
                {0},
                {0},
                {0}
        };
        assertArrayEquals(output, matrix);
    }

    @Test
    void of6() {
        int[][] matrix = {
                {-4, -2147483648, 6, -7, 0},
                {-8, 6, -8, -6, 0},
                {2147483647, 2, -9, -6, -10}
        };
        MatrixZeroes.of(matrix);

        int[][] output = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {2147483647, 2, -9, -6, 0}
        };
        assertArrayEquals(output, matrix);
    }
}