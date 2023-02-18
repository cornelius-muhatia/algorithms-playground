package com.cmuhatia.playground.maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixOperationsTest {

    @Test
    void rotate90DegClwInPlace1() {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expectedResult = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        MatrixOperations.rotate90DegClwInPlace(arr);

        Assertions.assertArrayEquals(expectedResult, arr);
    }

    @Test
    void rotate90DegClwInPlace2() {
        int[][] arr = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };
        int[][] expectedResult = {
                {31, 25, 19, 13, 7, 1},
                {32, 26, 20, 14, 8, 2},
                {33, 27, 21, 15, 9, 3},
                {34, 28, 22, 16, 10, 4},
                {35, 29, 23, 17, 11, 5},
                {36, 30, 24, 18, 12, 6}
        };

        MatrixOperations.rotate90DegClwInPlace(arr);

        Assertions.assertArrayEquals(expectedResult, arr);
    }
}