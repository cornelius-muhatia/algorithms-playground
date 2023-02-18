package com.cmuhatia.playground.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesTest {

    @Test
    void from1() {
        int[] arr = {1};
        Assertions.assertEquals(1, RemoveDuplicates.from(arr));
        Assertions.assertEquals(1, arr[0]);
    }

    @Test
    void from2() {
        int[] arr = {1, 1, 2};
        Assertions.assertEquals(2, RemoveDuplicates.from(arr));
        Assertions.assertArrayEquals(new int[]{1, 2}, copyArray(arr, 1));
    }

    @Test
    void from3() {
        int[] arr = new int[10000];
        Assertions.assertEquals(1, RemoveDuplicates.from(arr));
        Assertions.assertEquals(0, arr[0]);
    }

    @Test
    void from4() {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Assertions.assertEquals(5, RemoveDuplicates.from(arr));
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 4}, copyArray(arr, 4));
    }

    private int[] copyArray(int[] arr, int endIdx) {
        int[] arrCopy = new int[endIdx + 1];
        System.arraycopy(arr, 0, arrCopy, 0, arrCopy.length);

        return arrCopy;
    }

}