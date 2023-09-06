package com.cmuhatia.playground.strategies.two_pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayElementSumTest {

    @Test
    void of() {
        int[] arr = {10, 20, 35, 50, 75, 80};

        assertArrayEquals(new int[]{20, 50}, ArrayElementSum.of(arr, 70));
    }
}