package com.cmuhatia.playground.advent_of_code.year2022;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Stack;

/**
 * @see <a href="https://adventofcode.com/2022/day/5">Advent of Code 2022 Day 5</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day5 {

    public static String getTopCrates(List<Stack<Character>> crateStacks, List<Integer[]> instructions) {
        rearrangeCrates(crateStacks, instructions);

        return getTopCrates(crateStacks);
    }

    private static void rearrangeCrates(List<Stack<Character>> crateStacks, List<Integer[]> instructions) {
        for (Integer[] instruction : instructions) {
            Stack<Character> sourceStack = crateStacks.get(instruction[1] - 1);
            Stack<Character> destinationStack = crateStacks.get(instruction[2] - 1);

            for (int i = 0; i < instruction[0]; i++) {
                destinationStack.add(sourceStack.pop());
            }
        }
    }

    private static String getTopCrates(List<Stack<Character>> crateStacks) {
        char[] topCrates = new char[crateStacks.size()];

        for (int i = 0; i < crateStacks.size(); i++) {
            topCrates[i] = crateStacks.get(i).peek();
        }

        return new String(topCrates);
    }

    public static String getTopCratesPart2(List<Stack<Character>> crateStacks, List<Integer[]> instructions) {
        createMover9001RearrangeCrates(crateStacks, instructions);

        return getTopCrates(crateStacks);
    }

    private static void createMover9001RearrangeCrates(List<Stack<Character>> crateStacks, List<Integer[]> instructions) {
        for (Integer[] instruction : instructions) {

            Stack<Character> sourceStack = crateStacks.get(instruction[1] - 1);
            char[] temp = new char[instruction[0]];
            for (int i = 0; i < instruction[0]; i++) {
                temp[i] = sourceStack.pop();
            }

            Stack<Character> destinationStack = crateStacks.get(instruction[2] - 1);
            for (int i = temp.length - 1; i >= 0; i--) {
                destinationStack.add(temp[i]);
            }
        }
    }
}
