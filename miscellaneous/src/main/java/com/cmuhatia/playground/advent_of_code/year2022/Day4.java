package com.cmuhatia.playground.advent_of_code.year2022;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @see <a href="https://adventofcode.com/2022/day/4">Advent of Code 2022 Day 4</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day4 {

    public static int getFullyContainedAssignments(String[] input) {
        int count = 0;

        for (String pair : input) {
            String[] assignments = pair.split(",");

            int firstElfLowerBound = getLowerBound(assignments[0]);
            int firstElfUpperBound = getUpperBound(assignments[0]);

            int secondElfLowerBound = getLowerBound(assignments[1]);
            int secondElfUpperBound = getUpperBound(assignments[1]);

            if ((firstElfLowerBound <= secondElfLowerBound)
                    && (firstElfUpperBound >= secondElfUpperBound)
            ) {
                count++;
            } else if ((secondElfLowerBound <= firstElfLowerBound)
                    && (secondElfUpperBound >= firstElfUpperBound)
            ) {
                count++;
            }
        }

        return count;
    }

    public static int getFullyContainedAssignmentsPart2(String[] input) {
        int count = 0;

        for (String pair : input) {
            String[] assignments = pair.split(",");

            int firstElfLowerBound = getLowerBound(assignments[0]);
            int firstElfUpperBound = getUpperBound(assignments[0]);

            int secondElfLowerBound = getLowerBound(assignments[1]);
            int secondElfUpperBound = getUpperBound(assignments[1]);

            if (
                    numberIsInRange(firstElfLowerBound, secondElfLowerBound, secondElfUpperBound)
                            || numberIsInRange(firstElfUpperBound, secondElfLowerBound, secondElfUpperBound)
            ) {
                count++;
            } else if (
                    numberIsInRange(secondElfLowerBound, firstElfLowerBound, firstElfUpperBound)
                            || numberIsInRange(secondElfUpperBound, firstElfLowerBound, firstElfUpperBound)
            ) {
                count++;
            }
        }

        return count;
    }

    private static int getLowerBound(String assignment) {
        return Integer.parseInt(assignment.substring(0, assignment.indexOf("-")));
    }

    private static int getUpperBound(String assignment) {
        int startIdx = assignment.indexOf("-") + 1;

        return Integer.parseInt(assignment.substring(startIdx));
    }

    private static boolean numberIsInRange(int no, int lowerBound, int upperBound) {
        return (lowerBound <= no) && (no <= upperBound);
    }
}
