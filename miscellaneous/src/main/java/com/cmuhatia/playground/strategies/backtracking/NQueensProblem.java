package com.cmuhatia.playground.strategies.backtracking;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NQueensProblem {

    /**
     * Credits to: <a href="https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/">
     * Geeks for Geeks - N Queens problem solution</a>
     */
    public static boolean of(int[][] chessBoard) {
        if (chessBoard.length == 0) {
            return true;
        }

        return placeQueen(chessBoard, 0);
    }

    private static boolean placeQueen(int[][] chessBoard, int row) {
        if (row == chessBoard.length) {
            return true;
        }

        for (int col = 0; col < chessBoard[0].length; col++) {
            if (isUnderAttack(chessBoard, row, col)) {
                continue;
            }

            chessBoard[row][col] = 1;
            if (placeQueen(chessBoard, row + 1)) {
                return true;
            }

            chessBoard[row][col] = 0;
        }

        return false;
    }

    private static boolean isUnderAttack(int[][] chessBoard, int row, int col) {
        // Check if the previous columns have a queen
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 1) {
                return true;
            }
        }

        for (int prevRow = row - 1, prevCol = col - 1; prevRow >= 0 && prevCol >= 0; prevRow--, prevCol--) {
            if (chessBoard[prevRow][prevCol] == 1) {
                return true;
            }
        }

        for (int prevRow = row - 1, nextCol = col + 1; prevRow >= 0 && nextCol < chessBoard[0].length; prevRow--, nextCol++) {
            if (chessBoard[prevRow][nextCol] == 1) {
                return true;
            }
        }

        return false;
    }
}
