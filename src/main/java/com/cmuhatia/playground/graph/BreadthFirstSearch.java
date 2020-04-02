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
     * Traverse the graph using breadth search
     * @param graph {@link Graph}
     * @param root root vertex
     * @param <T> generic reference
     */
    public static <T> void traverseGraph(Graph<T> graph, Graph.Vertex<T> root){
        Set<Graph.Vertex<T>> visited = new LinkedHashSet<>();
        Queue<Graph.Vertex<T>> frontier = new LinkedList<>();
        frontier.add(root);
        while(!frontier.isEmpty()){
            if(!visited.contains(frontier.peek())){
                visited.add(frontier.peek());
                System.out.println(frontier.peek().label);
                if(graph.getGraph().containsKey(frontier.peek())) {
                    frontier.addAll(graph.getGraph().get(frontier.peek()));
                }
            }
            frontier.poll();
        }

    }

    public static void main(String[] args){
        Graph.Vertex<String> uthiru = new Graph.Vertex<>("Uthiru");
        Graph<String> nairobi = generateGraph(true, uthiru);
        System.out.println("Nairobi graph: \n" + nairobi);
        System.out.println("========== Traversing the tree ============");
        traverseGraph(nairobi, uthiru);
    }

    /**
     * Generate a random graph with places names
     *
     * @param isDirected is a directed graph
     * @return {@link Graph}
     */
    public static Graph<String> generateGraph(boolean isDirected, Graph.Vertex<String> uthiru){
        Graph<String> nairobi = new Graph<>(6, isDirected);
        nairobi.addVertex(uthiru);

        Graph.Vertex<String> kawagware = new Graph.Vertex<>("Kawagware");
        nairobi.addEdge(uthiru, kawagware);

        Graph.Vertex<String> kangemi = new Graph.Vertex<>("Kangemi");
        nairobi.addEdge(uthiru, kangemi);

        Graph.Vertex<String> westland = new Graph.Vertex<>("Westland");
        nairobi.addEdge(kangemi, westland);

        nairobi.addEdge(kawagware, kangemi);

        Graph.Vertex<String> yaya = new Graph.Vertex<>("Yaya");
        nairobi.addEdge(kawagware, yaya);

        nairobi.addEdge(yaya, westland);

        Graph.Vertex<String> cbd = new Graph.Vertex<>("CBD");
        nairobi.addEdge(westland, cbd);
        nairobi.addEdge(yaya, cbd);

        return nairobi;

    }
}
