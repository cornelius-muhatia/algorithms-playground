package com.cmuhatia.playground.advent_of_code.year2024;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Advent of code Day 3 Challenge
 *
 * @see https://adventofcode.com/2024/day/4
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day4 {

    final static String XMAS = "XMAS";

    public static int xmasWordCount(String input) {
        int xMasCount = 0;
        String[] lines = input.split(System.lineSeparator());

        for (var i = 0; i < lines.length; i++) {
            xMasCount += countXmasHorizontally(lines[i]);

            xMasCount += countSamxHorizontally(lines[i]);

            xMasCount += countXmasVertically(lines, i);

            xMasCount += reverseCountXmasVertically(lines, i);

            xMasCount += countRightDiagonalDown(lines, i);

            xMasCount += reverseCountRightDiagonalDown(lines, i);

            xMasCount += countLeftDiagonalDown(lines, i);

            xMasCount += reverseCountLeftDiagonalDown(lines, i);
        }

        return xMasCount;
    }

    static int countXmasHorizontally(String line) {
        int count = 0;
        int nextXmasIdx = line.indexOf(XMAS);

        while (nextXmasIdx != -1) {
            count++;
            nextXmasIdx = line.indexOf(XMAS, nextXmasIdx + 1);
        }

        return count;
    }

    static int countSamxHorizontally(String line) {
        String samx = "SAMX";

        int count = 0;
        int nextXmasIdx = line.indexOf(samx);

        while (nextXmasIdx != -1) {
            count++;
            nextXmasIdx = line.indexOf(samx, nextXmasIdx + 1);
        }

        return count;
    }

    static int countXmasVertically(String[] lines, int currentIdx) {
        int count = 0;

        if (currentIdx + 4 > lines.length) {
            return count;
        }

        for (int i = 0; i < lines[currentIdx].length(); i++) {
            if (
                    lines[currentIdx].charAt(i) == 'X' &&
                            lines[currentIdx + 1].charAt(i) == 'M' &&
                            lines[currentIdx + 2].charAt(i) == 'A' &&
                            lines[currentIdx + 3].charAt(i) == 'S'
            ) {
                count++;
            }
        }

        return count;
    }

    static int reverseCountXmasVertically(String[] lines, int currentIdx) {
        int count = 0;

        if (currentIdx + 4 > lines.length) {
            return count;
        }

        for (int i = 0; i < lines[currentIdx].length(); i++) {
            if (
                    lines[currentIdx].charAt(i) == 'S' &&
                            lines[currentIdx + 1].charAt(i) == 'A' &&
                            lines[currentIdx + 2].charAt(i) == 'M' &&
                            lines[currentIdx + 3].charAt(i) == 'X'
            ) {
                count++;
            }
        }

        return count;
    }

    static int countRightDiagonalDown(String[] lines, int currentIdx) {
        int count = 0;

        if (currentIdx + 4 > lines.length) {
            return count;
        }

        for (int i = 0; i < lines[currentIdx].length() - 3; i++) {
            if (
                    lines[currentIdx].charAt(i) == 'X' &&
                            lines[currentIdx + 1].charAt(i + 1) == 'M' &&
                            lines[currentIdx + 2].charAt(i + 2) == 'A' &&
                            lines[currentIdx + 3].charAt(i + 3) == 'S'
            ) {
                count++;
            }
        }

        return count;
    }

    static int reverseCountRightDiagonalDown(String[] lines, int currentIdx) {
        int count = 0;

        if (currentIdx + 4 > lines.length) {
            return count;
        }

        for (int i = 0; i < lines[currentIdx].length() - 3; i++) {
            if (
                    lines[currentIdx].charAt(i) == 'S' &&
                            lines[currentIdx + 1].charAt(i + 1) == 'A' &&
                            lines[currentIdx + 2].charAt(i + 2) == 'M' &&
                            lines[currentIdx + 3].charAt(i + 3) == 'X'
            ) {
                count++;
            }
        }

        return count;
    }

    static int countLeftDiagonalDown(String[] lines, int currentIdx) {
        int count = 0;

        if (currentIdx + 4 > lines.length) {
            return count;
        }

        for (int i = lines[currentIdx].length() - 1; i >= 3; i--) {
            if (
                    lines[currentIdx].charAt(i) == 'X' &&
                            lines[currentIdx + 1].charAt(i - 1) == 'M' &&
                            lines[currentIdx + 2].charAt(i - 2) == 'A' &&
                            lines[currentIdx + 3].charAt(i - 3) == 'S'
            ) {
                count++;
            }
        }

        return count;
    }

    static int reverseCountLeftDiagonalDown(String[] lines, int currentIdx) {
        int count = 0;

        if (currentIdx + 4 > lines.length) {
            return count;
        }

        for (int i = lines[currentIdx].length() - 1; i >= 3; i--) {
            if (
                    lines[currentIdx].charAt(i) == 'S' &&
                            lines[currentIdx + 1].charAt(i - 1) == 'A' &&
                            lines[currentIdx + 2].charAt(i - 2) == 'M' &&
                            lines[currentIdx + 3].charAt(i - 3) == 'X'
            ) {
                count++;
            }
        }

        return count;
    }

    public static int part2XmasWordCount(String input) {
        int xMasCount = 0;
        String[] lines = input.split(System.lineSeparator());

        for (int row = 0; row <= lines.length - 3; row++) {

            String line = lines[row];
            for (int col = 0; col <= line.length() - 3; col++) {
                if (
                        line.charAt(col) == 'M' && line.charAt(col + 2) == 'S'
                                && lines[row + 1].charAt(col + 1) == 'A'
                                && lines[row + 2].charAt(col) == 'M' && lines[row + 2].charAt(col + 2) == 'S'
                ) {
                    xMasCount++;
                }
            }

            for (int col = 0; col <= line.length() - 3; col++) {
                if (
                        line.charAt(col) == 'S' && line.charAt(col + 2) == 'M'
                                && lines[row + 1].charAt(col + 1) == 'A'
                                && lines[row + 2].charAt(col) == 'S' && lines[row + 2].charAt(col + 2) == 'M'
                ) {
                    xMasCount++;
                }
            }

            for (int col = 0; col <= line.length() - 3; col++) {
                if (
                        line.charAt(col) == 'S' && line.charAt(col + 2) == 'S'
                                && lines[row + 1].charAt(col + 1) == 'A'
                                && lines[row + 2].charAt(col) == 'M' && lines[row + 2].charAt(col + 2) == 'M'
                ) {
                    xMasCount++;
                }
            }

            for (int col = 0; col <= line.length() - 3; col++) {
                if (
                        line.charAt(col) == 'M' && line.charAt(col + 2) == 'M'
                                && lines[row + 1].charAt(col + 1) == 'A'
                                && lines[row + 2].charAt(col) == 'S' && lines[row + 2].charAt(col + 2) == 'S'
                ) {
                    xMasCount++;
                }
            }
        }

        return xMasCount;
    }
}
