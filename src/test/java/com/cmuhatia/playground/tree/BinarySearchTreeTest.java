package com.cmuhatia.playground.tree;

import com.cmuhatia.playground.tree.BinarySearchTree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 13/06/2020
 */
public class BinarySearchTreeTest {

    @Test
    public void add() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Node<Integer> ten = new Node<>(10);
        Node<Integer> three = new Node<>(3);
        assertFalse(bst.contains(ten));

        bst.add(ten);
        bst.add(new Node<>(5));
        bst.add(three);
        bst.add(new Node<>(1));
        bst.add(new Node<>(100));

        assertEquals(5, bst.getSize());
        assertTrue(bst.contains(ten));

        assertEquals(Integer.valueOf(100), ten.getRightChild().getValue());
        assertEquals(Integer.valueOf(5), ten.getLeftChild().getValue());
        assertEquals(Integer.valueOf(1), three.getLeftChild().getValue());
        assertNull(three.getRightChild());

    }

    @Test
    public void delete() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        Node<Integer> ten = new Node<>(10);
        tree.add(ten);

        tree.add(new Node<>(3));

        Node<Integer> five = new Node<>(5);
        tree.add(five);

        Node<Integer> six = new Node<>(6);
        tree.add(new Node<>(6));

        Node<Integer> two = new Node<>(2);
        tree.add(two);

        Node<Integer> twenty = new Node<>(20);
        tree.add(twenty);

        Node<Integer> thirty = new Node<>(30);
        tree.add(thirty);

        Node<Integer> fifteen = new Node<>(15);
        tree.add(fifteen);

        // Delete a node without children
        tree.delete(two);
        assertFalse(tree.contains(two));

        // Delete a node with one child
        tree.delete(five);
        assertFalse(tree.contains(five));

        // Delete a node with 2 children
        tree.delete(twenty);
        assertEquals(thirty.getValue(), tree.getRootNode().getRightChild().getValue());
    }

}