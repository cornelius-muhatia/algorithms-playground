package com.cmuhatia.playground.advent_of_code.year2022;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @see <a href="https://adventofcode.com/2022/day/3">Advent of Code 2022 Day 3</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day3 {

    public static int getTotalItemPriorities(String[] compartments) {
        int total = 0;

        for (var compartment : compartments) {
            int midIdx = compartment.length() / 2;

            for (int i = 0; i <= midIdx; i++) {
                if (compartment.indexOf(compartment.charAt(i), midIdx) > -1) {
                    total += getItemPriority(compartment.charAt(i));
                    break;
                }
            }
        }

        return total;
    }

    public static int getTotalItemPrioritiesPart2(String[] compartments) {
        int total = 0;

        for (int i = 0; i < compartments.length; i += 3) {
            for (int j = 0; j < compartments[i].length(); j++) {
                char currentChar = compartments[i].charAt(j);
                if (compartments[i + 1].indexOf(currentChar) > -1 && compartments[i + 2].indexOf(currentChar) > -1) {
                    total += getItemPriority(currentChar);
                    break;
                }
            }
        }

        return total;
    }

    /**
     * Uses ASCII table to calculate priority in relation to the problem scoring. <br />
     * For example: <br />
     * from the problem statement; a = 1 which is equivalent to 97 in the ASCII table.
     *
     * @return priority of the item
     */
    private static int getItemPriority(char item) {
        return Character.isLowerCase(item) ? item - 96 : item - 38;
    }
}
