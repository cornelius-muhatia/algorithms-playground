package com.cmuhatia.playground.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 17/07/2020
 */
public class MergeSortTest {

    @Test
    public void sort1() {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        MergeSort.sort(arr);
        assertArrayEquals(arr, new int[]{3, 9, 10, 27, 38, 43, 82});
    }

    @Test
    public void sort() {
        int[] arr = new int[]{3, 7, 8, 10, 5, 2, 1, 9, 5, 4, 10};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 5, 7, 8, 9, 10, 10}, arr);

        arr = new int[]{7, 6, 10, 5, 9, 2, 1, 15, 7};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 6, 7, 7, 9, 10, 15}, arr);

        arr = new int[]{1};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    public void sort3() {
        int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, arr);
    }
}