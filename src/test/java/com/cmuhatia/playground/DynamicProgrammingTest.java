package com.cmuhatia.playground;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicProgrammingTest {

    @Test
    public void fibonacciSeq() {
        assertEquals(1, DynamicProgramming.fibonacciSeqRecursion(2));
        assertEquals(8, DynamicProgramming.fibonacciSeqRecursion(6));
    }

    @Test
    public void fibonacciSeqMemoization(){
        assertEquals(1, DynamicProgramming.fibonacciSeqMemoization(2, new Integer[2]));
        assertEquals(8, DynamicProgramming.fibonacciSeqMemoization(6, new Integer[6]));
    }

    @Test
    public void fibonacciSeqBottomUp(){
        assertEquals(1, DynamicProgramming.fibonacciSeqBottomUp(2));
        assertEquals(8, DynamicProgramming.fibonacciSeqBottomUp(6));
    }

    @Test
    public void longestIncreasingSequence(){
        assertEquals(List.of(3, 5, 10, 12, 15), DynamicProgramming.longestIncreasingSequence(List.of(16, 3, 5, 19, 10, 14, 12, 0, 15)));
    }

    @Test
    public void longestIncreasingSequence2() {
        List<Integer> list = List.of(10, 3, 5, 19, 10, 14, 12, 0, 5);
        assertFalse(DynamicProgramming.longestIncreasingSequence2(list).isEmpty());
        fail(DynamicProgramming.longestIncreasingSequence2(list).toString());
    }

    @Test
    void getLongestCommonSubsequence() {
        assertEquals("abcf", DynamicProgramming.getLongestCommonSubsequence("abcdef", "acbcf"));
        assertEquals("abcf", DynamicProgramming.getLongestCommonSubsequence("acbcf", "abcdef"));
        assertEquals("GTAB", DynamicProgramming.getLongestCommonSubsequence("AGGTAB", "GXTXAYB"));
    }
}