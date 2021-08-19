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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

            for(T node : graph.getGraph().get(relaxedNodes.poll())) {
                if (!visited.contains(node)) {
                    path.add(node);
                    relaxedNodes.add(node);
                }
            }
        }

        return path;
    }
}
