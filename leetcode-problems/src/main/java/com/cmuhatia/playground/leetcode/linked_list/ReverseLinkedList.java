package com.cmuhatia.playground.leetcode.linked_list;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReverseLinkedList {

    public static ListNode of(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;
        while (next != null) {
            previous = new ListNode(current.val, previous);
            current = new ListNode(next.val, previous);
            next = next.next;
        }

        return current;
    }

    @AllArgsConstructor
    @Data
    @EqualsAndHashCode
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
