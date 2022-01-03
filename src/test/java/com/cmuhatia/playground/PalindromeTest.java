package com.cmuhatia.playground;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
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

    /**
     * Parse string to sorted integer array
     *
     * @param string String
     * @return integer array
     */
    public static int[] parseSortedArray(String string){
        string = string.substring(1, (string.length() - 1));
        String[] strings = string.split(",");
        int[] ints = new int[strings.length];
        for(int i = 0; i < strings.length; i++){
            ints[i] = Integer.parseInt(strings[i].trim());
        }
        Arrays.sort(ints);
        return ints;
    }

    @Test
    public void createPalindrome() {
        String string = "kjjjhjjj";
        assertEquals("k", Palindrome.createPalindrome(string));
        string = "jjjhjjjk";
        assertEquals("k", Palindrome.createPalindrome(string));
    }

    @Test
    public void testIsPalindrome() {
        String string1 = "teet";
        assertTrue(Palindrome.isPalindrome(string1));
        string1 = "racecar";
        assertTrue(Palindrome.isPalindrome(string1));
        string1 = "palindrome";
        assertFalse(Palindrome.isPalindrome(string1));

    }
}