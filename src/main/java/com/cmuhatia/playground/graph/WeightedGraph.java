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

import com.cmuhatia.playground.search.Node;
import com.cmuhatia.playground.search.Tree;

import java.util.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 23/05/2020
 */
public class WeightedGraph<T> extends HashSet<Node<T>> {


    public static class Node<T> implements Comparable<Node<T>>{
        private T name;
        private Double weight = null;
        private SortedMap<Node<T>, Double> neighbours = new TreeMap<>();

        public Node(T name) {
            this.name = name;
        }

        public T getName() {
            return name;
        }

        public void setName(T name) {
            this.name = name;
        }

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }

        public SortedMap<Node<T>, Double> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(SortedMap<Node<T>, Double> neighbours) {
            this.neighbours = neighbours;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            return getName().equals(node.getName());
        }

        @Override
        public int hashCode() {
            return getName().hashCode();
        }

        @Override
        public int compareTo(Node<T> o) {
            if(Objects.isNull(o.getWeight()) && Objects.isNull(this.getWeight())){
                return 0;
            } else if(Objects.isNull(this.getWeight())){
                return -1;
            } else if(Objects.isNull(o.getWeight())){
                return 1;
            } else {
                return Double.compare(this.weight, o.getWeight());
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name=" + name +
                    ", weight=" + weight +
                    '}';
        }
    }

}

