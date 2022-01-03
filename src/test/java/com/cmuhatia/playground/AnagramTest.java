package com.cmuhatia.playground;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {

    @Test
    public void makeAnagram() {
        assertEquals(4, Anagram.makeAnagram("cde", "abc"));
        assertEquals(4, Anagram.makeAnagram("cdee", "abce"));
        assertEquals(30, Anagram.makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }

    @Test
    public void isAnagram() {
        assertTrue(Anagram.isAnagram("aab", "aba"));
    }
}