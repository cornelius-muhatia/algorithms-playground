package com.cmuhatia.playground.leetcode.linked_list;

import com.cmuhatia.playground.leetcode.dto.ListNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>Given the head of a singly linked list, reverse the list, and return the reversed list.</p>
 *
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">LeetCode Reverse LinkedList</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReverseLinkedList {

    public static ListNode of(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.getNext();
        while (next != null) {
            previous = new ListNode(current.getVal(), previous);
            current = new ListNode(next.getVal(), previous);
            next = next.getNext();
        }

        return current;
    }

}
