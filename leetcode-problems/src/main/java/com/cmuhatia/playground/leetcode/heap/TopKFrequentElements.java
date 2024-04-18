package com.cmuhatia.playground.leetcode.heap;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/top-k-frequent-elements/description/">LeetCode - Top K Frequent Elements</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TopKFrequentElements {

    public static int[] of(int[] numbers, int k) {
        int[] output = new int[k];

        Map<Integer, Integer> numberGroups = groupNumbersByFreq(numbers);

        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        queue.addAll(numberGroups.entrySet());

        int idx = 0;
        while (idx < k && !queue.isEmpty()) {
            output[idx] = queue.poll().getKey();
            idx++;
        }

        return output;
    }

    private static Map<Integer, Integer> groupNumbersByFreq(int[] numbers) {
        Map<Integer, Integer> numberGroups = new HashMap<>();
        for (var no : numbers) {
            numberGroups.merge(no, 1, Integer::sum);
        }

        return numberGroups;
    }


}
