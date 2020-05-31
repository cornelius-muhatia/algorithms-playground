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

/**
 * @author Cornelius Muhatia.
 * @version 1.0.0 4/23/20
 */
public class WeightedGraph_<T, W extends Number> {

    /**
     * A list of vertices
     */
    public LinkedList<WeightedVertex<T, W>> vertices;

    /**
     * Default constructor
     */
    public WeightedGraph_(){
        vertices = new LinkedList<>();
    }

    public WeightedGraph_(LinkedList<WeightedVertex<T, W>> vertices){
        this.vertices = vertices;
    }

    public LinkedList<WeightedVertex<T, W>> getVertices() {
        return vertices;
    }

    public void setVertices(LinkedList<WeightedVertex<T, W>> vertices) {
        this.vertices = vertices;
    }
}
