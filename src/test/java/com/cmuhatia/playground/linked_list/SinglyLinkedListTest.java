package com.cmuhatia.playground.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SinglyLinkedListTest {

    @Test
    void deleteNode() {
        SinglyLinkedList.ListNode last = new SinglyLinkedList.ListNode(9, null);
        SinglyLinkedList.ListNode one = new SinglyLinkedList.ListNode(1, last);
        SinglyLinkedList.ListNode five = new SinglyLinkedList.ListNode(5, one);
        new SinglyLinkedList.ListNode(4, five);

        SinglyLinkedList.deleteNode(one);

        assertEquals(9, five.next.val);
    }
}