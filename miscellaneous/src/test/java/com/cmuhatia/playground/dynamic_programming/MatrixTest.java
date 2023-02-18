package com.cmuhatia.playground.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixTest {

    @Test
    void multiply1() {
        int[][] a = {
                {2, 2},
                {2, 2}
        };
        int[][] b = {
                {2, 2},
                {2, 2}
        };

        int[][] output = new int[2][2];
        Matrix.multiply(a, b, output);

        int[][] expectation = {
                {8, 8},
                {8, 8}
        };
        assertArrayEquals(expectation, output);
    }

    @Test
    void multiply2() {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] b = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        int[][] output = new int[2][2];
        Matrix.multiply(a, b, output);

        int[][] expectation = {
                {58, 64},
                {139, 154}
        };
        assertArrayEquals(expectation, output);
    }

    @Test
    void getMatrixChainMultiplicationSeq() {
        int[] dimensions = {5, 4, 6, 2, 7};

        int[][] s = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 3},
                {0, 0, 0, 2, 3},
                {0, 0, 0, 0, 3},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(s, Matrix.getMatrixChainMultiplicationSeq(dimensions));
    }
}