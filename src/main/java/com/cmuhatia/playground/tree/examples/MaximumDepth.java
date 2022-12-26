package com.cmuhatia.playground.tree.examples;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MaximumDepth {

    public static int of(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getDepth(root, 1);
    }

    public static int getDepth(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            return depth;
        }

        if (node.left != null && node.right == null) {
            return getDepth(node.left, depth + 1);
        }

        if (node.left == null) {
            return getDepth(node.right, depth + 1);
        }

        return Math.max(getDepth(node.left, depth + 1), getDepth(node.right, depth + 1));
    }

    @AllArgsConstructor
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
