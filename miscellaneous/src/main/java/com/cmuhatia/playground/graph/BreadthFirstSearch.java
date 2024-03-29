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
 * @version 1.0.0 3/29/20
 */
public class BreadthFirstSearch {
    /**
     * @return traversal path
     */
    public static <T> LinkedHashSet<Vertex<T>> traverseGraph(Graph<T> graph, Vertex<T> root){
        LinkedHashSet<Vertex<T>> visited = new LinkedHashSet<>();

        Queue<Vertex<T>> frontier = new LinkedList<>();
        frontier.add(root);

        while(!frontier.isEmpty()){
            if(!visited.contains(frontier.peek())){
                visited.add(frontier.peek());

                if(frontier.peek() != null) {
                    frontier.addAll(graph.getAdjacentVertices(frontier.peek()));
                }
            }

            frontier.poll();
        }

        return visited;
    }
}
