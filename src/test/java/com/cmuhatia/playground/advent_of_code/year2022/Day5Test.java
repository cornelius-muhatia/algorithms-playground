package com.cmuhatia.playground.advent_of_code.year2022;

import com.cmuhatia.playground.TestUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5Test {

    @Test
    void getTopCrates() {
        List<Stack<Character>> crateStacks = readInput("advent_of_code/2022/day5/2022_5_input.txt");
        List<Integer[]> instructions = readInstructions("advent_of_code/2022/day5/2022_5_instructions.txt");

        assertEquals("RNZLFZSJH", Day5.getTopCrates(crateStacks, instructions));

        List<Stack<Character>> crateStacks2 = readInput("advent_of_code/2022/day5/2022_5_input.txt");
        assertEquals("CNSFCGJSM", Day5.getTopCratesPart2(crateStacks2, instructions));
    }

    @Test
    void getTopCrates2() {
        List<Stack<Character>> crateStacks = readInput("advent_of_code/2022/day5/2022_5_input2.txt");
        List<Integer[]> instructions = readInstructions("advent_of_code/2022/day5/2022_5_instructions2.txt");

        assertEquals("CMZ", Day5.getTopCrates(crateStacks, instructions));

        List<Stack<Character>> crateStacks2 = readInput("advent_of_code/2022/day5/2022_5_input2.txt");
        assertEquals("MCD", Day5.getTopCratesPart2(crateStacks2, instructions));
    }

    private List<Stack<Character>> readInput(String relativePath) {
        String inputString = TestUtils.readFile(relativePath, Day5Test.class);

        return mapStringToCrateStacks(inputString);
    }

    private List<Stack<Character>> mapStringToCrateStacks(String input) {
        List<Stack<Character>> stacks = new ArrayList<>();
        String[] lines = input.split(System.lineSeparator());

        for (int j = lines.length - 1; j >= 0; j--) {
            String line = lines[j];

            char[] charArray = line.toCharArray();

            for (int i = 1; i < charArray.length; i += 4) {
                int idx = (i - 1) / 4;

                if (stacks.size() < (idx + 1)) {
                    stacks.add(new Stack<>());
                }

                if (Character.isAlphabetic(charArray[i])) {
                    stacks.get(idx).add(charArray[i]);
                }
            }
        }

        return stacks;
    }

    private List<Integer[]> readInstructions(String relativePath) {
        String inputString = TestUtils.readFile(relativePath, Day5Test.class);

        return mapStringToInstructionList(inputString.split(System.lineSeparator()));
    }

    private List<Integer[]> mapStringToInstructionList(String[] inputLines) {
        List<Integer[]> instructions = new ArrayList<>(inputLines.length);

        for (String inputLine : inputLines) {
            String[] tokens = inputLine.split("\\D+");
            Integer[] instruction = new Integer[3];

            instruction[0] = Integer.parseInt(tokens[1]);
            instruction[1] = Integer.parseInt(tokens[2]);
            instruction[2] = Integer.parseInt(tokens[3]);

            instructions.add(instruction);
        }

        return instructions;
    }
}