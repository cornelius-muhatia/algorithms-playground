package com.cmuhatia.playground.design;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class ShuffleArray {

    private final int[] nums;

    private final Random random = new Random();


    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] tempArr = new int[nums.length];
        System.arraycopy(nums, 0, tempArr, 0, tempArr.length);

        for (int i = nums.length; i > 1; i--) {
            swap(tempArr, i - 1, random.nextInt(i));
        }

        return tempArr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
