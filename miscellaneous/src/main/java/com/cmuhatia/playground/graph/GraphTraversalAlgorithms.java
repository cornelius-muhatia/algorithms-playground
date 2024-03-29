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
package com.cmuhatia.playground.graph;

import java.util.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 10/08/2021
 */
public class GraphTraversalAlgorithms {

    public static <T> List<T> breadthFirstSearch(DirectedGraph<T> graph, T rootNode) {
        LinkedList<T> path = new LinkedList<>();
        path.add(rootNode);

        Queue<T> relaxedNodes = new LinkedList<>();
        relaxedNodes.add(rootNode);

        HashSet<T> visited = new HashSet<>();
        visited.add(rootNode);

        while (!relaxedNodes.isEmpty()) {
            visited.add(relaxedNodes.peek());

            for (T node : graph.getGraph().get(relaxedNodes.poll())) {
                if (!visited.contains(node)) {
                    path.add(node);
                    relaxedNodes.add(node);
                }
            }
        }

        return path;
    }

    public static <T> List<T> depthFirstSearch(DirectedGraph<T> graph, T rootNode) {
        LinkedList<T> path = new LinkedList<>();
        path.add(rootNode);

        HashSet<T> visited = new HashSet<>();
        visited.add(rootNode);

        for (T branchNode : graph.getGraph().get(rootNode)) {
            if (!visited.contains(branchNode)) {
                depthFirstSearch(graph, path, visited, branchNode);
            }
        }

        return path;
    }

    private static <T> void depthFirstSearch(DirectedGraph<T> graph, LinkedList<T> path, HashSet<T> visited, T rootNode) {
        path.add(rootNode);
        visited.add(rootNode);

        if (Objects.nonNull(graph.getGraph().get(rootNode))) {
            for (T branchNode : graph.getGraph().get(rootNode)) {
                if (!visited.contains(branchNode)) {
                    depthFirstSearch(graph, path, visited, branchNode);
                }
            }
        }
    }

    public static <T> boolean hasCycle(DirectedGraph<T> graph) {
        HashSet<T> relaxedNodes = new HashSet<>();
        HashSet<T> visitedNodes = new HashSet<>();

        return graph
                .getGraph()
                .keySet()
                .stream()
                .anyMatch(node -> hasCycle(node, graph, visitedNodes, relaxedNodes));
    }

    private static <T> boolean hasCycle(T rootNode, DirectedGraph<T> graph, HashSet<T> visitedNodes, HashSet<T> relaxedNodes) {
        relaxedNodes.add(rootNode);

        if (Objects.nonNull(graph.getGraph().get(rootNode))) {
            for (T currentNode : graph.getGraph().get(rootNode)) {
                if (visitedNodes.contains(currentNode)) {
                    continue;
                }

                if (relaxedNodes.contains(currentNode)) {
                    return true;
                }

                if (hasCycle(currentNode, graph, visitedNodes, relaxedNodes)) {
                    return true;
                }
            }
        }

        visitedNodes.add(rootNode);
        relaxedNodes.remove(rootNode);

        return false;
    }
}
