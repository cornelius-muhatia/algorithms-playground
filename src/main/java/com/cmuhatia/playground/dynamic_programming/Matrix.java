package com.cmuhatia.playground.dynamic_programming;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Matrix multiplication implementation from Introduction to Algorithms Fourth #dition by Thomas H. Cormen <br />
 * Chapter 14.2
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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

    /**
     * Solution from <a href="https://www.youtube.com/watch?v=eKkXU3uu2zk">Abdul Bari</a>
     *
     * @param dimensions matrices dimensions
     * @return an array of sub-problem solutions
     */
    public static int[][] getMatrixChainMultiplicationSeq(int[] dimensions) {
        int[][] m = new int[dimensions.length][dimensions.length]; // For storing sub-problem solutions
        int[][] s = new int[dimensions.length][dimensions.length]; // For storing index that provided optimal solution

        for (int subProblemLength = 1; subProblemLength < m.length - 1; subProblemLength++) {
            for (int i = 1; i < m.length - subProblemLength; i++) {
                int j = i + subProblemLength;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int solution = m[i][k] + m[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];

                    if (solution < m[i][j]) {
                        m[i][j] = solution;
                        s[i][j] = k;
                    }
                }
            }
        }

        return s;
    }

}
