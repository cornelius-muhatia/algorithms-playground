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
        int middleIndex = arr.size() % 2 == 0 ? (arr.size() / 2) - 1 : arr.size() / 2;
        System.out.println("==========================> Middle Index: " + middleIndex);
        int result = (arr.get(0).get(0) + arr.get(middleIndex).get(middleIndex) + arr.get(arr.size() - 1).get(arr.size() - 1)) -
                (arr.get(arr.size() - 1).get(0) + arr.get(middleIndex).get(middleIndex) + arr.get(0).get(arr.size() - 1));
        return Math.abs(result);
    }

}
