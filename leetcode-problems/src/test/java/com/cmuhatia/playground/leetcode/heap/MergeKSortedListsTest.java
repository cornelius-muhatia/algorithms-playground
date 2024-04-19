package com.cmuhatia.playground.leetcode.heap;

import com.cmuhatia.playground.leetcode.linked_list.dto.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeKSortedListsTest {

    @Test
    void of() {
        ListNode first5 = new ListNode(5);
        ListNode first4 = new ListNode(4, first5);
        ListNode first = new ListNode(1, first4);

        ListNode second4 = new ListNode(4);
        ListNode second3 = new ListNode(3, second4);
        ListNode second = new ListNode(1, second3);

        ListNode third6 = new ListNode(6);
        ListNode third = new ListNode(2, third6);

        ListNode[] input = {first, second, third};

        ListNode output6 = new ListNode(6);
        ListNode output5 = new ListNode(5, output6);
        ListNode output4 = new ListNode(4, output5);
        ListNode output42 = new ListNode(4, output4);
        ListNode output3 = new ListNode(3, output42);
        ListNode output2 = new ListNode(2, output3);
        ListNode output1 = new ListNode(1, output2);
        ListNode output = new ListNode(1, output1);

        assertEquals(output, MergeKSortedLists.of(input));
    }
}