package com.cmuhatia.playground.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 09/11/2021
 */
public class RedBlackBinaryTreeTest {

    @Test
    public void canAddSingleNode() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> ten = new ColoredNode<>(10);
        tree.add(ten);

        assertTrue(tree.getRootNode().isBlack());
        assertEquals(ten.getValue(), tree.getRootNode().getValue());
    }

    @Test
    public void canAddTest2() {
        // Insert values: 4, 7, 12, 15, 3, 5, 14, 18, 16, 17
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> four = new ColoredNode<>(4);
        tree.add(four);

        assertEquals(four, tree.getRootNode());

        ColoredNode<Integer> seven = new ColoredNode<>(7);
        tree.add(seven);

        assertEquals(seven, four.getRightChild());

        ColoredNode<Integer> twelve = new ColoredNode<>(12);
        tree.add(twelve);

        assertEquals(seven, tree.getRootNode());
        assertTrue(seven.isBlack());
        assertEquals(four, seven.getLeftChild());
        assertEquals(twelve, seven.getRightChild());

        ColoredNode<Integer> fifteen = new ColoredNode<>(15);
        tree.add(fifteen);

        assertEquals(fifteen, twelve.getRightChild());
        assertTrue(four.isBlack());
        assertTrue(twelve.isBlack());

        ColoredNode<Integer> three = new ColoredNode<>(3);
        tree.add(three);

        assertTrue(three.isRed());
        assertEquals(three, four.getLeftChild());

        ColoredNode<Integer> five = new ColoredNode<>(5);
        tree.add(five);

        assertTrue(five.isRed());
        assertEquals(five, four.getRightChild());

        ColoredNode<Integer> fourteen = new ColoredNode<>(14);
        tree.add(fourteen);

        assertEquals(fourteen, seven.getRightChild());
        assertTrue(fourteen.isBlack());
        assertEquals(twelve, fourteen.getLeftChild());
        assertTrue(twelve.isRed());
        assertEquals(fifteen, fourteen.getRightChild());
        assertTrue(fifteen.isRed());

        ColoredNode<Integer> eighteen = new ColoredNode<>(18);
        tree.add(eighteen);

        assertEquals(eighteen, fifteen.getRightChild());
        assertTrue(fourteen.isRed());
        assertTrue(twelve.isBlack());
        assertTrue(fifteen.isBlack());

        ColoredNode<Integer> sixteen = new ColoredNode<>(16);
        tree.add(sixteen);

        assertEquals(fourteen, sixteen.parent);
        assertEquals(fifteen, sixteen.getLeftChild());
        assertEquals(eighteen, sixteen.getRightChild());
        assertTrue(sixteen.isBlack());
        assertTrue(fifteen.isRed());
        assertTrue(eighteen.isRed());

        ColoredNode<Integer> seventeen = new ColoredNode<>(17);
        tree.add(seventeen);

        assertTrue(seventeen.isRed());
        assertTrue(eighteen.isBlack());
        assertTrue(fifteen.isBlack());
    }

    @Test
    public void canAddTest3() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>(List.of(15, 14, 11, 8, 7, 5, 4, 2, 1));

        assertEquals(8, tree.getRootNode().value);
        assertTrue(tree.getRootNode().isBlack());

        ColoredNode<Integer> five = tree.getRootNode().getLeftChild();
        assertEquals(5, five.value);
        assertTrue(five.isRed());

        ColoredNode<Integer> two = five.getLeftChild();
        assertEquals(2, two.value);
        assertTrue(two.isBlack());

        ColoredNode<Integer> one = two.getLeftChild();
        assertEquals(1, one.value);
        assertTrue(one.isRed());

        ColoredNode<Integer> four = two.getRightChild();
        assertEquals(4, four.value);
        assertTrue(four.isRed());

        ColoredNode<Integer> seven = five.getRightChild();
        assertEquals(7, seven.value);
        assertTrue(seven.isBlack());

        ColoredNode<Integer> fourteen = tree.getRootNode().getRightChild();
        assertEquals(14, fourteen.value);
        assertTrue(fourteen.isRed());

        ColoredNode<Integer> eleven = fourteen.getLeftChild();
        assertEquals(11, eleven.value);
        assertTrue(eleven.isBlack());

        ColoredNode<Integer> fifteen = fourteen.getRightChild();
        assertEquals(15, fifteen.value);
        assertTrue(fifteen.isBlack());
    }

    @Test
    public void canAddTest4() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>(
                List.of(10, 18, 7, 15, 16, 30, 25, 40, 60, 2, 1, 70)
        );

        assertEquals(16, tree.getRootNode().value);
        assertTrue(tree.getRootNode().isBlack());
        assertTrue(tree.contains(16));

        ColoredNode<Integer> ten = tree.getRootNode().getLeftChild();
        assertEquals(10, ten.value);
        assertTrue(ten.isBlack());

        ColoredNode<Integer> two = ten.getLeftChild();
        assertEquals(2, two.value);
        assertTrue(two.isBlack());

        ColoredNode<Integer> one = two.getLeftChild();
        assertEquals(1, one.value);
        assertTrue(one.isRed());
        assertTrue(tree.contains(1));

        ColoredNode<Integer> seven = two.getRightChild();
        assertEquals(7, seven.value);
        assertTrue(seven.isRed());

        ColoredNode<Integer> fifteen = ten.getRightChild();
        assertEquals(15, fifteen.value);
        assertTrue(fifteen.isBlack());

        ColoredNode<Integer> twentyFive = tree.getRootNode().getRightChild();
        assertEquals(25, twentyFive.value);
        assertTrue(twentyFive.isBlack());

        ColoredNode<Integer> eighteen = twentyFive.getLeftChild();
        assertEquals(18, eighteen.value);
        assertTrue(eighteen.isBlack());

        ColoredNode<Integer> forty = twentyFive.getRightChild();
        assertEquals(40, forty.value);
        assertTrue(forty.isRed());

        ColoredNode<Integer> thirty = forty.getLeftChild();
        assertEquals(30, thirty.value);
        assertTrue(thirty.isBlack());

        ColoredNode<Integer> sixty = forty.getRightChild();
        assertEquals(60, sixty.value);
        assertTrue(sixty.isBlack());

        ColoredNode<Integer> seventy = sixty.getRightChild();
        assertEquals(70, seventy.value);
        assertTrue(seventy.isRed());
        assertTrue(tree.contains(70));

        assertFalse(tree.contains(100));
    }

    @Test
    public void testRotateLeft() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> nodeEight = new ColoredNode<>(8);

        ColoredNode<Integer> nodeTen = new ColoredNode<>(10);
        nodeEight.setRightChild(nodeTen);

        ColoredNode<Integer> nodeNine = new ColoredNode<>(9);
        nodeTen.setLeftChild(nodeNine);

        tree.rotateLeft(nodeEight);

        assertEquals(nodeNine, nodeEight.getRightChild());
        assertEquals(nodeTen, tree.getRootNode());
        assertEquals(nodeEight, nodeTen.getLeftChild());
    }

    @Test
    public void testRotateLeft2() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> nodeEight = new ColoredNode<>(8);

        ColoredNode<Integer> nodeTen = new ColoredNode<>(10);
        nodeEight.setRightChild(nodeTen);

        tree.rotateLeft(nodeEight);

        assertEquals(nodeTen, tree.getRootNode());
        assertEquals(nodeEight, nodeTen.getLeftChild());
    }

    @Test
    public void testRotateLeft3() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> four = new ColoredNode<>(4);

        ColoredNode<Integer> seven = new ColoredNode<>(7);
        four.setRightChild(seven);

        ColoredNode<Integer> twelve = new ColoredNode<>(12);
        seven.setRightChild(twelve);

        tree.rotateLeft(four);

        assertEquals(seven, tree.getRootNode());
        assertEquals(four, seven.getLeftChild());
        assertEquals(twelve, seven.getRightChild());
    }

    @Test
    public void testRotateRight() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> fifteen = new ColoredNode<>(15);

        ColoredNode<Integer> fourteen = new ColoredNode<>(14);
        fifteen.setLeftChild(fourteen);

        tree.rotateRight(fifteen);

        assertEquals(fifteen, fourteen.getRightChild());
    }

    @Test
    public void deleteSimpleCase1() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> ten = new ColoredNode<>(10);
        tree.add(ten);

        ColoredNode<Integer> five = new ColoredNode<>(5);
        tree.add(five);

        ColoredNode<Integer> thirty = new ColoredNode<>(30);
        tree.add(thirty);

        tree.delete(thirty);

        assertEquals(ten, tree.getRootNode());
        assertEquals(five, ten.getLeftChild());
        assertTrue(tree.isNil(ten.getRightChild()));
    }

    @Test
    @DisplayName("Delete Case1 (Red leaf should be deleted without affecting the rest of the tree)")
    public void deletionCase1() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> ten = new ColoredNode<>(10);
        tree.add(ten);

        ColoredNode<Integer> five = new ColoredNode<>(5);
        tree.add(five);

        ColoredNode<Integer> thirty = new ColoredNode<>(30);
        tree.add(thirty);

        ColoredNode<Integer> two = new ColoredNode<>(2);
        tree.add(two);

        ColoredNode<Integer> nine = new ColoredNode<>(9);
        tree.add(nine);

        ColoredNode<Integer> twentyFive = new ColoredNode<>(25);
        tree.add(twentyFive);

        ColoredNode<Integer> forty = new ColoredNode<>(40);
        tree.add(forty);

        ColoredNode<Integer> thirtyEight = new ColoredNode<>(38);
        tree.add(thirtyEight);

        five.color = ColoredNode.COLOR_RED;
        thirty.color = ColoredNode.COLOR_RED;
        two.color = ColoredNode.COLOR_BLACK;
        nine.color = ColoredNode.COLOR_BLACK;
        twentyFive.color = ColoredNode.COLOR_BLACK;
        forty.color = ColoredNode.COLOR_BLACK;
        thirtyEight.color = ColoredNode.COLOR_RED;

        tree.delete(thirty);

        assertEquals(ten, tree.getRootNode());
        assertEquals(thirtyEight.value, ten.getRightChild().value);
        assertTrue(thirtyEight.isRed());
        assertTrue(tree.isNil(forty.getLeftChild()));
    }

    @Test
    @DisplayName("Delete Case3")
    public void deletionCase3() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> ten = new ColoredNode<>(10);
        tree.add(ten);

        ColoredNode<Integer> five = new ColoredNode<>(5);
        tree.add(five);

        ColoredNode<Integer> twenty = new ColoredNode<>(20);
        tree.add(twenty);

        ColoredNode<Integer> fifteen = new ColoredNode<>(15);
        tree.add(fifteen);

        ColoredNode<Integer> thirty = new ColoredNode<>(30);
        tree.add(thirty);

        ten.color = ColoredNode.COLOR_BLACK;
        five.color = ColoredNode.COLOR_BLACK;
        twenty.color = ColoredNode.COLOR_RED;
        fifteen.color = ColoredNode.COLOR_BLACK;
        thirty.color = ColoredNode.COLOR_BLACK;

        tree.delete(fifteen);
        assertTrue(twenty.isBlack());
        assertEquals(thirty, twenty.getRightChild());
        assertTrue(thirty.isRed());
    }

    @Test
    @DisplayName("Deletion all case 3 conditions")
    public void deletionAllCase3() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> ten = new ColoredNode<>(10);
        tree.add(ten);

        ColoredNode<Integer> five = new ColoredNode<>(5);
        tree.add(five);

        ColoredNode<Integer> twenty = new ColoredNode<>(20);
        tree.add(twenty);

        ColoredNode<Integer> one = new ColoredNode<>(1);
        tree.add(one);

        ColoredNode<Integer> seven = new ColoredNode<>(7);
        tree.add(seven);

        ColoredNode<Integer> fifteen = new ColoredNode<>(15);
        tree.add(fifteen);

        ColoredNode<Integer> thirty = new ColoredNode<>(30);
        tree.add(thirty);

        ten.color = ColoredNode.COLOR_BLACK;
        five.color = ColoredNode.COLOR_BLACK;
        twenty.color = ColoredNode.COLOR_BLACK;
        one.color = ColoredNode.COLOR_BLACK;
        seven.color = ColoredNode.COLOR_BLACK;
        fifteen.color = ColoredNode.COLOR_BLACK;
        thirty.color = ColoredNode.COLOR_BLACK;

        tree.delete(fifteen);

        assertEquals(five, ten.getLeftChild());
        assertTrue(five.isRed());

        assertEquals(twenty, ten.getRightChild());
        assertTrue(twenty.isBlack());
        assertTrue(tree.isNil(twenty.getLeftChild()));
        assertEquals(thirty, twenty.getRightChild());
        assertTrue(thirty.isRed());
    }

    @Test
    @DisplayName("Deletion case 4 and 2")
    public void deletionCase4And2() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> ten = new ColoredNode<>(10);
        tree.add(ten);

        ColoredNode<Integer> five = new ColoredNode<>(5);
        tree.add(five);

        ColoredNode<Integer> twenty = new ColoredNode<>(20);
        tree.add(twenty);

        ColoredNode<Integer> one = new ColoredNode<>(1);
        tree.add(one);

        ColoredNode<Integer> seven = new ColoredNode<>(7);
        tree.add(seven);

        ColoredNode<Integer> fifteen = new ColoredNode<>(15);
        tree.add(fifteen);

        ColoredNode<Integer> thirty = new ColoredNode<>(30);
        tree.add(thirty);

        ColoredNode<Integer> twentyFive = new ColoredNode<>(25);
        tree.add(twentyFive);

        ColoredNode<Integer> forty = new ColoredNode<>(40);
        tree.add(forty);

        ten.color = ColoredNode.COLOR_BLACK;
        five.color = ColoredNode.COLOR_BLACK;
        twenty.color = ColoredNode.COLOR_BLACK;
        one.color = ColoredNode.COLOR_BLACK;
        seven.color = ColoredNode.COLOR_BLACK;
        fifteen.color = ColoredNode.COLOR_BLACK;
        thirty.color = ColoredNode.COLOR_RED;
        twentyFive.color = ColoredNode.COLOR_BLACK;
        forty.color = ColoredNode.COLOR_BLACK;

        tree.delete(fifteen);

        assertEquals(thirty, ten.getRightChild());
        assertEquals(twenty, thirty.getLeftChild());
        assertTrue(twenty.isBlack());
        assertTrue(tree.isNil(twenty.getLeftChild()));
        assertEquals(twentyFive, twenty.getRightChild());
        assertTrue(twentyFive.isRed());
    }

    @Test
    public void deleteCase3And5And6() {
        RedBlackBinaryTree<Integer> tree = new RedBlackBinaryTree<>();

        ColoredNode<Integer> ten = new ColoredNode<>(10);
        tree.add(ten);

        ColoredNode<Integer> five = new ColoredNode<>(5);
        tree.add(five);

        ColoredNode<Integer> thirty = new ColoredNode<>(30);
        tree.add(thirty);

        ColoredNode<Integer> one = new ColoredNode<>(1);
        tree.add(one);

        ColoredNode<Integer> seven = new ColoredNode<>(7);
        tree.add(seven);

        ColoredNode<Integer> twentyFive = new ColoredNode<>(25);
        tree.add(twentyFive);

        ColoredNode<Integer> forty = new ColoredNode<>(40);
        tree.add(forty);

        ColoredNode<Integer> twenty = new ColoredNode<>(20);
        tree.add(twenty);

        ColoredNode<Integer> twentyEight = new ColoredNode<>(28);
        tree.add(twentyEight);

        ten.color = ColoredNode.COLOR_BLACK;
        five.color = ColoredNode.COLOR_BLACK;
        thirty.color = ColoredNode.COLOR_BLACK;
        one.color = ColoredNode.COLOR_BLACK;
        seven.color = ColoredNode.COLOR_BLACK;
        twentyFive.color = ColoredNode.COLOR_RED;
        forty.color = ColoredNode.COLOR_BLACK;
        twenty.color = ColoredNode.COLOR_BLACK;
        twentyEight.color = ColoredNode.COLOR_BLACK;

        tree.delete(one);

        assertEquals(twentyFive, tree.getRootNode());

        assertEquals(ten, twentyFive.getLeftChild());
        assertTrue(ten.isBlack());

        assertEquals(thirty, twentyFive.getRightChild());
        assertTrue(thirty.isBlack());

        assertEquals(five, ten.getLeftChild());
        assertTrue(five.isBlack());

        assertEquals(twenty, ten.getRightChild());
        assertTrue(twenty.isBlack());

        assertEquals(twentyEight, thirty.getLeftChild());
        assertTrue(twentyEight.isBlack());

        assertEquals(forty, thirty.getRightChild());
        assertTrue(forty.isBlack());

        assertEquals(seven, five.getRightChild());
        assertTrue(seven.isRed());
    }
}