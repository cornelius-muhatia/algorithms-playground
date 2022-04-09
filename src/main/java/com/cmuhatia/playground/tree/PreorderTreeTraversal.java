/*
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

import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @version 1.0.0, 27/02/2022
 */
@RequiredArgsConstructor
public class PreorderTreeTraversal<T extends Comparable<T>> {

    private final BinarySearchTree<T> tree;

    public LinkedList<T> traverse() {
        LinkedList<T> values = new LinkedList<>();

        traverse(values, tree.getRootNode());

        return values;
    }

    private void traverse(LinkedList<T> list, BinarySearchTree.Node<T> currentNode) {
        if (Objects.isNull(currentNode)) {
            return;
        }

        list.add(currentNode.getValue());

        traverse(list, currentNode.getLeftChild());

        traverse(list, currentNode.getRightChild());
    }
}
