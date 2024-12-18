package com.cmuhatia.playground.advent_of_code.year2024;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Advent of code Day 3 Challenge
 *
 * @see https://adventofcode.com/2024/day/3
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day3 {

    public static int multiplicationResults(String input) {
        int total = 0;
        Pattern pattern = Pattern.compile("mul\\(\\d+\\p{Punct}\\d+\\)");

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            var multPair = multiplicationPair(matcher.group(0));
            total += (multPair.getFirst() * multPair.getLast());

        }

        return total;
    }

    private static List<Integer> multiplicationPair(String multFunc) {
        List<Integer> output = new ArrayList<>(2);

        Pattern pattern = Pattern.compile("\\d+");

        Matcher matcher = pattern.matcher(multFunc);
        while (matcher.find()) {
            output.add(Integer.valueOf(matcher.group(0)));
        }

        return output;
    }

    public static int enabledMultiplicationResults(String input) {
        int total = 0;
        List<String> pairs = findDefaultMultPairs(input);
        List<String> excludePairs = findExcludePairs(input);

        for (var pair : pairs) {
            if (excludePairs.contains(pair)) {
                excludePairs.remove(pair);
                continue;
            }

            var multPair = multiplicationPair(pair);
            total += (multPair.getFirst() * multPair.getLast());
        }

        return total;
    }

    private static List<String> findDefaultMultPairs(String input) {
        List<String> pairs = new ArrayList<>();
        Pattern pattern = Pattern.compile("mul\\(\\d{1,3}\\p{Punct}\\d{1,3}\\)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            pairs.add(matcher.group(0));
        }

        return pairs;
    }

    private static List<String> findExcludePairs(String input) {
        List<String> pairs = new ArrayList<>();

        int dontIdx = input.indexOf("don't()");
        int doIdx = input.indexOf("do()", dontIdx);
        doIdx = doIdx == -1 ? input.length() - 1 : doIdx;

        while (dontIdx < input.length()) {
            String ignore = input.substring(dontIdx, doIdx);

            pairs.addAll(findDefaultMultPairs(ignore));

            dontIdx = input.indexOf("don't()", doIdx);
            if (dontIdx == -1) {
                break;
            }

            doIdx = input.indexOf("do()", dontIdx);
            if (doIdx == -1) {
                doIdx = input.length() - 1;
            }
        }


        return pairs;
    }

}
