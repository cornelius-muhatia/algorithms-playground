package com.cmuhatia.playground.linked_list;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @see <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/">From Leetcode</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SinglyLinkedList {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    @AllArgsConstructor
    public static class ListNode {
        int val;
        ListNode next;

    }
}
