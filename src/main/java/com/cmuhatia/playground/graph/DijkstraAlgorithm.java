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
public class DijkstraAlgorithm{

    /**
     * Calculates weights of Nodes in a graph linked to the root node
     *
     * @param root Start node
     */
    public static <T> void calculateShortestPath(WeightedGraph.Node<T> root){
        List<WeightedGraph.Node<T>> frontier = new LinkedList<>();
        root.setWeight(0.0);
        frontier.add(root);
        while(!frontier.isEmpty()){
            WeightedGraph.Node<T> smallNode = getSmallest(frontier);
            frontier.remove(smallNode);
            smallNode.getNeighbours().forEach((key, val) -> {
                if(key.getWeight() == null){
                    key.setWeight(smallNode.getWeight() + val);
                    frontier.add(key);
                    key.setParent(smallNode);
                } else if(key.getWeight() > (smallNode.getWeight() + val)){
                    key.setWeight(smallNode.getWeight() + val);
                    key.setParent(smallNode);
                }
            });
        }
    }

    /**
     * Gets node with smallest weight
     *
     * @param nodes a {@link List} of {@link com.cmuhatia.playground.graph.WeightedGraph.Node}
     * @return Smallest node
     */
    public static <T>  WeightedGraph.Node<T> getSmallest(List<WeightedGraph.Node<T>> nodes){
        WeightedGraph.Node<T> smallestNode = null;
        for(WeightedGraph.Node<T> node: nodes){
            if(smallestNode == null || smallestNode.getWeight() > node.getWeight()){
                smallestNode = node;
            }
        }
        return smallestNode;
    }
}
