package com.cmuhatia.playground;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 23/05/2020
 */
public class PalindromeTest {

    @Test
    public void isPalindrome() {
        assertTrue(Palindrome.isPalindrome(1001));
        assertTrue(Palindrome.isPalindrome(110011));
        assertFalse(Palindrome.isPalindrome(1234));
    }
}