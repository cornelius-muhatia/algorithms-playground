package com.cmuhatia.playground.advent_of_code.year2022;

import com.cmuhatia.playground.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Test {

    @Test
    void getStartPacketPosition() {
        assertEquals(5, Day6.getStartPacketPosition("bvwbjplbgvbhsrlpgdmjqwftvncz"));
        assertEquals(10, Day6.getStartPacketPosition("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));

        assertEquals(19, Day6.getStartPacketPositionPart2("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        assertEquals(29, Day6.getStartPacketPositionPart2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
    }

    @Test
    void getStartPacketPosition2() {
        String input = TestUtils.readFile("advent_of_code/2022_6_input.txt", this.getClass());

        assertEquals(1794, Day6.getStartPacketPosition(input));
        assertEquals(2851, Day6.getStartPacketPositionPart2(input));
    }
}