package com.cmuhatia.playground.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sarajQuickSort(){
        int[] arr = {10, 80, 30, 90, 40, 50, 70};

        QuickSort.quickSort(arr);

        assertArrayEquals(new int[]{10, 30, 40, 50, 70, 80, 90}, arr);
    }

    @Test
    void quickSortTest2() {
        int[] arr = {3, 7, 8, 10, 5, 2, 1, 9, 5, 4, 10};
        QuickSort.quickSort(arr);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 5, 7, 8, 9, 10, 10}, arr);
    }
}