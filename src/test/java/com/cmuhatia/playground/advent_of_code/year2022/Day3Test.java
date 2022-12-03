package com.cmuhatia.playground.advent_of_code.year2022;

import com.cmuhatia.playground.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Test {

    @Test
    void getTotalItemPriorities1() {
        String[] input = TestUtils.readFileLines("advent_of_code/2022_3_input.txt");

        assertEquals(7581, Day3.getTotalItemPriorities(input));
        assertEquals(2525, Day3.getTotalItemPrioritiesPart2(input));
    }

    @Test
    void getTotalItemPriorities2() {
        String[] input = TestUtils.readFileLines("advent_of_code/2022_3_input2.txt");

        assertEquals(157, Day3.getTotalItemPriorities(input));
        assertEquals(70, Day3.getTotalItemPrioritiesPart2(input));
    }
}