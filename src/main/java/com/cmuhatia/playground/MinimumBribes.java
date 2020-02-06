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

/**
 *
 * @author cornelius
 * @version 1.0.0 Nov 24, 2019
 */
public class MinimumBribes {

    static void minimumBribes(int[] q) {
        int minBribes = 0;
        for (int i = 0; i < q.length; i++) {
            try {
                if (q[i] > q[i + 1]) {
                    int dif = q[i] - q[i + 1];
                    if (dif > 2) {
                        System.out.println("Too Chaotic");
                        return;
                    }
                    minBribes += dif;
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }
        System.out.println(minBribes);
    }

    static void minimumBribes2(int[] q) {
        int minBribes = 0;
        for (int i = 0; i < q.length; i++) {
            int dif = q[i] - i;
            try {
                if (dif > 2 && dif < -2) {
                    System.out.println("Too Chaotic");
                    return;
                } else{
                    minBribes += dif;
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }
        System.out.println(minBribes);
    }

    public static void main(String[] args) {
//         int[] q = {3,1,6,2,4,5};
//         int[] q = {1,2,3,4,5,6,7,8,9};
//         int[] q = {5, 1, 2, 3, 7, 8, 6, 4};
        int[] q = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(q);
    }

}
