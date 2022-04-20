package com.cmuhatia.playground.sort;

/**
 * Merge sort worst case time complexity: O(n log n)
 */
public class MergeSort {

    /**
     * Sorts an array using merge sort
     * @param arr array to be sorted
     */
    public static void sort(int[] arr) {
        MergeSort.sort(arr, 0, arr.length - 1);
    }

    /**
     * Partitions the array inorder to sort individual partitions separately
     * @param arr array to be partitioned
     * @param low array start index
     * @param high array end index
     */
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int midPoint = (high + low) / 2;

            sort(arr, low, midPoint);
            sort(arr, midPoint + 1, high);
            sort(arr, low, midPoint, high);
        }
    }

    /**
     * Merges the partitions back to the original array
     * @param array original array
     */
    private static void sort(int[] array, int startIndex, int midPoint, int endIndex) {
        int[] lArray = new int[midPoint - startIndex + 1];

        int[] rArray = new int[endIndex - midPoint];

        //Copy elements into an array
        System.arraycopy(array, startIndex, lArray, 0, lArray.length);
        System.arraycopy(array, midPoint + 1, rArray, 0, rArray.length);

        int leftIdx = 0;
        int rightIdx = 0;
        for(int i = startIndex; i < endIndex + 1; i++) {
            if(leftIdx < lArray.length && rightIdx < rArray.length) {
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
    }
}
