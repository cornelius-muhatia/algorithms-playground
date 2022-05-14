package com.cmuhatia.playground.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 14/05/2022
 */
class CountingSortTest {

    @Test
    void sort() {
        int[] arr = {2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9};

        assertArrayEquals(
                new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 4, 5, 7, 7, 8, 9, 9},
                CountingSort.sort(arr, 9)
        );
    }
}