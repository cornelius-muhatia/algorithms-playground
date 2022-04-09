package com.cmuhatia.playground.tree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 27/02/2022
 */
class PostorderTreeTraversalTest {

    @Test
    public void testTraversal() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(List.of(4, 2, 6, 1, 3, 5, 7));
        PostorderTreeTraversal<Integer> inorderTraversal = new PostorderTreeTraversal<>(tree);

        assertEquals(new LinkedList<>(List.of(1, 3, 2, 5, 7, 6, 4)), inorderTraversal.traverse());
    }
}