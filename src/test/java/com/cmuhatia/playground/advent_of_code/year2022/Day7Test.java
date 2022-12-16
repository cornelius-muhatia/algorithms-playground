package com.cmuhatia.playground.advent_of_code.year2022;

import com.cmuhatia.playground.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7Test {

    @Test
    void getDirSumWithAtMost100000() {
        String[] input = TestUtils.readFileLines("advent_of_code/2022_7_input.txt");

        assertEquals(1350966L, Day7.getDirSumWithAtMost100000(input));
    }

    @Test
    void getDirSumWithAtMost1000002() {
        String[] input = TestUtils.readFileLines("advent_of_code/2022_7_input2.txt");

        assertEquals(95437L, Day7.getDirSumWithAtMost100000(input));
    }

    @Test
    void getSmallestDirWithAtLeast() {
        String[] input = TestUtils.readFileLines("advent_of_code/2022_7_input.txt");

        assertEquals(6296435L, Day7.getSmallestDirWithAtLeast(70000000L, 30000000L, input));
    }

    @Test
    void getSmallestDirWithAtLeast2() {
        String[] input = TestUtils.readFileLines("advent_of_code/2022_7_input2.txt");

        assertEquals(24933642L, Day7.getSmallestDirWithAtLeast(70000000L, 30000000L, input));
    }
}