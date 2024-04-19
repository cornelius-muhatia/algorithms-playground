package com.cmuhatia.playground.leetcode.heap;

import com.cmuhatia.playground.leetcode.linked_list.dto.ListNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.</p>
 *
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">LeetCode - Merge k Sorted Lists</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MergeKSortedLists {

    /**
     * Credits to: <a href="https://medium.com/javarevisited/java-algorithms-merge-k-sorted-lists-leetcode-84c99000bfd7">Rusian R.</a>
     */
    public static ListNode of(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(
                Comparator.comparingInt(ListNode::getVal)
        );

        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }

        ListNode output = new ListNode(-1);
        ListNode current = output;
        while (!heap.isEmpty()) {
            current.setNext(heap.remove());
            ListNode next = current.getNext();

            if (next.getNext() != null) {
                heap.add(next.getNext());
                next.setNext(null);
            }

            current = next;
        }

        return output.getNext();
    }
}
