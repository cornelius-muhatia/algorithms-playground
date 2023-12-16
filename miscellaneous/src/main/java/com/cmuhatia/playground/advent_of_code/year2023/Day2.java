package com.cmuhatia.playground.advent_of_code.year2023;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://adventofcode.com/2023/day/2">Day 2: Cube Conundrum</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day2 {

    public static int part1(List<Map<String, Integer>> cubeSets) {
        var bagCapacity = Map.of("red", 12, "green", 13, "blue", 14);
        int total = 0;

        for (int i = 0; i < cubeSets.size(); i++) {
            var gameSet = cubeSets.get(i);
            if (
                    gameSet.get("red") <= bagCapacity.get("red")
                            && gameSet.get("green") <= bagCapacity.get("green")
                            && gameSet.get("blue") <= bagCapacity.get("blue")
            ) {
                total += i + 1;
            }
        }

        return total;
    }

    public static int part2(List<Map<String, Integer>> cubeSets) {
        int total = 0;
        for (var gameSet : cubeSets) {
            total += (gameSet.get("blue") * gameSet.get("red") * gameSet.get("green"));
        }

        return total;
    }

}
