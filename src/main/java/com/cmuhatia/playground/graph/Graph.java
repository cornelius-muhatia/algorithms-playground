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

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Cornelius Muhatia.
 * @version 1.0.0 3/29/20
 */
public class Graph<T> {
    /**
     * Number of vertices/nodes
     */
    public int size = 0;
    /**
     * Adjacency matrix representation
     */
    private final HashMap<Vertex<T>, LinkedList<Vertex<T>>> graph;

    private final boolean isDirected;

    public Graph(boolean isDirected) {
        this(19, isDirected);
    }

    public Graph(int initialCapacity, boolean isDirected){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("Number of vertices should be greater than 0");
        }

        this.graph = new HashMap<>(initialCapacity);
        this.isDirected = isDirected;
    }

    /**
     *
     * @param vertex {@link Vertex}
     * @param edges edges pointing to the vertex
     */
    public void addEdge(Vertex<T> vertex, LinkedList<Vertex<T>> edges){
        graph.put(vertex, edges);

        if(!isDirected){
            edges.forEach(edge -> this._addVertex(edge, vertex));
        }

        this.size++;
    }

    /**
     * Adds an edge to a vertex
     *
     * @param vertex {@link Vertex}
     * @param edge {@link Vertex}
     */
    private void _addVertex(Vertex<T> vertex, Vertex<T> edge){
        if(graph.containsKey(vertex)){
            graph.get(vertex).add(edge);
        } else{
            LinkedList<Vertex<T>> _edges = new LinkedList<>();
            _edges.addFirst(edge);
            graph.put(vertex, new LinkedList<>(_edges));
        }
        this.size++;
    }

    /**
     * Adds an edge to the specified vertex. If vertex exists the edge is appended to existing edges.
     * For undirected graph the vertex is also added to the edge
     *
     * @param vertex {@link Vertex}
     * @param edge {@link Vertex} new edge should not be null
     */
    public void addEdge(Vertex<T> vertex, Vertex<T> edge){
        this._addVertex(vertex, edge);
        if(!isDirected){
            this._addVertex(edge, vertex);
        }
    }

    /**
     * Get the entire graph
     *
     * @return graph
     */
    public HashMap<Vertex<T>, LinkedList<Vertex<T>>> getGraph() {
        return graph;
    }
}
