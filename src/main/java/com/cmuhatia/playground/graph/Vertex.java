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


/**
 * A class used to represent a vertex. Fields include:
 * <ul>
 *     <li>label</li>
 * </ul>
 * Remember to override equals and hashcode of your generic classes they are used as default
 *
 * @param <T> vertex type string or object
 */
public class Vertex<T> {
    /**
     * Vertex label
     */
    private T label;

    /**
     * Default constructor
     */
    public Vertex() {
    }

    /**
     *
     * @param label vertex label
     */
    public Vertex(T label){
        this.label = label;
    }

    public T getLabel() {
        return label;
    }

    public void setLabel(T label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex<?> vertex = (Vertex<?>) o;

        return label.equals(vertex.label);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                '}';
    }
}
