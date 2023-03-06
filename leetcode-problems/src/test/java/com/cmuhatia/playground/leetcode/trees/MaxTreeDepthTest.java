package com.cmuhatia.playground.leetcode.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxTreeDepthTest {

    @Test
    void testMaxTreeDepth() {
        MaxTreeDepth.TreeNode fifteen = new MaxTreeDepth.TreeNode(15, null, null);
        MaxTreeDepth.TreeNode seven = new MaxTreeDepth.TreeNode(7, null, null);
        MaxTreeDepth.TreeNode twenty = new MaxTreeDepth.TreeNode(20, fifteen, seven);

        MaxTreeDepth.TreeNode nine = new MaxTreeDepth.TreeNode(9, null, null);

        MaxTreeDepth.TreeNode root = new MaxTreeDepth.TreeNode(3, nine, twenty);

        assertEquals(3, MaxTreeDepth.of(root));
    }

    @Test
    void testMaxTreeDepth2() {
        MaxTreeDepth.TreeNode root = new MaxTreeDepth.TreeNode(3, null, null);

        assertEquals(1, MaxTreeDepth.of(root));
    }

    @Test
    void testMaxTreeDepth3() {
        MaxTreeDepth.TreeNode fifteen = new MaxTreeDepth.TreeNode(15, null, null);
        MaxTreeDepth.TreeNode seven = new MaxTreeDepth.TreeNode(7, fifteen, null);
        MaxTreeDepth.TreeNode twenty = new MaxTreeDepth.TreeNode(20, seven, null);
        MaxTreeDepth.TreeNode root = new MaxTreeDepth.TreeNode(3, twenty, null);

        assertEquals(4, MaxTreeDepth.of(root));
    }

    @Test
    void testMaxTreeDepth4() {
        MaxTreeDepth.TreeNode fifteen = new MaxTreeDepth.TreeNode(15, null, null);
        MaxTreeDepth.TreeNode seven = new MaxTreeDepth.TreeNode(7, null, fifteen);
        MaxTreeDepth.TreeNode twenty = new MaxTreeDepth.TreeNode(20, null, seven);
        MaxTreeDepth.TreeNode root = new MaxTreeDepth.TreeNode(3, null, twenty);

        assertEquals(4, MaxTreeDepth.of(root));
    }

    @Test
    void testMaxTreeDepth5() {
        assertEquals(0, MaxTreeDepth.of(null));
    }
}