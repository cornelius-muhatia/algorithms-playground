package com.cmuhatia.playground.sort.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortedArraysTest {

    @Test
    void test1() {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};

        MergeSortedArrays.merge(arr1, 3, arr2);

        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, arr1);
    }

    @Test
    void test2() {
        int[] arr1 = {1};
        int[] arr2 = new int[0];

        MergeSortedArrays.merge(arr1, 1, arr2);

        Assertions.assertArrayEquals(new int[]{1}, arr1);
    }

    @Test
    void test3() {
        int[] arr1 = {0};
        int[] arr2 = {1};

        MergeSortedArrays.merge(arr1, 0, arr2);

        Assertions.assertArrayEquals(new int[]{1}, arr1);
    }
}