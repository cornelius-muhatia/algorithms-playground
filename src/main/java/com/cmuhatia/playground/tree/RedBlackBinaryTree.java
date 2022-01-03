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
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Objects;

/**
 * @author Cornelius M.
 * @version 1.0.0, 31/10/2021
 */
@NoArgsConstructor
public class RedBlackBinaryTree<T extends Comparable<T>> {

    @Setter
    private ColoredNode<T> root;

    @Getter
    private int size = 0;

    public RedBlackBinaryTree(Collection<T> values) {
        this.add(values);
    }

    public ColoredNode<T> getRootNode() {
        return root;
    }

    public void add(T value) {
        add(new ColoredNode<>(value));
    }

    public void add(Collection<T> values) {
        values.forEach(this::add);
    }

    public void add(ColoredNode<T> node) {
        insert(node);

        insertFixup(node);
    }

    private void insert(ColoredNode<T> node) {
        if (root == null) {
            root = node;
            size++;

            return;
        }

        ColoredNode<T> current = root;

        while (true) {
            if (current.compareTo(node) > 0) {
                if (isNil(current.getLeftChild())) {
                    current.setLeftChild(node);
                    size++;
                    break;
                }

                current = current.getLeftChild();
            } else if (current.compareTo(node) < 0) {
                if (isNil(current.getRightChild())) {
                    current.setRightChild(node);
                    size++;
                    break;
                } else {
                    current = current.getRightChild();
                }
            } else {
                break;
            }
        }

        node.setParent(current);
    }

    private void insertFixup(ColoredNode<T> z) {
        if (!isNil(z.parent) && z.parent.isRed()) {
            ColoredNode<T> y = getSibling(z.parent);

            if (y.isRed()) {
                recolorTree(z.parent.parent);
            } else if (z.parent.isLeftChild()) {
                if (z.isRightChild()) {
                    rotateLeft(z.parent);

                    rotateRight(z.parent);

                    recolorParentNode(z, true);
                } else {
                    rotateRight(z.parent.parent);

                    recolorParentNode(z.parent, true);
                }
            } else {
                if (z.isLeftChild()) {
                    rotateRight(z.parent);

                    rotateLeft(z.parent);

                    recolorParentNode(z, true);
                } else {
                    rotateLeft(z.parent.parent);

                    recolorParentNode(z.parent, true);
                }
            }
        }

        root.color = ColoredNode.COLOR_BLACK; //May need refactoring.
    }

    private void recolorTree(ColoredNode<T> currentNode) {
        recolorParentNode(currentNode, false);

        insertFixup(currentNode);
    }

    private void recolorParentNode(ColoredNode<T> rootNode, boolean toBlack) {
        rootNode.color = toBlack;

        if (Objects.nonNull(rootNode.getRightChild())) {
            rootNode.getRightChild().color = !toBlack;
        }

        if (Objects.nonNull(rootNode.getLeftChild())) {
            rootNode.getLeftChild().color = !toBlack;
        }
    }

    void rotateLeft(ColoredNode<T> node) {
        ColoredNode<T> temp = node.getRightChild();

        node.setRightChild(temp.getLeftChild());

        swapNodeParent(temp, node);

        temp.setLeftChild(node);
    }

    void rotateRight(ColoredNode<T> node) {
        ColoredNode<T> temp = node.getLeftChild();

        node.setLeftChild(temp.getRightChild());

        swapNodeParent(temp, node);

        temp.setRightChild(node);
    }

    private void swapNodeParent(ColoredNode<T> currentNode, ColoredNode<T> previousNode) {
        if (isNil(previousNode.getParent())) {
            currentNode.parent = null;
            root = currentNode;

            return;
        }

        if (previousNode.isLeftChild()) {
            previousNode.getParent().setLeftChild(currentNode);

            return;
        }

        previousNode.getParent().setRightChild(currentNode);
    }

    public boolean isNil(ColoredNode<T> node) {
        return Objects.isNull(node) || (node instanceof ColoredNode.Nil);
    }

    private boolean isRootNode(ColoredNode<T> node) {
        return Objects.equals(this.root, node);
    }

