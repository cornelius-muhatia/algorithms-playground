package com.cmuhatia.playground.advent_of_code.year2022;

import com.cmuhatia.playground.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {

    @Test
    void getTotalScore() {
        String[] input = TestUtils.readFileLines("advent_of_code/2022_2_input.txt");

        assertEquals(8933, Day2.getTotalScore(input));
        assertEquals(11998, Day2.getTotalScorePart2(input));
    }

    @Test
    void getTotalScore2() {
        String[] input = TestUtils.readFileLines("advent_of_code/2022_2_input2.txt");

        assertEquals(15, Day2.getTotalScore(input));
        assertEquals(12, Day2.getTotalScorePart2(input));
    }
}