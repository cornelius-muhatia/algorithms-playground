package com.cmuhatia.playground.leetcode.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SameTreeTest {

    @Test
    void isSameTree() {
        SameTree.TreeNode tree1 = new SameTree.TreeNode(
                1,
                new SameTree.TreeNode(2),
                new SameTree.TreeNode(3)
        );

        SameTree.TreeNode tree2 = new SameTree.TreeNode(
                1,
                new SameTree.TreeNode(2),
                new SameTree.TreeNode(3)
        );

        assertTrue(SameTree.isSameTree(tree1, tree2));
    }

    @Test
    void isSameTree2() {
        SameTree.TreeNode tree1 = new SameTree.TreeNode(
                1,
                new SameTree.TreeNode(2),
                null
        );

        SameTree.TreeNode tree2 = new SameTree.TreeNode(
                1,
                null,
                new SameTree.TreeNode(2)
        );

        assertFalse(SameTree.isSameTree(tree1, tree2));
    }
}