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
 * It takes n steps to reach at the top of stairs. <br />
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * @see <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/569/">LeetCode</a>
 * @version 1.0.0, 23/07/2022
 */
public class ClimbingStairs {

    public static int getAscendingMethods(int stairsCount) {
        Integer[][] temp = new Integer[2][stairsCount];

        return getAscendingMethods(stairsCount, 0, temp);
    }

    private static int getAscendingMethods(int stairsCount, int count, Integer[][] temp ) {
        if (stairsCount == 0) {
            return ++count;
        }

        if (stairsCount < 0) {
            return count;
        }

        if (temp[0][stairsCount - 1] == null) {
            temp[0][stairsCount - 1] = getAscendingMethods(stairsCount - 1, count, temp);
        }

        if (temp[1][stairsCount - 1] == null) {
            temp[1][stairsCount - 1] = getAscendingMethods(stairsCount - 2, count, temp);
        }

        return temp[0][stairsCount - 1] + temp[1][stairsCount - 1];
    }
}
