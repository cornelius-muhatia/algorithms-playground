package com.cmuhatia.playground.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class QuickSortTest {

    @Test
    public void sarajQuickSort(){
        int[] arr = {10, 80, 30, 90, 40, 50, 70};

        QuickSort.quickSort(arr);

        assertArrayEquals(new int[]{10, 30, 40, 50, 70, 80, 90}, arr);
    }
}