package com.cmuhatia.playground.leetcode.linked_list;

import com.cmuhatia.playground.leetcode.dto.ListNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>Given head, the head of a linked list, determine if the linked list has a cycle in it.</p>
 *
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">Leetcode - Linked List Cycle</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DetectLinkedListCycle {

    /**
     * <h3>Floyd's tortoise and hare algorithm</h3>
     * <p>
     * See the algorithm video explanation on: <a href="https://youtu.be/gBTe7lFR3vc">Neetcode - Youtube</a>
     * </p>
     * The code is thanks to: <a href="https://youtu.be/6OrZ4wAy4uE">Nick White - Youtube</a>
     */
    public static boolean of(ListNode node) {
        if (node == null) {
            return false;
        }

        var slow = node;
        var fast = node.getNext();

        while (slow != fast) {
            if (fast == null || fast.getNext() == null) {
                return false;
            }

            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return true;
    }

}
