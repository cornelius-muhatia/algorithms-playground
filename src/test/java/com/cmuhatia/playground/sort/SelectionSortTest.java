package com.cmuhatia.playground.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 09/04/2022
 */
class SelectionSortTest {

    @Test
    void sort() {
        Integer[] array = {14, 33, 27, 10, 35, 19, 42, 44};

        SelectionSort.sort(array);

        assertArrayEquals(new Integer[]{10, 14, 19, 27, 33, 35, 42, 44}, array);
    }
}