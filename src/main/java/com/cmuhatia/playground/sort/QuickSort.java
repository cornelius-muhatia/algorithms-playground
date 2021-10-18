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
     *
     * Refer to Saraj's tutorial <a href="https://youtu.be/pmEgsd1_nVg">Saraj Bahadur Youtube Video</a>
     *
     *
     * @param arr array to be sorted
     * @param low low index of the partition to be sorted
     * @param high high index of the partition to be sorted
     */
    public static void quickSort(int[] arr, int low, int high){
        int mid = (low + high)/2;
        int i = low;
        int j = high;
        int pivot = arr[mid];
        while(i <= j){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i<=j){
                swapIndexValues(arr, i, j);
                i++;
                j--;
            }
        }
        if(low < j){//sorting left side of the pivot
            QuickSort.quickSort(arr, low, j);
        }
        if(high > i){//sorting right side of the pivot
            QuickSort.quickSort(arr, i, high);
        }
    }

    private static void swapIndexValues(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
