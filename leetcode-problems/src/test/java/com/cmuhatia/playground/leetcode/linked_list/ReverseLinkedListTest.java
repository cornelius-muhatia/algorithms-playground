package com.cmuhatia.playground.leetcode.linked_list;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReverseLinkedListTest {

    @Test
    void of() {
        assertNull(ReverseLinkedList.of(null));
    }

    @Test
    void of2() {
        ReverseLinkedList.ListNode input = new ReverseLinkedList.ListNode(1);
        assertEquals(input, ReverseLinkedList.of(input));
    }

    @Test
    void of3() {
        ReverseLinkedList.ListNode input = new ReverseLinkedList.ListNode(1);
        input.next = new ReverseLinkedList.ListNode(2);


        ReverseLinkedList.ListNode output = new ReverseLinkedList.ListNode(2);
        output.next = new ReverseLinkedList.ListNode(1);

        assertEquals(output, ReverseLinkedList.of(input));
    }

    @Test
    void of4() {
        ReverseLinkedList.ListNode input = new ReverseLinkedList.ListNode(1);
        ReverseLinkedList.ListNode two = new ReverseLinkedList.ListNode(2);
        input.next = two;
        ReverseLinkedList.ListNode three = new ReverseLinkedList.ListNode(3);
        two.next = three;
        ReverseLinkedList.ListNode four = new ReverseLinkedList.ListNode(4);
        three.next = four;
        four.next = new ReverseLinkedList.ListNode(5);

        ReverseLinkedList.ListNode output = new ReverseLinkedList.ListNode(5);
        ReverseLinkedList.ListNode output4 = new ReverseLinkedList.ListNode(4);
        output.next = output4;
        ReverseLinkedList.ListNode output3 = new ReverseLinkedList.ListNode(3);
        output4.next = output3;
        ReverseLinkedList.ListNode output2 = new ReverseLinkedList.ListNode(2);
        output3.next = output2;
        output2.next = new ReverseLinkedList.ListNode(1);

        assertEquals(output, ReverseLinkedList.of(input));
    }
}