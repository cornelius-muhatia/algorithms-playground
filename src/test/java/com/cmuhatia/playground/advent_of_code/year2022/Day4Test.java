package com.cmuhatia.playground.advent_of_code.year2022;

import com.cmuhatia.playground.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4Test {

    @Test
    void getFullyContainedAssignments() {
        String[] input = TestUtils.readFileLines("advent_of_code/2022_4_input.txt");

        assertEquals(433, Day4.getFullyContainedAssignments(input));
        assertEquals(852, Day4.getFullyContainedAssignmentsPart2(input));
    }

    @Test
    void getFullyContainedAssignments2() {
        String[] input = TestUtils.readFileLines("advent_of_code/2022_4_input2.txt");

        assertEquals(2, Day4.getFullyContainedAssignments(input));
        assertEquals(4, Day4.getFullyContainedAssignmentsPart2(input));
    }
}