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

import com.cmuhatia.playground.search.Node;

import java.util.*;

/**
 * @author Cornelius Muhatia.
 * @version 1.0.0 4/10/20
 */
public class DijkstraAlgorithm<T>{

    private final WeightedGraph_<T, Double> graph;

    /**
     * Default constructor
     *
     * @param graph weighted graph
     */
    public DijkstraAlgorithm(WeightedGraph_<T, Double> graph){
        this.graph = graph;
    }

    public static void calculateShortestPath(WeightedGraph<String> graph, WeightedGraph.Node<String> root){
        List<WeightedGraph.Node<String>> visited = new LinkedList<>();
        Queue<WeightedGraph.Node<String>> frontier = new LinkedList<>();
        frontier.add(root);
        while(!frontier.isEmpty()){
            if(!frontier.peek().getNeighbours().isEmpty()) {
                WeightedGraph.Node<String> lowestNode = frontier.peek().getNeighbours().firstKey();
                if (Objects.isNull(lowestNode.getWeight())) {
                    lowestNode.setWeight(frontier.peek().getNeighbours().get(lowestNode));
                } else if (lowestNode.getWeight().compareTo(
                        frontier.peek().getNeighbours().get(lowestNode) + frontier.peek().getWeight()) > 0) {
                    lowestNode.setWeight(frontier.peek().getNeighbours().get(lowestNode) + frontier.peek().getWeight());
                }
                for (Map.Entry<WeightedGraph.Node<String>, Double> entry : frontier.peek().getNeighbours().entrySet()) {
                    if (!entry.equals(lowestNode)) {
                        frontier.add(entry.getKey());
                    }
                }
            }
            frontier.poll();
        }
    }

//    private WeightedGraph.Node<String> getSmallest(Map<WeightedGraph.Node<String>, Double> nodes){
//        WeightedGraph.Node<String> lowestNode = null;
//        for(Map.Entry<WeightedGraph.Node<String>, Double> entry: nodes.entrySet()){
//            if(lowestNode == null){
//                lowestNode = entry.getKey();
//            } else if(lowestNode.getWeight().compareTo(entry.getKey().getWeight()) > 0){
//                lowestNode = entry.getKey();
//            }
//        }
//        return lowestNode;
//    }

    /**
     * Determines shortest path for each node from root
     *
     * @param root start node
     */
    public void calculateShortestPath(WeightedVertex<T, Double> root){
        Queue<WeightedVertex<T, Double>> unsettledNodes = new LinkedList<>();
        unsettledNodes.add(root);
        while(!unsettledNodes.isEmpty()){
            WeightedVertex<T, Double>  frontier = unsettledNodes.poll();
            frontier.getAdjacentVertex().forEach((vertex, value) -> {
                if(Objects.isNull(vertex.getWeight())){
                    if(Objects.isNull(frontier.getWeight())){
                        vertex.setWeight(value);
                    } else {
                        vertex.setWeight(value + frontier.getWeight());
                    }
                    if(Objects.isNull(vertex.getShortestPath())){
                        vertex.setShortestPath(new LinkedList<>());
                    }
                    if(frontier.equals(root)) {
                        vertex.setShortestPath(new LinkedList<>(List.of(frontier)));
                    } else{
                        vertex.setShortestPath(frontier.getShortestPath());
                    }
                    unsettledNodes.add(vertex);
                } else {
                    Double totalWeight = vertex.getWeight() + value;
                    if (totalWeight < vertex.getWeight()) {
                        vertex.setWeight(totalWeight);
                        //Weight changed loosen vertex for updating neighbouring nodes
                        unsettledNodes.add(vertex);
                        vertex.setShortestPath(frontier.getShortestPath());
                        vertex.getShortestPath().add(frontier);
                    }
                }
                System.out.println("Explored vertex " + vertex.getLabel() + " assigned weight " + vertex.getWeight());
            });
        }
    }

    public static void main(String[] args){
        WeightedGraph_<String, Double> graph = new WeightedGraph_<>();

        WeightedVertex<String, Double> a = new WeightedVertex<>("A");
        WeightedVertex<String, Double> b = new WeightedVertex<>("B");
        WeightedVertex<String, Double> c = new WeightedVertex<>("C");
        a.setAdjacentVertex(Map.of(b, 1.0, c, 3.0));

        WeightedVertex<String, Double> d = new WeightedVertex<>("D");
        b.setAdjacentVertex(Map.of(d, 4.0));
        c.setAdjacentVertex(Map.of(d, 7.0, b, 6.0));

        graph.vertices.addAll(List.of(a, b, c, d));

        DijkstraAlgorithm<String> dijkstra = new DijkstraAlgorithm<>(graph);
        dijkstra.calculateShortestPath(a);

        LinkedList<WeightedVertex<String, Double>> shortestPath = new LinkedList<>();
        shortestPath.add(a);
        shortestPath.add(b);
        shortestPath.add(d);
        System.out.println("Total weight of d " + d.getWeight());
    }
}
