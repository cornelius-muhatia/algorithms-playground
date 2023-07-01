package com.cmuhatia.playground.leetcode.matrices;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an <b>m x n</b> matrix, return all elements of the matrix in spiral order
 *
 * @see <a href="https://leetcode.com/problems/spiral-matrix/">Spiral Matrix - LeetCode</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpiralMatrix {

    /**
     * Credits to: <a href="https://youtu.be/BJnMZNwUk1M">Neetcode - Youtube</a>
     */
    public static List<Integer> of(int[][] matrix) {
        if (matrix.length == 0) {
            return List.of();
        }

        int arrLength = matrix.length * matrix[0].length;
        List<Integer> results = new ArrayList<>(arrLength);

        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;


        while (left < right && top < bottom) {
            // Moving from left to right
            for (int i = left; i < right; i++) {
                results.add(matrix[top][i]);
            }
            top++;

            // Moving from top-right to bottom
            for (int i = top; i < bottom; i++) {
                results.add(matrix[i][right - 1]);
            }
            right--;

            if (!(left < right && top < bottom)) {
                break;
            }

            // Moving from bottom-right to left
            for (int i = right - 1; i > left - 1; i--) {
                results.add(matrix[bottom - 1][i]);
            }
            bottom--;

            // Moving from bottom to top
            for (int i = bottom - 1; i > top - 1; i--) {
                results.add(matrix[i][left]);
            }
            left++;
        }

        return results;
    }
}
