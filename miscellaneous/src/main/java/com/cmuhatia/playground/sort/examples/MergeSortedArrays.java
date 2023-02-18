package com.cmuhatia.playground.sort.examples;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * </p>
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * </p>
 *
 * @see <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/">Original Question From Leetcode</a>
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MergeSortedArrays {

    public static void merge(int[] firstArr, int m, int[] secondArr) {
        int[] lArray = new int[m];

        System.arraycopy(firstArr, 0, lArray, 0, lArray.length);

        int l = 0;
        int r = 0;

        for (int i = 0; i < firstArr.length; i++) {

            if (l < lArray.length && r < secondArr.length) {
                if (lArray[l] <= secondArr[r]) {
                    firstArr[i] = lArray[l];
                    l++;

                    continue;
                }

                firstArr[i] = secondArr[r];
                r++;
            } else if (l < lArray.length) {
                firstArr[i] = lArray[l];
                l++;
            } else if (r < secondArr.length) {
                firstArr[i] = secondArr[r];
                r++;
            }

        }
    }
}
