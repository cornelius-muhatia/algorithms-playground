package com.cmuhatia.playground.leetcode.arrays;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.</p>
 *
 * @see <a href="https://leetcode.com/problems/majority-element/">LeetCode - Majority Element</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MajorityElement {

    public static int of(int[] arr) {
        int currentVal = 0;
        int count = 0;

        for (int j : arr) {
            if (count == 0) {
                currentVal = j;
                count = 1;
            } else if (currentVal == j) {
                count++;
            } else {
                count--;
            }
        }

        return currentVal;
    }
}
