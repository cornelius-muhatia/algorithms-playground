package com.cmuhatia.playground.strategies.two_pointer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Given a sorted array A (sorted in ascending order), having N integers,
 * find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X
 * </p>
 *
 * @see <a href="https://www.geeksforgeeks.org/two-pointers-technique/">LeetCode</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArrayElementSum {

    public static int[] of(int[] arr, int sum) {
        int i = 0;
        int j = arr.length - 1;
        
        while (i < j) {
            int k = arr[i] + arr[j];

            if (k == sum) {
                return new int[]{arr[i], arr[j]};
            }

            if (k < sum) {
                i++;
            } else {
                j--;
            }
        }

        return new int[0];
    }
}