    private ColoredNode<T> getSibling(ColoredNode<T> node) {
        return (node == node.getParent().getLeftChild()) ? node.getParent().getRightChild() : node.getParent().getLeftChild();
    }

    private ColoredNode<T> findSmallestNode(ColoredNode<T> node) {
        return isNil(node.getLeftChild()) ? node : findSmallestNode(node.getLeftChild());
    }

    public void delete(ColoredNode<T> z) {
        ColoredNode<T> y;
        boolean originalColor= z.color;

        ColoredNode<T> x;

        if (isNil(z.getLeftChild())) {
            x = z.getRightChild();
            transplant(z, z.getRightChild());
        } else if (isNil(z.getRightChild())) {
            x = z.getLeftChild();
            transplant(z, z.getLeftChild());
        } else {
            y = findSmallestNode(z.getRightChild());
            originalColor = y.color;

            x = y.getRightChild();

            if (!Objects.equals(y.parent, z)) {
                transplant(y, y.getRightChild());
                y.setRightChild(z.getRightChild());
            }

            transplant(z, y);
            y.setLeftChild(z.getLeftChild());
            y.color = z.color;
        }

        if (originalColor == ColoredNode.COLOR_BLACK) {
            deleteFixup(x);
        }
    }

    private void transplant(ColoredNode<T> u, ColoredNode<T> v) {
        if (isRootNode(u)) {
            this.root = v;
        } else if (u.isLeftChild()) {
            u.parent.setLeftChild(v);
        } else {
            u.parent.setRightChild(v);
        }

        v.parent = u.parent;
    }

    private void deleteFixup(ColoredNode<T> x) {
        while (!isRootNode(x) && x.isBlack()) {
            if (x.isLeftChild()) {
                ColoredNode<T> sibling = getSibling(x);

                if (sibling.isRed()) {
                    sibling.paintBlack();
                    x.parent.paintRed();

                    rotateLeft(x.parent);

                    sibling = getSibling(x);
                }

                if (sibling.getLeftChild().isBlack() && sibling.getRightChild().isBlack()) {
                    sibling.paintRed();
                    x = x.getParent();
                } else {
                    if (sibling.getRightChild().isBlack()) {
                        sibling.getLeftChild().paintBlack();
                        sibling.paintRed();

                        rotateRight(sibling);

                        sibling = x.parent.getRightChild();
                    }

                    sibling.color = x.parent.color;
                    x.parent.paintBlack();
                    sibling.getRightChild().paintBlack();

                    rotateLeft(x.parent);

                    x = root;
                }
            } else {
                ColoredNode<T> sibling = getSibling(x);

                if (sibling.isRed()) {
                    sibling.paintBlack();
                    x.parent.paintRed();

                    rotateRight(x.parent);

                    sibling = getSibling(x);
                }

                if (sibling.getLeftChild().isBlack() && sibling.getRightChild().isBlack()) {
                    sibling.paintRed();
                    x = x.getParent();
                } else {
                    if (sibling.getLeftChild().isBlack()) {
                        sibling.getRightChild().paintBlack();
                        sibling.color = ColoredNode.COLOR_RED;

                        rotateLeft(sibling);

                        sibling = x.parent.getRightChild();
                    }

                    sibling.color = x.parent.color;
                    x.parent.paintBlack();
                    sibling.getLeftChild().paintBlack();

                    rotateRight(x.parent);

                    x = root;
                }
            }
        }

        x.paintBlack();
    }

    /**
     * Used to search tree for the specified value. Time complexity is O(h) where h is the height of the tree
     *
     * @return true if it exists and false otherwise
     */
    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(ColoredNode<T> root, T value) {
        if (Objects.isNull(root)) {
            return false;
        }

        if (Objects.equals(root.value, value)) {
            return true;
        }

        if (Objects.isNull(root.value)) {
            return false;
        }

        if (root.value.compareTo(value) > 0) {
            return contains(root.getLeftChild(), value);
        } else {
            return contains(root.getRightChild(), value);
        }
    }
}
