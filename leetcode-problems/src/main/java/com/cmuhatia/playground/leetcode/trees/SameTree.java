package com.cmuhatia.playground.leetcode.trees;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/same-tree/">Leetcode - Same Tree</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    @NoArgsConstructor
    @AllArgsConstructor
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
