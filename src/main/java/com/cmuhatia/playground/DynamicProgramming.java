package com.cmuhatia.playground;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {

    /**
     * Get fibonacci sequence using recursion time complexity is O(2^n)
     *
     * @param n {@link Long}
     * @return final fibonacci sequence
     */
    public static long fibonacciSeqRecursion(long n){
        if (n == 1 || n == 2){
            System.out.println("-------------> Fibonacci seq of " + n + " => 1");
            return 1;
        } else {
            return fibonacciSeqRecursion(n - 1) + fibonacciSeqRecursion(n - 2);
        }
    }

    /**
     * Get fibonacci sequence using Memoization time complexity O(n)
     *
     * @param n fibonacci sequence length
     * @param seqs sequence array of size n
     * @return fibonacci sequence
     */
    public static int fibonacciSeqMemoization(int n, Integer[] seqs){
        if(seqs[n-1] != null) {
            return seqs[n-1];
        } else {
            int result;
            if (n == 1 || n == 2){
                result = 1;
            } else {
                result = fibonacciSeqMemoization(n - 1, seqs) + fibonacciSeqMemoization(n - 2, seqs);
            }
            seqs[n-1] = result;
            return result;
        }
    }

    /**
     * Get fibonacci sequence using bottom up approach O(n)
     *
     * @param n fibonacci sequence length
     * @return last value of the sequence
     */
    public static int fibonacciSeqBottomUp(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        int[] seq = new int[n];
        seq[0] = 1;
        seq[1] = 1;
        for(int i = 2; i < n; i++) {
            seq[i] = seq[i - 1] + seq[i - 2];
        }
        return seq[n - 1];
    }

    /**
     * Gets the longest increasing sequence in a list. For example:
     * [16, 3, 5, 19, 10, 14, 12, 0, 15] will return [3, 5, 10, 12, 15]
     *
     * @param sequence {@link List}
     * @return longest sub sequence of the given list
     */
    public static List<Integer> longestIncreasingSequence(List<Integer> sequence) {
        if(sequence.isEmpty()){
            return sequence;
        }
        List<Integer> subSeq = new ArrayList<>();
        subSeq.add(sequence.get(0));
        for(int i = 1; i < sequence.size(); i++){
            if(subSeq.get(subSeq.size() - 1) > sequence.get(i)) {
                subSeq.set(subSeq.size() - 1, sequence.get(i));
            } else {
                subSeq.add(sequence.get(i));
            }
        }
        return subSeq;
    }

    public static void main(String[] args) {
        Integer[] memo = new Integer[5];
        System.out.println("Fibonacci sequence using memoization " + fibonacciSeqMemoization(5, memo));
    }

}
