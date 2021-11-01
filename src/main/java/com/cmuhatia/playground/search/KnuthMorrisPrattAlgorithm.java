/*
 * Copyright 2019 Cornelius M.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cmuhatia.playground.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements Knuth Morris Pratt pattern matching Algorithm. More details on the algorithm can be found at:
 * <a href="https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm">Wikipedia</a>
 *
 * @author Cornelius M.
 * @version 1.0.0, 18/05/2020
 */
public class KnuthMorrisPrattAlgorithm<T> {

    /**
     * Used to find the prefix and suffix of the pattern sequence. Time complexity is O(n)
     *
     * @param pattern pattern sequence
     * @param <T>     Pattern sequence generic reference
     * @return array mapping suffix and prefix for example given {'a', 'c', 'd', 'd' 'a', 'c'},
     * will return {0, 0, 0, 0, 1, 2}
     */
    public static <T> int[] computeSuffixPrefix(T[] pattern) {
        int[] temp = new int[pattern.length];

        int i = 0;
        int j = 1;

        while (j < pattern.length) {
            if (pattern[i].equals(pattern[j])) {
                temp[j] = i + 1;
                j++;
                i++;
            } else if (i > 0) {
                i = temp[i - 1];
            } else {
                temp[j] = 0;
                j++;
            }
        }

        return temp;
    }

    /**
     * Used to search for a pattern inside a sequence using KMP Algorithm.
     *
     * @param sequence sequence of objects
     * @param pattern  pattern to be searched
     * @param <T>      Object generic reference
     * @return true if pattern exists otherwise false
     */
    public static <T> boolean contains(T[] sequence, T[] pattern) {
        int s = 0;
        int p = 0;

        int[] prefixSuffix = computeSuffixPrefix(pattern);

        while (s < sequence.length) {
            if (sequence[s].equals(pattern[p])) {
                s++;
                p++;
            } else if (p > 0) {
                p = prefixSuffix[p - 1];
            } else {
                s++;
            }
            if (p == pattern.length) {
                return true;
            }
        }
        return false;
    }

    /**
     * Used to find the prefix and suffix of a String. Time complexity is O(n)
     *
     * @param pattern pattern sequence
     * @return array mapping suffix and prefix for example given: acddac,
     * will return {0, 0, 0, 0, 1, 2}
     */
    public static int[] computeSuffixPrefix(String pattern) {
        int[] temp = new int[pattern.length()];

        int i = 0;
        int j = 1;

        while (j < pattern.length()) {
            if (Character.toLowerCase(pattern.charAt(i)) == Character.toLowerCase(pattern.charAt(j))) {
                temp[j] = i + 1;
                j++;
                i++;
            } else if (i > 0) {
                i = temp[i - 1];
            } else {
                temp[j] = 0;
                j++;
            }
        }

        return temp;
    }

    /**
     * Counts pattern occurrence within a text. Occurrences can overlap.
     *
     * @param text    String sentence/paragraph
     * @param pattern String pattern
     * @return number of occurrence
     */
    public static int countStringOccurrence(String text, String pattern) {
        int[] prefixSuffix = computeSuffixPrefix(pattern);

        int count = 0;

        int i = 0; // text index
        int j = 0; // pattern index

        while (i < text.length()) {
            if (Character.toLowerCase(text.charAt(i)) == Character.toLowerCase(pattern.charAt(j))) {
                i++;
                j++;
            } else if (j > 0) {
                j = prefixSuffix[j - 1];
            } else {
                i++;
            }

            if (j == pattern.length()) {
                count++;
                i = i - (pattern.length() - 1);
                j = 0;
            }
        }

        return count;
    }

    public static String getRelatedWords(String text, String pattern, int nearWordsCount) {
        int trailNearIdx = 0;
        Map<String, Integer> nearWords = new HashMap<>();
        int[] prefixSuffix = computeSuffixPrefix(pattern);
        int i = 0;//text index
        int j = 0;//pattern index
        while (i < text.length()) {
            if (Character.isSpaceChar(text.charAt(i)) && (i % nearWordsCount == 0)) {
                trailNearIdx = i;
            }
            if (Character.toLowerCase(text.charAt(i)) == Character.toLowerCase(pattern.charAt(j))) {
                i++;
                j++;
            } else if (j > 0) {
                j = prefixSuffix[j - 1];
            } else {
                i++;
            }
            if (j == pattern.length()) {
                String word = text.substring(trailNearIdx, i);
//                i = i - (pattern.length() - 1);
                j = 0;
            }
        }
        return "";
    }

    public static List<String> getPrecedenceStr(String text, int currentIdx, int noWords) {
        ArrayList<String> strings = new ArrayList<>(noWords);
        int lastIdx = currentIdx;
        for (int i = currentIdx; i >= 0; i--) {
            if (Character.isSpaceChar(text.charAt(i))) {
                strings.add(text.substring((i + 1), lastIdx));
                lastIdx = i - 1;
            } else if (i == 0) {
                strings.add(text.substring(0, lastIdx));
            }
            if (strings.size() == noWords) {
                break;
            }
        }
        System.out.println(strings);
        return strings;
    }
}
