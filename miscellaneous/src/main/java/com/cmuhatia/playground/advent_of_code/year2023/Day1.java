package com.cmuhatia.playground.advent_of_code.year2023;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @see <a href="https://adventofcode.com/2023/day/1">Day 1: Trebuchet?!</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day1 {

    public static int part1(String[] input) {
        int sum = 0;
        for (var sentence : input) {
            Character firstDigit = null;
            Character lastDigit = null;

            int length = sentence.length();
            for (int i = 0; i < length; i++) {
                if (firstDigit == null && Character.isDigit(sentence.charAt(i))) {
                    firstDigit = sentence.charAt(i);
                }

                char lastChar = sentence.charAt(length - (i + 1));
                if (lastDigit == null && Character.isDigit(lastChar)) {
                    lastDigit = lastChar;
                }

                if (firstDigit != null && lastDigit != null) {
                    break;
                }
            }

            sum += convertToInteger(firstDigit, lastDigit);
        }

        return sum;
    }

    private static int convertToInteger(Character char1, Character char2) {
        if (char1 != null && char2 != null) {
            return Integer.parseInt(char1 + "" + char2);
        }

        if (char1 == null && char2 != null) {
            return Character.getNumericValue(char2) * 2;
        }

        if (char1 != null) {
            return Character.getNumericValue(char1) * 2;
        }

        return 0;
    }

    public static int part2(String[] input) {
        int sum = 0;
        var digits = Map.of(
                "one", '1',
                "two", '2',
                "three", '3',
                "four", '4',
                "five", '5',
                "six", '6',
                "seven", '7',
                "eight", '8',
                "nine", '9'
        );
        for (var sentence : input) {
            Character firstDigit = null;
            Character lastDigit = null;

            int length = sentence.length();
            for (int i = 0; i < length; i++) {
                if (firstDigit == null) {
                    firstDigit = getFirstDigitChar(sentence, i, digits);
                }

                if (lastDigit == null) {
                    lastDigit = getLastDigitChar(sentence, i, digits);
                }

                if (firstDigit != null && lastDigit != null) {
                    break;
                }
            }

            sum += convertToInteger(firstDigit, lastDigit);
        }

        return sum;
    }


    private static Character getFirstDigitChar(String sentence, int idx, Map<String, Character> digits) {

        if (Character.isDigit(sentence.charAt(idx))) {
            return sentence.charAt(idx);
        }

        for (var entry : digits.entrySet()) {
            int substringLength = idx + entry.getKey().length();
            if (substringLength < sentence.length()) {
                String subString = sentence.substring(idx, substringLength);
                if (entry.getKey().equalsIgnoreCase(subString)) {
                    return entry.getValue();
                }
            }
        }

        return null;
    }

    private static Character getLastDigitChar(String sentence, int idx, Map<String, Character> digits) {
        int lastIdx = sentence.length() - (idx + 1);
        char lastChar = sentence.charAt(lastIdx);
        if (Character.isDigit(lastChar)) {
            return lastChar;
        }

        for (var entry : digits.entrySet()) {
            int begin = (lastIdx) - entry.getKey().length();
            begin++;
            if (begin > -1) {
                String substring = sentence.substring(begin, lastIdx + 1);
                if (entry.getKey().equalsIgnoreCase(substring)) {
                    return entry.getValue();
                }
            }
        }

        return null;
    }
}
