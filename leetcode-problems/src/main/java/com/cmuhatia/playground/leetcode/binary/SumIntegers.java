package com.cmuhatia.playground.leetcode.binary;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Given two integers a and b, return the sum of the two integers without using the operators + and -
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/sum-of-two-integers/">Leetcode Sum of Two Integers</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SumIntegers {

    public static int of(int a, int b) {
        int sum = a ^ b;
        b = a & b;

        while (b != 0) {
            b = b << 1;
            int carry = sum & b;

            sum = sum ^ b;
            b = carry;
        }

        return sum;
    }


}
