package com.cmuhatia.playground.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 14/05/2022
 */
class RadixSortTest {

    @Test
    void sort() {
        int[] array = {432, 8, 530, 90, 88, 231, 11, 45, 677, 199};
        assertArrayEquals(
                new int[]{8, 11, 45, 88, 90, 199, 231, 432, 530, 677},
                RadixSort.sort(array, 677)
        );
    }
}