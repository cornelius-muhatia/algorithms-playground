package com.cmuhatia.playground.leetcode.linked_list;

import com.cmuhatia.playground.leetcode.linked_list.dto.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DetectLinkedListCycleTest {

    @Test
    void ofNull() {
        assertFalse(DetectLinkedListCycle.of(null));
    }

    @Test
    void ofOne() {
        assertFalse(DetectLinkedListCycle.of(new ListNode(0)));

        var head = new ListNode(0);
        head.setNext(head);
        assertTrue(DetectLinkedListCycle.of(head));
    }

    @Test
    void of1() {
        var head = new ListNode(3);

        var two = new ListNode(2);
        head.setNext(two);

        var zero = new ListNode(0);
        two.setNext(zero);

        var minusFour = new ListNode(-1);
        zero.setNext(minusFour);
        minusFour.setNext(two);

        assertTrue(DetectLinkedListCycle.of(head));
    }

    @Test
    void of2() {
        var head = new ListNode(3);

        var two = new ListNode(2);
        head.setNext(two);

        var zero = new ListNode(0);
        two.setNext(zero);

        var minusFour = new ListNode(-1);
        zero.setNext(minusFour);

        assertFalse(DetectLinkedListCycle.of(head));
    }

    @Test
    void of3() {
        var head = new ListNode(3);

        var two = new ListNode(2);
        head.setNext(two);

        var zero = new ListNode(0);
        two.setNext(zero);

        var seven = new ListNode(7);
        zero.setNext(seven);

        var nine = new ListNode(9);
        seven.setNext(nine);

        var minusFour = new ListNode(-1);
        seven.setNext(minusFour);
        minusFour.setNext(two);

        assertTrue(DetectLinkedListCycle.of(head));
    }
}