/*
 * Copyright 2020 Cornelius M.
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

/**
 * @author Cornelius M.
 * @version 1.0.0, 17/08/2020
 */
public class AStarAlgorithm {

    public static LinkedList<Object> reconstructPath(Map<Object, Object> cameFrom, Object current){
        LinkedList<Object> totalPath = new LinkedList<>();
        totalPath.add(current);
        while(cameFrom.containsKey(current)){
            current = cameFrom.get(current);
            totalPath.add(current);
        }
        return totalPath;
    }

    public static LinkedList<Object> getShortestPath(){
        return null;
    }
}
