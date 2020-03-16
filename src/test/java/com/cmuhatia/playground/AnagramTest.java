package com.cmuhatia.playground;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {

    @Test
    public void makeAnagram() {
        Assert.assertEquals(4, Anagram.makeAnagram("cde", "abc"));
        Assert.assertEquals(4, Anagram.makeAnagram("cdee", "abce"));
        Assert.assertEquals(30, Anagram.makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
}