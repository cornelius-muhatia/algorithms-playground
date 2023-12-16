package com.cmuhatia.playground.maths;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 15/05/2020
 */
public class PrimeNumbersTest {

    @Test
    public void countPrimeNumbersTests() {
        assertEquals(1, PrimeNumbers.countPrimeNumbers(2));
        assertEquals(4, PrimeNumbers.countPrimeNumbers(10));
        assertEquals(6, PrimeNumbers.countPrimeNumbers(16));
        assertEquals(11, PrimeNumbers.countPrimeNumbers(31));
//        assertEquals(11, PrimeNumbers.countPrimeNumbers(1000000));
    }

    @Test
    @Disabled
    public void countPrimeNoTests() {
        assertEquals(1, PrimeNumbers.countPrimeNumbers(2));
        assertEquals(4, PrimeNumbers.countPrimeNumbers(10));
        assertEquals(6, PrimeNumbers.countPrimeNumbers(16));
        assertEquals(11, PrimeNumbers.countPrimeNumbers(31));
        assertEquals(11, PrimeNumbers.countPrimeNumbers(1000000));
    }

    @Test
    public void testIsPrimeNo() {
        assertTrue(PrimeNumbers.isPrimeNumber(3));
    }

    @Test
    public void testIsPrimeNo2() {
        assertFalse(PrimeNumbers.isPrimeNumber(9));
    }

    @Test
    public void testIsPrimeNo3() {
        assertTrue(PrimeNumbers.isPrimeNumber(2000000000000000L));
    }
}