package com.cmuhatia.playground.advent_of_code.year2022;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @see <a href="https://adventofcode.com/2022/day/1">Advent of Code 2022 Day 1</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day1 {

    public static int getMaximumCalories(String[] itemsCalories) {
        int maxCalories = 0;
        int currentElfCalories = 0;

        for (String itemCalorie : itemsCalories) {
            if (itemCalorie.isEmpty()) {
                maxCalories = Math.max(maxCalories, currentElfCalories);
                currentElfCalories = 0;
                continue;
            }

            currentElfCalories += Integer.parseInt(itemCalorie);
        }

        return maxCalories;
    }

    public static int getMaxCaloriesPart2(String[] itemsCalories) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int currentElfCalories = 0;

        for (String itemCalorie : itemsCalories) {
            if (itemCalorie.isEmpty()) {
                queue.add(currentElfCalories);
                currentElfCalories = 0;
                continue;
            }

            currentElfCalories += Integer.parseInt(itemCalorie);
        }

        if (currentElfCalories > 0) {
            queue.add(currentElfCalories);
        }

        return queue.remove() + queue.remove() + queue.remove();
    }
}
