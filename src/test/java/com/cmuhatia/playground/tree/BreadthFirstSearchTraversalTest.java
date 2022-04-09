package com.cmuhatia.playground.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 04/03/2022
 */
class BreadthFirstSearchTraversalTest {

    @Test
    public void canTraverseBinaryTree() {
        BinarySearchTree<Character> tree = new BinarySearchTree<>();
        tree.add('A');
        tree.add('B');
        tree.add('C');
        tree.add('D');
        tree.add('E');
        tree.add('F');
        tree.add('G');


        BreadthFirstSearchTraversal.traverseTree(tree);

    }

}