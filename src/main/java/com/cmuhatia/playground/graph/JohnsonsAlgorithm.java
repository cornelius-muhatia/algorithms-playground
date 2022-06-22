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

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Johnsons Algorithm (Java Implementation)
 * <p>
 * Time complexity: O(V^2 log(V) + VE)
 */
public class JohnsonsAlgorithm {

    /**
     * Todo: preserve original graph's weights
     */
    public static Map<WeightedNode<String>, Map<WeightedNode<String>, Double>> calculateVerticesDistance(
            WeightedGraph<String> graph
    ) {
        Map<WeightedNode<String>, Map<WeightedNode<String>, Double>> vertexShortestPaths = new HashMap<>();

        Map<String, Double> bellmanFordWeights = calculateBellmanFordShortestPath(graph);

        transformNegativeWeights(graph);

        graph.forEach(node -> calculateDijkstraShortestPath(graph, vertexShortestPaths, node));

        restoreOriginalWeights(vertexShortestPaths, bellmanFordWeights);

        return vertexShortestPaths;
    }

    private static void calculateDijkstraShortestPath(
            WeightedGraph<String> graph, Map<WeightedNode<String>,
            Map<WeightedNode<String>, Double>> vertexShortestPaths,
            WeightedNode<String> node
    ) {
        resetGraphWeights(graph);

        DijkstraAlgorithm.calculateShortestPath(node);

        vertexShortestPaths.put(
                node,
                graph
                        .stream()
                        .collect(Collectors.toMap(it -> it, WeightedNode::getWeight))
        );
    }

    /**
     * Calculate original weights: d(u,v) + h(v) - h(u)
     */
    private static void restoreOriginalWeights(
            Map<WeightedNode<String>, Map<WeightedNode<String>, Double>> vertexShortestPaths,
            Map<String, Double> bellmanFordWeights
    ) {
        vertexShortestPaths.forEach((uNode, neighbors) ->
                neighbors
                        .forEach((vNode, neighborWeight) -> {
                            double uWeight = bellmanFordWeights.get(uNode.label);
                            double vWeight = bellmanFordWeights.get(vNode.label);

                            double weight = neighborWeight + vWeight - uWeight;
                            neighbors.replace(vNode, weight);
                        })
        );
    }

    private static void transformNegativeWeights(WeightedGraph<String> graph) {
        graph.forEach(vertex ->
                vertex
                        .getNeighbours()
                        .forEach((neighbor, weight) -> {
                            Double newWeight = weight + vertex.weight - neighbor.weight;
                            vertex.neighbours.replace(neighbor, newWeight);
                        })
        );
    }

    private static Map<String, Double> calculateBellmanFordShortestPath(WeightedGraph<String> graph) {
        WeightedNode<String> baseVertex = new WeightedNode<>("baseVertex");
        graph.forEach(node -> baseVertex.getNeighbours().put(node, 0.0));

        graph.add(baseVertex);

        BellmanFord.calculateShortestPath(graph, baseVertex);

        graph.remove(baseVertex);

        return graph
                .stream()
                .collect(Collectors.toMap(WeightedNode::getLabel, WeightedNode::getWeight));
    }

    private static void resetGraphWeights(WeightedGraph<String> graph) {
        graph.forEach(vertex -> vertex.setWeight(null));
    }
}
