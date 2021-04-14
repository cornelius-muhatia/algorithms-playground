package com.cmuhatia.playground.maths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Cornelius M.
 * @version 1.0.0, 06/05/2020
 */
public class GcdEuclidianTest {

    @Test
    public void getGcd() {
        Assertions.assertEquals(8, GcdEuclidian.getGcd(24, 8));
        Assertions.assertEquals(11, GcdEuclidian.getGcd(77, 22));
        Assertions.assertEquals(1, GcdEuclidian.getGcd(17, 13));
    }

    @Test
    public void simplifyFraction() {
        int[] result = new int[2];
        GcdEuclidian.simplifyFraction(77, 22, result);
        Assertions.assertArrayEquals(new int[]{7, 2}, result);

        GcdEuclidian.simplifyFraction(8, 24, result);
        Assertions.assertArrayEquals(new int[]{1, 3}, result);
    }

    @Test
    public void testGetGcd() {
        Assertions.assertEquals(4, GcdEuclidian.getGcd(20, 28, 24));
        Assertions.assertEquals(10, GcdEuclidian.getGcd(30, 40, 60));
    }
}