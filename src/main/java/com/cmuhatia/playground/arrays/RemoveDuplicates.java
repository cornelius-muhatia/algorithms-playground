package com.cmuhatia.playground.arrays;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RemoveDuplicates {

    public static int from(int[] arr) {
        int j = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j] && j < (i + 1)) {
                j++;
                arr[j] = arr[i];
            }
        }

        return arr.length > 1 ? (j + 1) : arr.length;
    }
}
