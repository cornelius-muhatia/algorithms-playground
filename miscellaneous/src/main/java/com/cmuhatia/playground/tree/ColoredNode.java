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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author Cornelius M.
 * @version 1.0.0, 27/12/2021
 */
@Getter
@Setter
@AllArgsConstructor
public class ColoredNode<T extends Comparable<T>> {
    public final static boolean COLOR_BLACK = true;
    public final static boolean COLOR_RED = false;

    T value;

    private ColoredNode<T> leftChild;

    private ColoredNode<T> rightChild;

    boolean color;

    ColoredNode<T> parent;

    public ColoredNode(T value) {
        this.value = value;
        this.color = COLOR_RED;

        this.leftChild = new Nil<>();
        this.rightChild = new Nil<>();
    }

    public void setLeftChild(ColoredNode<T> leftChild) {
        this.leftChild = leftChild;

        if (Objects.nonNull(leftChild)) {
            leftChild.parent = this;
        }
    }

    public void setRightChild(ColoredNode<T> rightChild) {
        this.rightChild = rightChild;

        if (Objects.nonNull(rightChild)) {
            rightChild.parent = this;
        }
    }

    public void setParent(ColoredNode<T> parent) {
        this.parent = parent;

        if (Objects.isNull(parent)) {
            return;
        }

        if (parent.compareTo(this) > 0) {
            parent.setLeftChild(this);
        } else {
            parent.setRightChild(this);
        }
    }

    public boolean isBlack() {
        return this.color == COLOR_BLACK;
    }

    public boolean isRed() {
        return this.color == COLOR_RED;
    }

    public boolean isLeftChild() {
        if (Objects.isNull(parent)) {
            return false;
        }

        return this.equals(parent.getLeftChild());
    }

    public boolean isRightChild() {
        if (Objects.isNull(parent)) {
            return false;
        }

        return this.equals(parent.getRightChild());
    }

    ColoredNode<T> cloneNode() {
        return new ColoredNode<T>(value, leftChild, rightChild, color, parent);
    }

    void paintBlack() {
        this.color = COLOR_BLACK;
    }

    void paintRed() {
        this.color = COLOR_RED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColoredNode<?> node = (ColoredNode<?>) o;

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
        return value + "->" + getColorAsString() + " { leftChild: " + leftChild + ", rightChild: " + rightChild + "}";
    }

    public int compareTo(ColoredNode<T> node) {
        if (Objects.equals(this.value, node.value)) {
            return 0;
        }

        if (Objects.isNull(value)) {
            return -1;
        }

        if (Objects.isNull(node.value)) {
            return 1;
        }

        return this.value.compareTo(node.value);
    }

    private String getColorAsString() {
        return isBlack() ? "BLACK" : "RED";
    }

    public static class Nil<T extends Comparable<T>> extends ColoredNode<T> {

        public Nil(ColoredNode<T> parent) {
            super(null, null, null, ColoredNode.COLOR_BLACK, parent);
        }

        public Nil() {
            super(null, null, null, ColoredNode.COLOR_BLACK, null);
        }
    }
}


