package com.cmuhatia.playground.advent_of_code.year2022;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://adventofcode.com/2022/day/6">Advent of Code 2022 Day 6</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day6 {

    public static int getStartPacketPosition(String input) {
        return getStartMarkerPosition(input, 4);
    }

    public static int getStartPacketPositionPart2(String input) {
        return getStartMarkerPosition(input, 14);
    }

    private static int getStartMarkerPosition(String input, int markerLength) {
        int i = markerLength;
        int j = 0;
        String marker = input.substring(j, i);

        while (i < input.length()) {
            if (hasDuplicateCharacters(marker)) {
                j++;
                i = j + markerLength;
                marker = input.substring(j, i);
                continue;
            }

            return i;
        }

        return i;
    }

    private static boolean hasDuplicateCharacters(String marker) {
        Set<Character> temp = new HashSet<>();
        for (int i = 0; i < marker.length(); i++) {
            temp.add(marker.charAt(i));

            if (temp.size() < (i + 1)) {
                return true;
            }
        }

        return false;
    }


}
