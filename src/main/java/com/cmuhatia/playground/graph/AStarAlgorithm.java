///*
// * Copyright 2020 Cornelius M.
// * <p>
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// * <p>
// * http://www.apache.org/licenses/LICENSE-2.0
// * <p>
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package com.cmuhatia.playground.graph;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.PriorityQueue;
//
///**
// * @author Cornelius M.
// * @version 1.0.0, 17/08/2020
// */
//public class AStarAlgorithm {
//
//    public static LinkedList<Object> reconstructPath(Map<Object, Object> cameFrom, Object current){
//        LinkedList<Object> totalPath = new LinkedList<>();
//        totalPath.add(current);
//        while(cameFrom.containsKey(current)){
//            current = cameFrom.get(current);
//            totalPath.add(current);
//        }
//        return totalPath;
//    }
//
//    public static Double heuristics(Object  node){
//        return 0.0;
//    }
//
//    public static LinkedList<Object> getShortestPath(Object start, Object goal){
//        PriorityQueue<Object> openSet = new PriorityQueue<>();
//        openSet.add(start);
//        Map<Object, Object> cameFrom = new HashMap<>();
//        Map<Object, Double> gScore = new HashMap<>();
//        gScore.put(start, 0.0);
//
//        Map<Object, Object> fScore = new HashMap<>();
//        fScore.put(start, heuristics(start));
//
//        while(!openSet.isEmpty()){
//            Object currentNode = getLowestNode(fScore);
//            if(currentNode == goal){
//                return reconstructPath(cameFrom, currentNode);
//            }
//            openSet.remove(currentNode);
//            Map<Object, Double> neighbours = currentNode.getNeighbours(); // current.getNeighbours()
//            neighbours.forEach((neighbour, value) -> {
//                Double tentativeScore = gScore.get(currentNode) + (currentNode.weight + neighbour.weight);
//                if(tentativeScore < gScore.get(neighbour)){
//                    cameFrom.put(neighbour, currentNode);
//                    gScore.put(neighbour, tentativeScore);
//                    fScore.put(neighbour, gScore.get(neighbour) + heuristics(neighbour));
//                    if(!openSet.contains(neighbour)){
//                        openSet.add(neighbour);
//                    }
//                }
//            });
//        }
//
//        return null;
//    }
//
//    public static Object getLowestNode(Map<Object, Object> fScore){
//        return null;
//    }
//
//}
