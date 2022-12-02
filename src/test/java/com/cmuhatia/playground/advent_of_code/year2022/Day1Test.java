package com.cmuhatia.playground.advent_of_code.year2022;

import com.cmuhatia.playground.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    @Test
    void getMaximumCalories() {
        String[] itemsCalories = getItemCalories("advent_of_code/2022_1_input.txt");

        assertEquals(75501, Day1.getMaximumCalories(itemsCalories));
        assertEquals(215594, Day1.getMaxCaloriesPart2(itemsCalories));
    }

    @Test
    void getMaximumCalories2() {
        String[] itemsCalories = getItemCalories("advent_of_code/2022_1_input2.txt");

        assertEquals(24000, Day1.getMaximumCalories(itemsCalories));
        assertEquals(45000, Day1.getMaxCaloriesPart2(itemsCalories));
    }

    private String[] getItemCalories(String fileRelativePath) {
        String rawItems = TestUtils.readFile(fileRelativePath, this.getClass());

        return rawItems.split(System.lineSeparator());
    }
}