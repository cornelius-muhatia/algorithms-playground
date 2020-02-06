package com.cmuhatia.playground;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.fail;

public class MatrixOperationsTest {


    @Test
    public void diagonalDifference(){
        int[][] arr = {{1,2,3},{4, 5, 6},{9, 8,9}};
        List<List<Integer>> list = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(9, 8, 9));
        //Happy path
        Assert.assertEquals(2, MatrixOperations.diagonalDifference(arr));
        Assert.assertEquals(2, MatrixOperations.diagonalDifference(list));

        //Medium test
        list = List.of(List.of(-1, -4, -9, -10), List.of(-16, -6, -18, -20), List.of(-36, -4, -2, -14), List.of(-18, -14, -1, 0));
        Assert.assertEquals(41, MatrixOperations.diagonalDifference(list));

    }

}