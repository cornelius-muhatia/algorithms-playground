package com.cmuhatia.playground.leetcode.matrices;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * <p>Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.</p>
 *
 * @see <a href="https://leetcode.com/problems/set-matrix-zeroes/">LeetCode Set Matrix Zeroes</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MatrixZeroes {

    /**
     * Credits to: <a href="https://youtu.be/T41rL0L3Pnw">NeedCode</a>
     */
    public static void of(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int firstRow = determineZerosPositions(matrix);

        insertZeros(matrix);

        insertFirstColZeros(matrix);

        insertFirstRowZeros(matrix, firstRow);
    }

    private static int determineZerosPositions(int[][] matrix) {
        int firstRow = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                }

                if (i == 0 && matrix[i][j] == 0) {
                    firstRow = 0;
                } else if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                }
            }
        }
        return firstRow;
    }

    private static void insertZeros(int[][] matrix) {
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }

                if (matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    private static void insertFirstRowZeros(int[][] matrix, int firstRow) {
        if (firstRow == 0) {
            Arrays.fill(matrix[0], 0);
        }
    }

    private static void insertFirstColZeros(int[][] matrix) {
        if (matrix.length > 0 && matrix[0][0] == 0) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
