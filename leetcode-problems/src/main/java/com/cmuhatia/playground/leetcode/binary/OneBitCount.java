package com.cmuhatia.playground.leetcode.binary;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * </p>
 *
 * <p>
 * <b>Note:</b> In java we will assume the integer is unsigned.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/number-of-1-bits">LeetCode - Number of 1 Bits</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OneBitCount {

    /**
     * Inspired by: <a href="https://youtu.be/wLHhAHkID9M">Algorithms Made Easy</a>
     */
    public static int of(int n) {
        int mask = 1;
        int count = 0;

        while (mask != 0) {
            if ((n & mask) != 0) {
                count++;
            }

            mask = mask << 1;
        }

        return count;
    }

    public static int of2(int n) {
        // Todo: Implement a slightly faster solution using the following formula: n & (n - 1). Refer to: https://youtu.be/5Km3utixwZs
        throw new UnsupportedOperationException();
    }
}
