package com.cmuhatia.playground.maths;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Matrix operations
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MatrixOperations {

    /**
     * Diagonal difference
     *
     * @param arr array representing a square matrix
     * @return absolute diagonal difference
     */
    public static int diagonalDifference(int[][] arr) {
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < arr.length; i++) {
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
    public static int diagonalDifference(List<List<Integer>> arr) {
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            c1 += arr.get(i).get(i);
            int j = arr.size() - i - 1;
            c2 += arr.get(i).get(j);
        }
        return Math.abs(c1 - c2);
    }

    /**
     * Rotate array 90 degrees clockwise.
     *
     * @param array target array
     * @return a new rotated array
     */
    public static int[][] rotate90DegClw(int[][] array) {
        int[][] tempArray = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            int lIndex = array.length - 1 - i;
            for (int j = 0; j < array.length; j++) {
                tempArray[j][lIndex] = array[i][j];
            }
        }
        return tempArray;
    }

    /**
     * Rotate array 90 degrees clockwise. Modified from:<br/>
     * <a href="https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/">GeeksForGeeks</a>
     *
     * @param array target array
     */
    public static void rotate90DegClwInPlace(int[][] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int lastIdx = array.length - 1 - i;

            for (int j = i; j < lastIdx; j++) {
                int temp = array[i][j];
                int nextValIdx = array.length - 1 - j;

                //move elements to the right
                array[i][j] = array[nextValIdx][i];

                //move elements vertically up from the left
                array[nextValIdx][i] = array[lastIdx][nextValIdx];

                //move elements to the left from the bottom
                array[lastIdx][nextValIdx] = array[j][lastIdx];

                //move elements vertically down from the right
                array[j][lastIdx] = temp;
            }
        }
    }
}
