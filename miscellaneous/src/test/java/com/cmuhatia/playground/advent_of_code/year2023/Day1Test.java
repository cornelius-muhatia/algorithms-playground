package com.cmuhatia.playground.advent_of_code.year2023;

import com.cmuhatia.playground.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    @Test
    void part1() {
        String[] input = {
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet",
                "test1"
        };
        assertEquals(153, Day1.part1(input));
    }

    @Test
    void part1Test2() {
        String[] input = TestUtils.readFileLines("advent_of_code/2023/day1/input1.txt");

        assertEquals(54990, Day1.part1(input));
    }

    @Test
    void part2() {
        String[] input = {
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen"
        };

        assertEquals(281, Day1.part2(input));
    }

    @Test
    void part2Test1() {
        String[] input = TestUtils.readFileLines("advent_of_code/2023/day1/input1.txt");

        assertEquals(281, Day1.part2(input));
    }
}