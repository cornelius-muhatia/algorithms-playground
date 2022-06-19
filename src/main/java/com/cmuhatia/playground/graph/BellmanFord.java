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
package com.cmuhatia.playground.graph;

import java.util.Map;

/**
 * Bellman Ford Algorithm (Java Implementation)
 * Time Complexity: O(|V||E|)
 *
 * @author Cornelius M.
 * @version 1.0.0, 09/06/2020
 */
public class BellmanFord {

    /**
     * Relaxes nodes of a graph
     *
     * @param graph {@link WeightedGraph}
     * @param <T>   Node generic reference
     * @return true if one or more nodes were relaxed and false otherwise
     */
    private static <T> boolean relaxGraph(WeightedGraph<T> graph) {
        boolean relaxed = false;

        for (WeightedGraph.Node<T> node : graph) {

            if (node.weight != null) {

                for (Map.Entry<WeightedGraph.Node<T>, Double> entry : node.neighbours.entrySet()) {
                    WeightedGraph.Node<T> key = entry.getKey();
                    Double value = entry.getValue();

                    if (key.weight == null) {
                        key.setWeight(node.weight + value);
                        key.setParent(node);

                        relaxed = true;

                        continue;
                    }

                    if (key.weight > (node.weight + value)) {
                        key.setWeight(node.weight + value);
                        key.setParent(node);

                        relaxed = true;
                    }
                }

            }
        }

        return relaxed;
    }

    /**
     * Calculates shortest path of a graph from the root node.
     * For optimal results add the root as the first entry in the graph
     *
     * @param graph {@link WeightedGraph}
     * @param root  root node
     * @param <T>   Node label generic reference
     * @throws StackOverflowError if the graph has a negative circular nodes meaning it can't be solved
     */
    public static <T> void calculateShortestPath(
            WeightedGraph<T> graph,
            WeightedGraph.Node<T> root
    ) throws StackOverflowError {

        if (root.weight == null) {
            root.setWeight(0.0);
        }

        for (int i = 1; i < graph.size(); i++) {
            if (!relaxGraph(graph)) { // break early if the graph can no longer be relaxed
                return;
            }
        }

        if (relaxGraph(graph)) {
            throw new StackOverflowError("Graph has a negative circular nodes");
        }
    }


}
