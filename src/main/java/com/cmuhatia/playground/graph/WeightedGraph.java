/*
 * Copyright 2019 Cornelius M.
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
 * @version 1.0.0, 23/05/2020
 */
public class WeightedGraph<T> extends HashSet<WeightedGraph.Node<T>> {


    public static class Node<T>{
        /**
         * Node label/name
         */
        private T label;
        /**
         * Node weight
         */
        private Double weight;
        /**
         * Neighbour nodes with their weights
         */
        private Map<Node<T>, Double> neighbours = new HashMap<>();
        /**
         * Parent with the shortest path
         */
        private Node<T> parent;

        public Node(T label) {
            this.label = label;
        }

        public T getLabel() {
            return label;
        }

        public void setLabel(T label) {
            this.label = label;
        }

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }

        public Map<Node<T>, Double> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(Map<Node<T>, Double> neighbours) {
            this.neighbours = neighbours;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        /**
         * Returns shortest path in a reversed order starting with the current node
         *
         * @return shortest path nodes
         */
        public LinkedList<Node<T>> getShortestPath(){
            LinkedList<Node<T>> shortestPath = new LinkedList<>();
            shortestPath.add(this);
            Node<T> currentParent = parent;
            while(currentParent != null){
                shortestPath.add(currentParent);
                currentParent = currentParent.getParent();
            }
            return shortestPath;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            return getLabel().equals(node.getLabel());
        }

        @Override
        public int hashCode() {
            return label.hashCode();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name=" + label +
                    ", weight=" + weight +
                    '}';
        }
    }

}

