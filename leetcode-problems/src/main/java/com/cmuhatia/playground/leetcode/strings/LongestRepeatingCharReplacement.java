package com.cmuhatia.playground.leetcode.strings;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * </p>
 *
 * <p>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">LeetCode - Longest Repeating Character Replacement</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LongestRepeatingCharReplacement {

    public static int of(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }


        int longestLength = 0;

        for (int i = 0; i < s.length(); i++) {
            int length = 1;
            int remainder = k;
            char currentChar = s.charAt(i);

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == currentChar) {
                    length++;
                } else if (remainder > 0) {
                    length++;
                    remainder--;
                }
            }

            longestLength = Math.max(length, longestLength);
        }

        return longestLength;
    }
}
