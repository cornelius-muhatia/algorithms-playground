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
package com.cmuhatia.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 *
 * @author cornelius
 * @version 1.0.0 Nov 24, 2019
 */
public class OddOccurrencesInArray {

    public static int solution(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.println("Array " + Arrays.toString(A));
            for (int j = (i + 1); j < A.length; j++) {
                if (A[i] == A[j]) {
                    A = removeTheElement(A, j);
                    break;
                }
            }
            if (A.length > 1) {
                A = removeTheElement(A, i);
                i = -1;
            }
        }
        return A[0];
    }

    public static int[] removeTheElement(int[] arr,
            int index) {
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // return the resultant array 
        return IntStream.range(0, arr.length)
                .filter(i -> i != index)
                .map(i -> arr[i])
                .toArray();
    }

    public static void main(String[] args) {
//        int a[] = {2,2,3};
        int a[] = {9, 3, 9, 3, 9, 7, 9};
        System.out.println("Current solution " + solution(a));
    }

}
