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
 * <ul>
 *     <li>Given n pins labeled 0,1,...,n−1</li>
 *     <li>Pin i has value vi</li>
 *     <li>Ball of size similar to pin can hit either –1 pin i, in which case we get vi points –2 adjacent pins i and i+ 1, in which case we get vi·vi+1points</li>
 *     <li>Once a pin is hit, it can’t be hit again (removed)</li>
 *     <li>Problem: Throw zero or more balls to maximize total points </li>
 * </ul>
 * <p>
 * Refer to <a href="https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/resources/mit6_006s20_lec15/">MIT Algorithms 2020</a>
 *
 * @version 1.0.0, 24/06/2022
 */
public class Bowling {

    /**
     * Top down recursion solution
     */
    public static int recursively(int[] values) {
        Integer[] memo = new Integer[values.length];

        return recursively(0, values, memo);
    }

    private static int recursively(int i, int[] values, Integer[] memo) {
        if (i >= values.length) {
            return 0;
        }

        if (memo[i] == null) {
            memo[i] = ((i + 2) >= values.length)
                    ? Math.max(recursively(i + 1, values, memo), values[i] + recursively(i + 1, values, memo))
                    : max(
                    recursively(i + 1, values, memo),
                    values[i] + recursively(i + 1, values, memo),
                    values[i] * values[i + 1] + recursively(i + 2, values, memo)
            );
        }

        return memo[i];
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static int iteratively(int[] values) {
        int[] memo = new int[values.length + 1];

        for (int i = values.length - 1; i >= 0; i--) {   // topological order
            memo[i] = ((i + 2) >= values.length)
                    ? Math.max(memo[i + 1], values[i] + memo[i + 1])
                    : max(
                    memo[i + 1],    // relation: skip pin i
                    values[i] + memo[i + 1],    // OR bowl pin i separately
                    values[i] * values[i + 1] + memo[i + 2]     // OR bowl pins i and i+1 together
            );
        }

        return memo[0];
    }
}
