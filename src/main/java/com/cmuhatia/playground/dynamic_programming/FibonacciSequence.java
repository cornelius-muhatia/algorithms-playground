package com.cmuhatia.playground.dynamic_programming;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FibonacciSequence {

    /**
     * Get fibonacci sequence using recursion time complexity is O(2^n)
     *
     * @param n {@link Long}
     * @return final fibonacci sequence
     */
    public static long fibonacciSeqRecursion(long n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fibonacciSeqRecursion(n - 1) + fibonacciSeqRecursion(n - 2);
    }

    /**
     * Get fibonacci sequence using Memoization time complexity O(n)
     *
     * @param n    fibonacci sequence length
     * @param seqs sequence array of size n
     * @return fibonacci sequence
     */
    public static int fibonacciSeqMemoization(int n, Integer[] seqs) {
        if (seqs[n - 1] == null) {
            seqs[n - 1] = (n == 1 || n == 2)
                    ? 1
                    : fibonacciSeqMemoization(n - 1, seqs) + fibonacciSeqMemoization(n - 2, seqs);

        }

        return seqs[n - 1];
    }

    /**
     * Get fibonacci sequence using bottom up approach O(n)
     *
     * @param n fibonacci sequence length
     * @return last value of the sequence
     */
    public static int fibonacciSeqBottomUp(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int priorPrev = 1;
        int previous = 1;

        for (int i = 2; i < n; i++) {
            int temp = priorPrev + previous;
            priorPrev = previous;
            previous = temp;
        }

        return previous;
    }

    /**
     * Gets the longest increasing sequence in a list. For example:
     * [16, 3, 5, 19, 10, 14, 12, 0, 15] will return [3, 5, 10, 12, 15]
     *
     * @param sequence {@link List}
     * @return longest sub sequence of the given list
     */
    public static List<Integer> longestIncreasingSequence(List<Integer> sequence) {
        if (sequence.isEmpty()) {
            return sequence;
        }
        List<Integer> subSeq = new ArrayList<>();
        subSeq.add(sequence.get(0));
        for (int i = 1; i < sequence.size(); i++) {
            if (subSeq.get(subSeq.size() - 1) > sequence.get(i)) {
                subSeq.set(subSeq.size() - 1, sequence.get(i));
            } else {
                subSeq.add(sequence.get(i));
            }
        }
        return subSeq;
    }

    public static List<Integer> longestIncreasingSequence2(List<Integer> list) {
        List<Integer> seq1 = new ArrayList<>();
        List<Integer> seq2 = new ArrayList<>();
        boolean populateFirst = true;
        for (int i = 0; i < list.size(); i++) {
            int lastIdx = -1;
            for (int j = i; j < list.size(); j++) {
                if (j == i) {
                    if (populateFirst) {
                        seq1.add(list.get(j));
                    } else {
                        seq2.add(list.get(j));
                    }
                    lastIdx = j;
                } else if (populateFirst && list.get(j) > seq1.get(seq1.size() - 1)) {
                    seq1.add(list.get(j));
                    lastIdx = j;
                } else if (!populateFirst && list.get(j) > seq2.get(seq2.size() - 1)) {
                    seq2.add(list.get(j));
                    lastIdx = j;
                } else if ((j + 1) == list.size()) {
                    if (populateFirst) {
                        seq1.remove(seq1.size() - 1);
                        if (seq1.isEmpty()) {
                            continue;
                        }
                    } else {
                        seq2.remove(seq2.size() - 1);
                        if (seq2.isEmpty()) {
                            continue;
                        }
                    }
                    for (int k = lastIdx; k < (list.size() - 1); k++) {
                        if (populateFirst) {
                            if (seq1.get(seq1.size() - 1) < list.get(k + 1)) {
                                seq1.add(list.get(k + 1));
                            }
                        } else {
                            if (seq2.get(seq2.size() - 1) < list.get(k + 1)) {
                                seq2.add(list.get(k + 1));
                            }
                        }
                    }
                }
            }
            if ((list.size() - 1) != i) {
                if (seq1.size() > seq2.size()) {
                    seq2.clear();
                    populateFirst = false;
                } else {
                    populateFirst = true;
                    seq1.clear();
                }
            }
        }
        return seq1.size() > seq2.size() ? seq1 : seq2;
    }

    /**
     * Get longest common subsequence list between 2 strings. For example:
     * <p>
     * Given:
     *     <ul>
     *         <li>abcdef</li>
     *         <li>acbcf</li>
     *     </ul>
     *     The common subsequence will be: <b>abcf</b>
     * </p>
     *
     * @param str1 First string
     * @param str2 Second string
     * @return a subsequence string
     */
    public static String getLongestCommonSubsequence(String str1, String str2) {
        StringBuilder subsequence = new StringBuilder();

        int rowLength = str1.length() + 1;
        int colLength = str2.length() + 1;
        int[][] temp = new int[rowLength][colLength];

        for (int row = 1; row < rowLength; row++) {
            for (int col = 1; col < colLength; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    temp[row][col] = temp[row - 1][col - 1] + 1;
                } else {
                    temp[row][col] = Math.max(temp[row][col - 1], temp[row - 1][col]);
                }
            }
        }

        int row = rowLength - 1;
        int col = colLength - 1;
        while (row > 0 && col > 0) {
            if (temp[row][col] == temp[row][col - 1]) {
                col--;
            } else if (temp[row][col] == temp[row - 1][col]) {
                row--;
            } else {
                subsequence.insert(0, str1.charAt(row - 1));
                row--;
                col--;
            }
        }

        return subsequence.toString();
    }
}
