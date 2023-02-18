package com.cmuhatia.playground.strategies.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubArraySumTest {

    @Test
    void of() {
        int[] arr = {5, 2, -1, 0, 3};
        assertEquals(6, MaximumSubArraySum.of(arr, 3));

        arr = new int[]{-5, -2, -1, 0, -3};
        assertEquals(-3, MaximumSubArraySum.of(arr, 3));
    }

    @Test()
    void of2() {
        int[] arr = {5, 2};
        assertEquals(-1, MaximumSubArraySum.of(arr, 3));
    }

    @Test()
    void of3() {
        int[] arr = {5, 2};
        assertEquals(7, MaximumSubArraySum.of(arr, 2));
    }
}