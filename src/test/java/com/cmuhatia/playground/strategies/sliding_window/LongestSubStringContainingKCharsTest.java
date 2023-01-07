package com.cmuhatia.playground.strategies.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubStringContainingKCharsTest {

    @Test
    void of() {
        String input = "abcbdbdbbdcdabd";

        assertEquals("bdbdbbd", LongestSubStringContainingKChars.of(input, 2));
        assertEquals("bcbdbdbbdcd", LongestSubStringContainingKChars.of(input, 3));
        assertEquals("abcbdbdbbdcdabd", LongestSubStringContainingKChars.of(input, 4));
    }

    @Test
    void of2() {
        assertEquals("", LongestSubStringContainingKChars.of("aaaaa", 2));
        assertEquals("", LongestSubStringContainingKChars.of(null, 2));
    }

    @Test
    void of3() {
        assertEquals("cbebebe", LongestSubStringContainingKChars.of("aabacbebebe", 3));
    }
}