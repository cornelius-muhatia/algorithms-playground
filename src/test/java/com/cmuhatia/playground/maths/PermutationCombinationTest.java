package com.cmuhatia.playground.maths;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Cornelius M.
 * @version 1.0.0, 21/10/2020
 */
public class PermutationCombinationTest {


    @Test
    public void getPermutation() {
        assertEquals( 336,
                PermutationCombination.getPermutation(8, 3));
        assertEquals(492960,
                PermutationCombination.getPermutation(80, 3));
        long large = 11510836921584000L;
        assertEquals(large,
                PermutationCombination.getPermutation(200, 7));
    }

    @Test
    public void getCombination() {
        assertEquals(56,
                PermutationCombination.getCombination(8, 3));
        assertEquals(82160,
                PermutationCombination.getCombination(80, 3));
        long large = 2283896214600L;
        assertEquals(large,
                PermutationCombination.getCombination(200, 7));
    }
}