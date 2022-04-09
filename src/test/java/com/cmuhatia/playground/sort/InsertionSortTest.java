package com.cmuhatia.playground.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 09/04/2022
 */
public class InsertionSortTest {

    @Test
    public void sort() {
        Integer[] array = {14, 33, 27, 10, 35, 19, 42, 44};
        InsertionSort.sort(array);
        assertArrayEquals(new Integer[]{10, 14, 19, 27, 33, 35, 42, 44}, array);
    }

    @Test
    public void sort2() {
        Integer[] array = {8, 2, 4, 9, 3};
        InsertionSort.sort(array);
        assertArrayEquals(new Integer[]{2, 3, 4, 8, 9}, array);
    }
}