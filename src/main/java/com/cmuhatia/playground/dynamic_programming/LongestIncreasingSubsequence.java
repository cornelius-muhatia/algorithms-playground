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

import java.util.Arrays;

/**
 * Given a string A, find a longest (not necessarily contiguous)
 * subsequence of A that strictly increases (lexicographically)
 *
 * @see <a href="https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/resources/mit6_006s20_lec16/">MIT Algorithms 2020</a>
 *
 * @version 1.0.0, 25/06/2022
 */
public class LongestIncreasingSubsequence {

    public static int of(String str) {
        int[] temp = new int[str.length()];
        Arrays.fill(temp, 1);

        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    temp[i] = Math.max(temp[i], 1 + temp[j]);
                }
            }
        }

        return max(temp);
    }

    private static int max(int[] array) {
        int largestInt = 0;
        for (var val : array) {
            if (val > largestInt) {
                largestInt = val;
            }
        }

        return largestInt;
    }
}
