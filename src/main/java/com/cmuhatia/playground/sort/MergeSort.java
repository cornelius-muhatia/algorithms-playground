package com.cmuhatia.playground.sort;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr) {
        MergeSort.sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int midPoint = (high + low) / 2;
            System.out.println("Left partition low " + low + ", high " + midPoint);
            sort(arr, low, midPoint);
            System.out.println("Right partition low " + midPoint + ", high " + high);
            sort(arr, midPoint + 1, high);
            sort(arr, low, midPoint, high);
        }
    }

    private static void sort(int[] array, int low, int midPoint, int high) {
        int[] lArray = new int[midPoint - low + 1];
        int[] rArray = new int[high - midPoint];
        //Copy elements into an array
        for(int i = 0; i < lArray.length; i++){
            lArray[i] = array[low + i];
        }
        for(int i = 0; i < rArray.length; i++){
            rArray[i] = array[midPoint + i + 1];
        }
        System.out.println("Left Array " + Arrays.toString(lArray));
        System.out.println("Right array " + Arrays.toString(rArray));
        int leftIdx = 0;
        int rightIdx = 0;
        for(int i = low; i < high + 1; i++){
            if(leftIdx < lArray.length && rightIdx < rArray.length){
                if(lArray[leftIdx] < rArray[rightIdx]){
                    array[i] = lArray[leftIdx];
                    leftIdx++;
                } else{
                    array[i] = rArray[rightIdx];
                    rightIdx++;
                }
            } else if(leftIdx < lArray.length){
                array[i] = lArray[leftIdx];
                leftIdx++;
            } else if(rightIdx < rArray.length){
                array[i] = rArray[rightIdx];
                rightIdx++;
            }
        }
        System.out.println("Sorted partition " + Arrays.toString(array));

    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 6, 8, 5, 3, 7};
        MergeSort.sort(arr);
        System.out.printf("Final sorted array %s \n", Arrays.toString(arr));
    }
}
