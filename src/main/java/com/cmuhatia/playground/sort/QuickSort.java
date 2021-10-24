package com.cmuhatia.playground.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 7, 8, 10, 5, 2, 1, 9, 5, 4, 10};
        System.out.println("Array Before " + Arrays.toString(arr));
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println("Final sorted array" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        QuickSort.quickSort(arr, 0, arr.length - 1);
    }

    /**
     * The pivot is select as median value and all the elements less than median
     * moved to the left and greater than median moved to right.
     * <p>
     * Refer to Saraj's tutorial <a href="https://youtu.be/pmEgsd1_nVg">Saraj Bahadur Youtube Video</a>
     *
     * <p>Their is a possibility this implemention will consume a lot of memory because of the pivot</p>
     *
     * @param arr  array to be sorted
     * @param low  low index of the partition to be sorted
     * @param high high index of the partition to be sorted
     */
    public static void quickSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int l = low;
        int h = high;
        int pivot = arr[mid];

        while (l <= h) {
            while (arr[l] < pivot) {
                l++;
            }

            while (arr[h] > pivot) {
                h--;
            }

            if (l <= h) {
                swapIndexValues(arr, l, h);
                l++;
                h--;
            }
        }

        if (low < h) {//sorting left side of the pivot
            QuickSort.quickSort(arr, low, h);
        }

        if (high > l) {//sorting right side of the pivot
            QuickSort.quickSort(arr, l, high);
        }
    }

    private static void swapIndexValues(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
