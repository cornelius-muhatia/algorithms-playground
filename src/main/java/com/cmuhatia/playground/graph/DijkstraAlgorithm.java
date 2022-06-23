/*
 * Copyright (C) 2020 Cornelius M.
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
package com.cmuhatia.playground.graph;

import java.util.*;

/**
 * @author Cornelius Muhatia.
 * @version 1.0.0 4/10/20
 */
public class DijkstraAlgorithm {

    /**
     * Calculates weights of Nodes in a graph linked to the root node
     *
     * @param root Start node
     */
    public static <T> void calculateShortestPath(WeightedNode<T> root) {
        Set<WeightedNode<T>> frontier = new HashSet<>();
        frontier.add(root);

        root.setWeight(0.0);

        while (!frontier.isEmpty()) {
            WeightedNode<T> smallNode = getSmallest(frontier);

            frontier.remove(smallNode);

            smallNode.neighbours.forEach((key, val) -> {
                if (key.weight == null) {
                    key.setWeight(smallNode.weight + val);
                    key.setParent(smallNode);

                    frontier.add(key);

                    return;
                }

                if (key.weight > (smallNode.weight + val)) {
                    key.setWeight(smallNode.weight + val);
                    key.setParent(smallNode);
                }
            });
        }
    }

    /**
     * Gets node with smallest weight
     *
     * @param nodes a {@link List} of {@link WeightedNode}
     * @return Smallest node
     */
    public static <T> WeightedNode<T> getSmallest(Collection<WeightedNode<T>> nodes) {
        WeightedNode<T> smallestNode = null;

        for (WeightedNode<T> node : nodes) {
            if (smallestNode == null || smallestNode.weight > node.weight) {
                smallestNode = node;
            }
        }

        return smallestNode;
    }
}
