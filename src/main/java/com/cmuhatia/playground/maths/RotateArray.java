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
package com.cmuhatia.playground.maths;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author cornelius
 * @version 1.0.0 Nov 24, 2019
 */
import java.io.*;

public class RotateArray {

    public static int[] solution(int[] A, int K) {
        for (int i = 0; i < K; i++) {
            rotate(A);
        }
        return A;
    }

    static void rotate(int A[]) {
        Integer temp = null;

        for (int i = 0; i < A.length; i++) {
            if (temp == null) {
                temp = A[i];
                A[i] = A[A.length - 1];
            } else {
                int temp2 = A[i];
                A[i] = temp;
                temp = temp2;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 9, 7, 6};
        System.out.println("Rotate array is " + Arrays.toString(solution(arr, 4)));
    }
}
