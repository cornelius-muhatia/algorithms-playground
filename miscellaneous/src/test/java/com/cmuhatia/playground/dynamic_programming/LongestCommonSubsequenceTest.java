package com.cmuhatia.playground.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @version 1.0.0, 24/06/2022
 */
class LongestCommonSubsequenceTest {

    @Test
    void of() {
        assertEquals(5, LongestCommonSubsequence.of("hieroglyphology", "michaelangelo"));
    }
}