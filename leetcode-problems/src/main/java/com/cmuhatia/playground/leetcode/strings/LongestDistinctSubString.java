package com.cmuhatia.playground.leetcode.strings;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Given a string s, find the length of the longest substring without repeating characters.</p>
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">LeetCode - Longest Substring Without Repeating Characters</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LongestDistinctSubString {

    public static int length(String s) {
        Map<Character, Integer> visitedChar = new HashMap<>(255);
        int length = 0;
        int startIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            if (visitedChar.containsKey(s.charAt(i)) && visitedChar.get(s.charAt(i)) >= startIdx) {
                length = Math.max(length, i - startIdx);
                startIdx = visitedChar.get(s.charAt(i)) + 1;
                visitedChar.put(s.charAt(i), i);

                continue;
            }

            visitedChar.put(s.charAt(i), i);

            if (i == s.length() - 1) {
                length = Math.max(length, (i + 1) - startIdx);
            }
        }

        return length;
    }
}
