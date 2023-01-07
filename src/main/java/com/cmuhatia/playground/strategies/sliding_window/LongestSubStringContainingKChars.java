package com.cmuhatia.playground.strategies.sliding_window;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a positive number k, find the longest substring of the string containing k distinct characters.
 * If k is more than the total number of distinct characters in the string, return the whole string.
 *
 * @see <a href="https://www.techiedelight.com/find-longest-substring-containing-k-distinct-characters/">Tech Delight</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LongestSubStringContainingKChars {

    public static String of(String input, int k) {
        if (stringIsEmpty(input)) {
            return "";
        }

        int startIdx = 0;
        int endIdx = 0;

        Map<Character, Integer> windowChars = new HashMap<>(k);
        int windowStartIdx = 0;

        for (int i = 0; i < input.length(); i++) {
            incrementMapValue(windowChars, input.charAt(i));

            while (windowChars.size() > k) {
                decrementMapValue(windowChars, input.charAt(windowStartIdx));
                windowStartIdx++;
            }

            if ((i - windowStartIdx) > (endIdx - startIdx)) {
                startIdx = windowStartIdx;
                endIdx = i;
            }
        }

        return windowChars.size() < k ? "" : input.substring(startIdx, endIdx + 1);
    }

    private static boolean stringIsEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private static void incrementMapValue(Map<Character, Integer> windowChars, Character key) {
        windowChars.compute(
                key,
                (k, v) -> (v == null) ? 1 : (v + 1)
        );
    }

    /**
     * Decrements map value. If value is less than 1, the key is removed from the {@link Map}.
     */
    private static void decrementMapValue(Map<Character, Integer> windowChars, Character key) {
        windowChars.computeIfPresent(
                key,
                (k, val) -> (val <= 1) ? null : (val - 1)
        );
    }
}
