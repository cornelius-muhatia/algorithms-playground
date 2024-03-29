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


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * A class used to represent a vertex. Fields include:
 * <ul>
 *     <li>label</li>
 * </ul>
 * Remember to override equals and hashcode of your generic classes they are used as default
 *
 * @param <T> vertex type string or object
 */
@Data
@AllArgsConstructor
public class Vertex<T> {

    private T label;
}
