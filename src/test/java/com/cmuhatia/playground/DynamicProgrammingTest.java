package com.cmuhatia.playground;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DynamicProgrammingTest {

    @Test
    public void fibonacciSeq() {
        Assert.assertEquals(1, DynamicProgramming.fibonacciSeqRecursion(2));
        Assert.assertEquals(8, DynamicProgramming.fibonacciSeqRecursion(6));
    }

    @Test
    public void fibonacciSeqMemoization(){
        Assert.assertEquals(1, DynamicProgramming.fibonacciSeqMemoization(2, new Integer[2]));
        Assert.assertEquals(8, DynamicProgramming.fibonacciSeqMemoization(6, new Integer[6]));
    }

    @Test
    public void fibonacciSeqBottomUp(){
        Assert.assertEquals(1, DynamicProgramming.fibonacciSeqBottomUp(2));
        Assert.assertEquals(8, DynamicProgramming.fibonacciSeqBottomUp(6));
    }
}