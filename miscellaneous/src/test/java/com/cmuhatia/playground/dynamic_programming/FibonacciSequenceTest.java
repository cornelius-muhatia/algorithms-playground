package com.cmuhatia.playground.dynamic_programming;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciSequenceTest {

    @Test
    public void fibonacciSeq() {
        assertEquals(1, FibonacciSequence.fibonacciSeqRecursion(2));
        assertEquals(8, FibonacciSequence.fibonacciSeqRecursion(6));
    }

    @Test
    public void fibonacciSeqMemoization(){
        assertEquals(1, FibonacciSequence.fibonacciSeqMemoization(2, new Integer[2]));
        assertEquals(8, FibonacciSequence.fibonacciSeqMemoization(6, new Integer[6]));
    }

    @Test
    public void fibonacciSeqBottomUp(){
        assertEquals(1, FibonacciSequence.fibonacciSeqBottomUp(2));
        assertEquals(8, FibonacciSequence.fibonacciSeqBottomUp(6));
    }

    @Test
    @Disabled
    public void longestIncreasingSequence(){
        assertEquals(List.of(3, 5, 10, 12, 15), FibonacciSequence.longestIncreasingSequence(List.of(16, 3, 5, 19, 10, 14, 12, 0, 15)));
    }

    @Test
    @Disabled
    public void longestIncreasingSequence2() {
        List<Integer> list = List.of(10, 3, 5, 19, 10, 14, 12, 0, 5);
        assertFalse(FibonacciSequence.longestIncreasingSequence2(list).isEmpty());
        fail(FibonacciSequence.longestIncreasingSequence2(list).toString());
    }

    @Test
    void getLongestCommonSubsequence() {
        assertEquals("abcf", FibonacciSequence.getLongestCommonSubsequence("abcdef", "acbcf"));
        assertEquals("abcf", FibonacciSequence.getLongestCommonSubsequence("acbcf", "abcdef"));
        assertEquals("GTAB", FibonacciSequence.getLongestCommonSubsequence("AGGTAB", "GXTXAYB"));
    }
}