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
package com.cmuhatia.playground.graph;

import java.util.LinkedHashSet;

/**
 * @version 1.0.0, 28/05/2022
 */
public class DepthFirstSearch {

    /**
     * @return traversed path
     */
    public static <T> LinkedHashSet<Vertex<T>> traverseGraph(Graph<T> graph, Vertex<T> root){
        LinkedHashSet<Vertex<T>> visitedVertices = new LinkedHashSet<>();

        preOrderTraversal(graph, visitedVertices, root);

        return visitedVertices;
    }

    private static <T> void preOrderTraversal(Graph<T> graph, LinkedHashSet<Vertex<T>> visited, Vertex<T> currentVertex) {
        if (currentVertex != null && !visited.contains(currentVertex)) {
            visited.add(currentVertex);
            graph.getAdjacentVertices(currentVertex).forEach(vertex -> preOrderTraversal(graph, visited, vertex));
        }
    }
}
