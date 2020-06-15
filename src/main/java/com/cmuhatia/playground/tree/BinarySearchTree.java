/*
 * Copyright 2019 Cornelius M.
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

import java.util.Objects;

/**
 * @author Cornelius M.
 * @version 1.0.0, 13/06/2020
 */
public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * Private root node
     */
    private Node<T> root;
    /**
     * Number of nodes in a graph
     */
    private int size = 0;

    private int height = 0;

    /**
     * Default constructor
     */
    public BinarySearchTree() {

    }

    /**
     * Gets number nodes in the graph
     *
     * @return number of nodes
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds a node to the tree. Time complexity is O(h) where h is the height of the tree
     *
     * @param node {@link Node}
     */
    public void add(Node<T> node) {
        if (root == null) {
            root = node;
            size++;
            return;
        }
        Node<T> current = root;
        while (true) {
            if (current.value.compareTo(node.value) > -1) {
                if (Objects.isNull(current.leftChild)) {
                    current.leftChild = node;
                    size++;
                    break;
                }
                current = current.leftChild;
            } else {
                if (Objects.isNull(current.rightChild)) {
                    current.rightChild = node;
                    size++;
                    break;
                } else {
                    current = current.rightChild;
                }
            }
        }
    }

    /**
     * Used to search tree for the specified item. Time complexity is O(h) where h is the height of the tree
     *
     * @param item {@link Node} item to be searched
     * @return true if it exists and false otherwise
     */
    public boolean contains(Node<T> item){
        return contains(root, item);
    }

    /**
     * Recursive method for searching an item. Time complexity is O(h) where h is the height of the tree
     * @param root root of the sub-tree
     * @param item item to be searched
     * @return true if the item exists false otherwise
     */
    private boolean contains(Node<T> root, Node<T> item){
        if(Objects.equals(root, item)){
            return true;
        } else if(Objects.isNull(root)){
            return false;
        }
        if(item.value.compareTo(root.value) < 0){
            return contains(root.leftChild, item);
        } else{
            return contains(root.rightChild, item);
        }
    }

    public void delete(Node<T> item){
        Node<T> current = root;
        while(Objects.nonNull(current)){
            if(item.equals(current)){

            }
            if(Objects.nonNull(root.leftChild)
                    && root.leftChild.value.compareTo(item.value) < 0){

            }
        }
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> current = root;
//        while(Objects.nonNull(current)){
//
//        }
        return str;
    }

    /**
     * Used represent the node of the the tree. Properties include:
     * <ul>
     *     <li>Value</li>
     *     <li>left child</li>
     *     <li>right child</li>
     * </ul>
     *
     * @param <T> generic reference
     */
    public static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        /**
         * Default constructor
         *
         * @param value node value
         */
        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            if (!getValue().equals(node.getValue())) return false;
            if (getLeftChild() != null ? !getLeftChild().equals(node.getLeftChild()) : node.getLeftChild() != null)
                return false;
            return getRightChild() != null ? getRightChild().equals(node.getRightChild()) : node.getRightChild() == null;
        }

        @Override
        public int hashCode() {
            int result = getValue().hashCode();
            result = 31 * result + (getLeftChild() != null ? getLeftChild().hashCode() : 0);
            result = 31 * result + (getRightChild() != null ? getRightChild().hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }
}
