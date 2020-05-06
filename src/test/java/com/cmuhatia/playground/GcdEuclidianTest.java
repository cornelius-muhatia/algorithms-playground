package com.cmuhatia.playground;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 06/05/2020
 */
public class GcdEuclidianTest {

    @Test
    public void getGcd() {
        Assert.assertEquals(8, GcdEuclidian.getGcd(24, 8));
        Assert.assertEquals(11, GcdEuclidian.getGcd(77, 22));
    }

    @Test
    public void simplifyFraction() {
        int[] result = new int[2];
        GcdEuclidian.simplifyFraction(77, 22, result);
        Assert.assertArrayEquals(new int[]{7, 2}, result);

        GcdEuclidian.simplifyFraction(8, 24, result);
        Assert.assertArrayEquals(new int[]{1, 3}, result);
    }
}