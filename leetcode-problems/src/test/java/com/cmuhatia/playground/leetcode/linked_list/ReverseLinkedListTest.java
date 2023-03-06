package com.cmuhatia.playground.leetcode.linked_list;


import com.cmuhatia.playground.leetcode.dto.ListNode;
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
        ListNode input = new ListNode(1);
        assertEquals(input, ReverseLinkedList.of(input));
    }

    @Test
    void of3() {
        ListNode input = new ListNode(1);
        input.setNext(new ListNode(2));


        ListNode output = new ListNode(2);
        output.setNext(new ListNode(1));

        assertEquals(output, ReverseLinkedList.of(input));
    }

    @Test
    void of4() {
        ListNode input = new ListNode(1);
        ListNode two = new ListNode(2);
        input.setNext(two);
        ListNode three = new ListNode(3);
        two.setNext(three);
        ListNode four = new ListNode(4);
        three.setNext(four);
        four.setNext(new ListNode(5));

        ListNode output = new ListNode(5);
        ListNode output4 = new ListNode(4);
        output.setNext(output4);
        ListNode output3 = new ListNode(3);
        output4.setNext(output3);
        ListNode output2 = new ListNode(2);
        output3.setNext(output2);
        output2.setNext(new ListNode(1));

        assertEquals(output, ReverseLinkedList.of(input));
    }
}