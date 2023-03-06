package com.cmuhatia.playground.leetcode.trees;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <p>Given the root of a binary tree, return its maximum depth.</p>
 * <p>A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">LeetCode - Maximum Depth of Binary Tree</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MaxTreeDepth {

    /**
     * Credits to: <a href="https://youtu.be/hTM3phVI6YQ">NeedCode</a>
     */
    public static int of(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(of(root.left), of(root.right));
    }

    @AllArgsConstructor
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
