package com.cmuhatia.playground.maths;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 09/05/2020
 */
public class DivisorsTest {

    @Test
    public void sumDivisors() {
        Assert.assertEquals(15, Divisors.sumDivisors(8));
        Assert.assertEquals(8, Divisors.sumDivisors(7));
        Assert.assertEquals(1, Divisors.sumDivisors(1));
        Assert.assertEquals(60, Divisors.sumDivisors(24));
        Assert.assertEquals(2340, Divisors.sumDivisors(1000));
    }
}