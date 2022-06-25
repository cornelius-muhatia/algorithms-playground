/*
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
package com.cmuhatia.playground.dynamic_programming;

/**
 * Given two strings A and B, find a longest (not necessarily contiguous) subsequence of A
 * that is also a subsequence of B.
 *
 * Refer to <a href="https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/resources/mit6_006s20_lec16/">MIT Algorithm 2020</a>
 *
 * @version 1.0.0, 24/06/2022
 */
public class LongestCommonSubsequence {

    public static int of(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        int[][] temp = new int[str1Length + 1][str2Length + 1];

        for (int i = str1Length - 1; i >= 0; i--) {
            for (int j = str2Length - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    temp[i][j] = temp[i + 1][j + 1] + 1;

                    continue;
                }

                temp[i][j] = Math.max(temp[i + 1][j], temp[i][j + 1]);
            }
        }

        return temp[0][0];
    }

}
