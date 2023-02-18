package com.cmuhatia.playground.tree.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthTest {

    @Test
    void testMaximumDepth() {
        MaximumDepth.TreeNode fifteen = new MaximumDepth.TreeNode(15, null, null);
        MaximumDepth.TreeNode seven = new MaximumDepth.TreeNode(7, null, null);
        MaximumDepth.TreeNode twenty = new MaximumDepth.TreeNode(20, fifteen, seven);

        MaximumDepth.TreeNode nine = new MaximumDepth.TreeNode(9, null, null);

        MaximumDepth.TreeNode root = new MaximumDepth.TreeNode(3, nine, twenty);

        assertEquals(3, MaximumDepth.of(root));
    }

    @Test
    void testMaximumDepth2() {
        MaximumDepth.TreeNode root = new MaximumDepth.TreeNode(3, null, null);

        assertEquals(1, MaximumDepth.of(root));
    }

    @Test
    void testMaximumDepth3() {
        MaximumDepth.TreeNode fifteen = new MaximumDepth.TreeNode(15, null, null);
        MaximumDepth.TreeNode seven = new MaximumDepth.TreeNode(7, fifteen, null);
        MaximumDepth.TreeNode twenty = new MaximumDepth.TreeNode(20, seven, null);
        MaximumDepth.TreeNode root = new MaximumDepth.TreeNode(3, twenty, null);

        assertEquals(4, MaximumDepth.of(root));
    }

    @Test
    void testMaximumDepth4() {
        MaximumDepth.TreeNode fifteen = new MaximumDepth.TreeNode(15, null, null);
        MaximumDepth.TreeNode seven = new MaximumDepth.TreeNode(7, null, fifteen);
        MaximumDepth.TreeNode twenty = new MaximumDepth.TreeNode(20, null, seven);
        MaximumDepth.TreeNode root = new MaximumDepth.TreeNode(3, null, twenty);

        assertEquals(4, MaximumDepth.of(root));
    }

    @Test
    void testMaximumDepth5() {
        assertEquals(0, MaximumDepth.of(null));
    }
}