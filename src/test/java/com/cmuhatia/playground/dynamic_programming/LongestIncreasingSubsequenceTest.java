package com.cmuhatia.playground.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 25/06/2022
 */
class LongestIncreasingSubsequenceTest {

    @Test
    void of() {
        assertEquals(5, LongestIncreasingSubsequence.of("carbohydrate"));
    }
}