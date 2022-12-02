package com.cmuhatia.playground.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringExamplesTest {

    @Test
    void reverseString() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        StringExamples.reverseString(s);
        Assertions.assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, s);
    }

    @Test
    void reverseString2() {
        char[] s = {'h', 'e', 'l', 'l', 'o', 'w'};
        StringExamples.reverseString(s);
        Assertions.assertArrayEquals(new char[]{'w', 'o', 'l', 'l', 'e', 'h'}, s);
    }

    @Test
    void reverseString3() {
        char[] s = {'h'};
        StringExamples.reverseString(s);
        Assertions.assertArrayEquals(new char[]{'h'}, s);
    }
}