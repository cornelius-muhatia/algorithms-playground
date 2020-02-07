package com.cmuhatia.playground;

import java.util.List;

/**
 * Matrix operations
 */
public class MatrixOperations {

    /**
     * Diagonal difference
     *
     * @param arr array representing a square matrix
     * @return absolute diagonal difference
     */
    public static int diagonalDifference(int[][] arr){
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i < arr.length; i++ ){
            c1 += arr[i][i];
            int j = arr.length - i - 1;
            c2 += arr[i][j];
        }
        return Math.abs(c1 - c2);
    }

    /**
     * Calculates absolute diagonal difference of a squared matrix
     *
     * @param arr list storing the matrix
     * @return absolute difference
     */
    public static int diagonalDifference(List<List<Integer>> arr){
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i < arr.size(); i++ ){
            c1 += arr.get(i).get(i);
            int j = arr.size() - i - 1;
            c2 += arr.get(i).get(j);
        }
        return Math.abs(c1 - c2);
    }

}
