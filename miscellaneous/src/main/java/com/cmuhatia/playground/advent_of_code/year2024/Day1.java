package com.cmuhatia.playground.advent_of_code.year2024;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Advent of code Day 1 Challenge
 *
 * @see https://adventofcode.com/2024/day/1
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day1 {

    public static int totalDistance(String input) {
        int sum = 0;

        String[] lines = input.split(System.lineSeparator());
        PriorityQueue<Integer> list1 = new PriorityQueue<>(lines.length);
        PriorityQueue<Integer> list2 = new PriorityQueue<>(lines.length);

        for (int i = 0; i < lines.length; i++) {
            String entry1 = lines[i].substring(0, lines[i].indexOf("\s"));
            list1.add(Integer.valueOf(entry1));

            String entry2 = lines[i].substring(lines[i].indexOf("\s")).trim();
            list2.add(Integer.valueOf(entry2));
        }

        while (!list1.isEmpty() && !list2.isEmpty()) {
            int difference = Math.abs(list1.poll() - list2.poll());
            sum += difference;
        }

        return sum;
    }

    public static int similarityScore(String input) {
        int score = 0;

        String[] lines = input.split(System.lineSeparator());
        List<Integer> list1 = new ArrayList<>(lines.length);
        List<Integer> list2 = new ArrayList<>(lines.length);

        for (int i = 0; i < lines.length; i++) {
            String entry1 = lines[i].substring(0, lines[i].indexOf("\s"));
            list1.add(Integer.valueOf(entry1));

            String entry2 = lines[i].substring(lines[i].indexOf("\s")).trim();
            list2.add(Integer.valueOf(entry2));
        }

        for (var entry : list1) {
            score += entry * countOccurrence(list2, entry);
        }

        return score;
    }

    private static int countOccurrence(List<Integer> list, int val) {
        int count = 0;

        for (var entry : list) {
            if (entry == val) count++;
        }

        return count;
    }


}
