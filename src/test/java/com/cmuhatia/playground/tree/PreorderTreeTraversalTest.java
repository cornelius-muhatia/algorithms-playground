package com.cmuhatia.playground.tree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 27/02/2022
 */
class PreorderTreeTraversalTest {

    @Test
    public void testTraversal() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(List.of(4, 2, 6, 1, 3, 5, 7));
        PreorderTreeTraversal<Integer> inorderTraversal = new PreorderTreeTraversal<>(tree);

        assertEquals(new LinkedList<>(List.of(4, 2, 1, 3, 6, 5, 7)), inorderTraversal.traverse());
    }

}