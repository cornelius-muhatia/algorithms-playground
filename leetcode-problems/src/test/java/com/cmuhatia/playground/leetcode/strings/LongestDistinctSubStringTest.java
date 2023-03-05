package com.cmuhatia.playground.leetcode.strings;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LongestDistinctSubStringTest {

    @Test
    void length() {
        assertEquals(0, LongestDistinctSubString.length(""));
    }

    @Test
    void length1() {
        assertEquals(3, LongestDistinctSubString.length("abcabcbb"));
    }

    @Test
    void length2() {
        assertEquals(1, LongestDistinctSubString.length("bbbbb"));
    }

    @Test
    void length3() {
        assertEquals(3, LongestDistinctSubString.length("pwwkew"));
    }

    @Test
    void length4() {
        assertEquals(5, LongestDistinctSubString.length("abcde"));
    }


    @Test
    void length5() {
        String input = RandomStringUtils.random(1000)
                + "abcdefghijklmnopqrstuvwxyz"
                + RandomStringUtils.random(50000);

        assertTrue(LongestDistinctSubString.length(input) >= 26);
    }

    @Test
    void length6() {
        assertEquals(5, LongestDistinctSubString.length("tmmzuxt"));
    }
}