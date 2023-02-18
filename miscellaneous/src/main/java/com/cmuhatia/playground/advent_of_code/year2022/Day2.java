package com.cmuhatia.playground.advent_of_code.year2022;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @see <a href="https://adventofcode.com/2022/day/2">Advent of Code 2022 Day 2</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day2 {
    public static int getTotalScore(String[] puzzleInputs) {
        Map<Character, Integer> scoreTable = Map.of(
                'A', 1,
                'B', 2,
                'C', 3,
                'X', 1,
                'Y', 2,
                'Z', 3
        );

        int totalScore = 0;
        for (String input : puzzleInputs) {
            int opponent = scoreTable.get(input.charAt(0));
            int me = scoreTable.get(input.charAt(2));

            if (opponent == me) {
                totalScore += me + 3;
            } else if (opponent == 3 && me == 1) {
                totalScore += me + 6;
            } else if (opponent == 1 && me == 2) {
                totalScore += me + 6;
            } else if (opponent == 2 && me == 3) {
                totalScore += me + 6;
            } else {
                totalScore += me;
            }
        }

        return totalScore;
    }

    public static int getTotalScorePart2(String[] puzzleInputs) {
        Map<Character, Integer> scoreTable = Map.of(
                'A', 1,
                'B', 2,
                'C', 3
        );

        int totalScore = 0;
        for (String input : puzzleInputs) {
            int opponent = scoreTable.get(input.charAt(0));
            char action = input.charAt(2);

            if (action == 'Z') {
                totalScore += win(opponent) + 6;
            } else if (action == 'Y') {
                totalScore += opponent + 3;
            } else {
                totalScore += lose(opponent);
            }
        }

        return totalScore;
    }

    private static int win(int opponent) {
        return switch (opponent) {
            case 3 -> 1;
            case 1 -> 2;
            default -> 3;
        };
    }

    private static int lose(int opponent) {
        return switch (opponent) {
            case 1 -> 3;
            case 2 -> 1;
            default -> 2;
        };
    }
}
