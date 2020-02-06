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
        int middleIndex = (arr.length % 2);
        int result = (arr[0][0] + arr[middleIndex][middleIndex] + arr[arr.length - 1][arr.length - 1]) -
                (arr[arr.length - 1][0] + arr[middleIndex][middleIndex] + arr[0][arr.length - 1]);

        return Math.abs(result);
    }

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
