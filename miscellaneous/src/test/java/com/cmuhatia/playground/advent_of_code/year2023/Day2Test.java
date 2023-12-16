package com.cmuhatia.playground.advent_of_code.year2023;

import com.cmuhatia.playground.TestUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {

    @Test
    void part1() {
        String[] input = {
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        };

        assertEquals(8, Day2.part1(getCubeSets(input)));
    }

    @Test
    void part1Test2() {
        String[] input = TestUtils.readFileLines("advent_of_code/2023/day2/input1.txt");

        assertEquals(2416, Day2.part1(getCubeSets(input)));
    }

    @Test
    void part2() {
        String[] input = {
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        };

        assertEquals(2286, Day2.part2(getCubeSets(input)));
    }

    @Test
    void part2Test2() {
        String[] input = TestUtils.readFileLines("advent_of_code/2023/day2/input1.txt");

        assertEquals(2286, Day2.part2(getCubeSets(input)));
    }

    private List<Map<String, Integer>> getCubeSets(String[] games) {
        List<Map<String, Integer>> cubeSets = new ArrayList<>(games.length);

        for (int i = 0; i < games.length; i++) {
            String gameStr = getGameSetsStr(games[i]);
            cubeSets.add(strToGamesSet(gameStr));
        }

        return cubeSets;
    }

    private String getGameSetsStr(String line) {
        String gameStr = line.split(":")[1];

        return gameStr.trim();
    }

    private Map<String, Integer> strToGamesSet(String line) {
        Map<String, Integer> games = new HashMap<>();

        for (var gamesStr : line.split(";")) {

            for (var gameStr : gamesStr.split(",")) {
                gameStr = gameStr.strip();

                int spaceIdx = gameStr.indexOf(" ");

                String color = gameStr.substring(spaceIdx).trim();
                int count = Integer.parseInt(gameStr.substring(0, spaceIdx));

                games.compute(color, (key, val) -> {
                    if (val == null || count > val) {
                        return count;
                    }

                    return val;
                });
            }
        }

        return games;
    }
}