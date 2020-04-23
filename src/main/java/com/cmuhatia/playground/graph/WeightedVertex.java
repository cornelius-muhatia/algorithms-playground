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

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * @author Cornelius Muhatia.
 * @version 1.0.0 4/23/20
 */
public class WeightedVertex<T, W extends Number> extends Vertex<T> implements Comparable<WeightedVertex<T, Number> >{

    /**
     * Shortest path traversed from the root node
     */
    private LinkedList<WeightedVertex<T, W>> shortestPath;
    /**
     * Path distance
     */
    private W weight;
    /**
     * Adjacent vertex to current vertex
     */
    private Map<WeightedVertex<T, W>, W> adjacentVertex;

    /**
     * Default constructor
     */
    public WeightedVertex(){

    }

    public WeightedVertex(T label){
        super.setLabel(label);
    }

    public LinkedList<WeightedVertex<T, W>> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<WeightedVertex<T, W>> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public W getWeight() {
        return weight;
    }

    public void setWeight(W weight) {
        this.weight = weight;
    }

    public Map<WeightedVertex<T, W>, W> getAdjacentVertex() {
        return adjacentVertex;
    }

    public void setAdjacentVertex(Map<WeightedVertex<T, W>, W> adjacentVertex) {
        this.adjacentVertex = adjacentVertex;
    }

    @Override
    public int compareTo(WeightedVertex<T, Number>  o) {
        return -1;
//        if(o.getLabel().equals(this.getLabel())){
//            if(Objects.equals(o.getWeight(), getWeight())){
//                return 0;
//            } else {
//                return 1;
//            }
//        } else{
//            return -1;
//        }
    }
}
