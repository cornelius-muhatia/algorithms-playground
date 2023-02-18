package com.cmuhatia.playground.maths;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Cornelius M.
 * @version 1.0.0, 09/05/2020
 */
public class DivisorsTest {

    @Test
    public void sumDivisors() {
        assertEquals(15, Divisors.sumDivisors(8));
        assertEquals(8, Divisors.sumDivisors(7));
        assertEquals(1, Divisors.sumDivisors(1));
        assertEquals(60, Divisors.sumDivisors(24));
        assertEquals(2340, Divisors.sumDivisors(1000));
    }
}