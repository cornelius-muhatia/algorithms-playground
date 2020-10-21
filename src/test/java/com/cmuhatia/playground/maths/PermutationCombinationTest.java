package com.cmuhatia.playground.maths;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 21/10/2020
 */
public class PermutationCombinationTest {


    @Test
    public void getPermutation() {
        assertEquals("Test permutation of 3 in 8", 336,
                PermutationCombination.getPermutation(8, 3));
        assertEquals("Test permutation of 3 in 80", 492960,
                PermutationCombination.getPermutation(80, 3));
        long large = 11510836921584000L;
        assertEquals("Test permutation of 7 in 200", large,
                PermutationCombination.getPermutation(200, 7));
    }

    @Test
    public void getCombination() {
        assertEquals("Test combination of 3 in 8", 56,
                PermutationCombination.getCombination(8, 3));
        assertEquals("Test combination of 3 in 80", 82160,
                PermutationCombination.getCombination(80, 3));
        long large = 2283896214600L;
        assertEquals("Test combination of 7 in 200", large,
                PermutationCombination.getCombination(200, 7));
    }
}