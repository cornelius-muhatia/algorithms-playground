package com.cmuhatia.playground.sort.examples;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.IntPredicate;

/**
 * <p>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * </p>
 *
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * </p>
 *
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 * </p>
 *
 * @see <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/774/">Original Problem From Leetcode</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FirstBadVersion {

    public static int find(int n, IntPredicate isBadVersion) {
        int start = 1;
        int midpoint = (start + n) / 2;
        int end = n;

        int bad = n;

        while (start < end && midpoint != end) {
            if (isBadVersion.test(midpoint)) {
                bad = midpoint;
                end = midpoint;

                long total = (long) start + (long) midpoint;
                midpoint = (int) (total / 2);
            } else {
                start = midpoint;

                long total = (long) start + (long) end + 1L;
                midpoint = (int) (total / 2);
            }
        }

        return bad;
    }
}
