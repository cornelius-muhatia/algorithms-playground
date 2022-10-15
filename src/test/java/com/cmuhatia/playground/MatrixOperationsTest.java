package com.cmuhatia.playground;


import com.cmuhatia.playground.maths.MatrixOperations;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixOperationsTest {


    @Test
    void diagonalDifference() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {9, 8, 9}};
        List<List<Integer>> list = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(9, 8, 9));
        //Happy path
        assertEquals(2, MatrixOperations.diagonalDifference(arr));
        assertEquals(2, MatrixOperations.diagonalDifference(list));

        //Medium test
        list = List.of(List.of(-1, -4, -9, -10), List.of(-16, -6, -18, -20), List.of(-36, -4, -2, -14), List.of(-18, -14, -1, 0));
        assertEquals(41, MatrixOperations.diagonalDifference(list));
    }

    @Test
    void rotate90DegClw() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] tempArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertEquals(tempArray, MatrixOperations.rotate90DegClw(array));
    }
}