package com.cmuhatia.playground.dynamic_programming;

/**
 * Matrix multiplication implementation from Introduction to Algorithms Fourth #dition by Thomas H. Cormen <br />
 * Chapter 14.2
 */
public class Matrix {

    public static void multiply(int[][] a, int[][] b, int[][] output) {
        int aCols = getColumnCount(a);
        int bCols = getColumnCount(b);

        for (int aRow = 0; aRow < a.length; aRow++) {
            for (int bCol = 0; bCol < bCols; bCol++) {
                for (int aCol = 0; aCol < aCols; aCol++) {
                    output[aRow][bCol] = output[aRow][bCol] + a[aRow][aCol] * b[aCol][bCol];
                }
            }
        }
    }

    private static int getColumnCount(int[][] matrix) {
        if (matrix.length > 0) {
            return matrix[0].length;
        }

        return 0;
    }

}
