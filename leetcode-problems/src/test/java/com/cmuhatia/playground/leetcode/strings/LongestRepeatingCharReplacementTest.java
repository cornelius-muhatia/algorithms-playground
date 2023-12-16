package com.cmuhatia.playground.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestRepeatingCharReplacementTest {

    @Test
    void of() {
        assertEquals(0, LongestRepeatingCharReplacement.of(null, 3));
    }

    @Test
    void of2() {
        assertEquals(0, LongestRepeatingCharReplacement.of("", 3));
    }

    @Test
    void of3() {
        assertEquals(4, LongestRepeatingCharReplacement.of("ABAB", 2));
    }

    @Test
    void of4() {
        assertEquals(4, LongestRepeatingCharReplacement.of("AABABBA", 1));
    }

    @Test
    void of5() {
        assertEquals(2, LongestRepeatingCharReplacement.of("AABABBA", -1));
    }
}