/*
 * Copyright 2021 Cornelius M.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cmuhatia.playground.tree;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Objects;

/**
 * @author Cornelius M.
 * @version 1.0.0, 31/10/2021
 */
public class RedBlackBinaryTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    @Override
    public void add(Node<T> node) {
        ColoredNode<T> currentNode = (ColoredNode<T>) node;

        super.add(currentNode);

        if (currentNode == getRootNode()) {
            return;
        }

        if (currentNode.getParent().isColorBlack()) {
            return;
        }

        ColoredNode<T> parentsSibling = getSibling(currentNode.getParent());

        if (Objects.isNull(parentsSibling) || parentsSibling.isColorBlack()) {
            rotate(parentsSibling);
            recolorTree(parentsSibling);

            return;
        }

    }

    private ColoredNode<T> getSibling(ColoredNode<T> node) {
        return (ColoredNode<T>) (
                (node == node.getParent().getLeftChild())
                        ? node.getParent().getRightChild()
                        : node.getParent().getLeftChild()
        );
    }

    private void rotate(ColoredNode<T> rootNode) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void rotateLeft(ColoredNode<T> rootNode) {
        Node<T> temp = rootNode.getRightChild();

        rootNode.setRightChild(temp.getLeftChild());

        temp.setLeftChild(rootNode);

        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void rotateRight(ColoredNode<T> node) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void recolorTree(ColoredNode<T> currentNode) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void delete(Node<T> item) {
        super.delete(item);
    }

    @Getter
    @Setter
    public static class ColoredNode<T extends Comparable<T>> extends Node<T> {
        public static boolean COLOR_BLACK = true;
        public static boolean COLOR_RED = false;

        private boolean color;
        private ColoredNode<T> parent;

        /**
         * Default constructor
         *
         * @param value node value
         */
        public ColoredNode(T value) {
            super(value);

            this.color = COLOR_RED;
        }

        public boolean isColorBlack() {
            return this.color == COLOR_BLACK;
        }

        public boolean isColorRed() {
            return this.color == COLOR_RED;
        }
    }
}
