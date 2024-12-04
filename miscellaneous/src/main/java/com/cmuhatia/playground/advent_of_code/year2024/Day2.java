package com.cmuhatia.playground.advent_of_code.year2024;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Advent of code Day 2 Challenge
 *
 * @see https://adventofcode.com/2024/day/2
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day2 {

    public static int countSafeReports(String input) {
        int safeReports = 0;
        String[] reports = input.split(System.lineSeparator());

        for (var report : reports) {
            List<Integer> levels = Arrays.stream(report.split(" ")).map(Integer::valueOf).toList();
            boolean isAscending = levels.getFirst() < levels.getLast();

            for (int i = 1; i < levels.size(); i++) {
                if (isAscending) {
                    var diff = levels.get(i) - levels.get(i - 1);
                    if (diff < 1 || diff > 3) {
                        break;
                    }
                } else {
                    var diff = levels.get(i - 1) - levels.get(i);
                    if (diff < 1 || diff > 3) {
                        break;
                    }
                }

                if (i == levels.size() - 1) safeReports++;
            }
        }

        return safeReports;
    }

    public static int countSafeReportsWithDampener(String input) {
        int safeReports = 0;
        String[] reports = input.split(System.lineSeparator());

        for (var report : reports) {
            List<Integer> levels = Arrays.stream(report.split(" ")).map(Integer::valueOf).toList();

            if (isValidReport(levels, false)) {
                safeReports++;
            }
        }

        return safeReports;
    }

    public static boolean isValidReport(List<Integer> levels, boolean isDampenerActivated) {
        boolean isAscending = levels.getFirst() < levels.getLast();

        for (int i = 1; i < levels.size(); i++) {
            if (isAscending) {
                var diff = levels.get(i) - levels.get(i - 1);
                if (diff < 1 || diff > 3) {
                    if (isDampenerActivated) return false;

                    List<Integer> levels2 = new ArrayList<>(levels);
                    levels2.remove(i);

                    List<Integer> levels3 = new ArrayList<>(levels);
                    levels3.remove(i - 1);

                    return isValidReport(levels2, true) || isValidReport(levels3, true);
                }
            } else {
                var diff = levels.get(i - 1) - levels.get(i);
                if (diff < 1 || diff > 3) {
                    if (isDampenerActivated) return false;

                    List<Integer> levels2 = new ArrayList<>(levels);
                    levels2.remove(i);

                    List<Integer> levels3 = new ArrayList<>(levels);
                    levels3.remove(i - 1);

                    return isValidReport(levels2, true) || isValidReport(levels3, true);
                }
            }

            if (i == levels.size() - 1) return true;
        }

        return false;
    }
}
