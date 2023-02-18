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
package com.cmuhatia.playground.maths;

/**
 * @author Cornelius M.
 * @version 1.0.0, 21/10/2020
 */
public class PermutationCombination {

    /**
     * Calculates permutation of sample from given number of objects
     * @param n number of objects
     * @param r sample
     * @return total permutations
     */
    public static long getPermutation(long n, long r){
        long perm = 1;
        for (long i = n; i > (n-r); i--){
            perm *= i;
        }
        return perm;
    }

    /**
     * Calculate combination of sample from a given number of objects
     * @param n number of objects
     * @param r sample
     * @return total combination
     */
    public static long getCombination(long n, long r){
        long combination = getPermutation(n, r);
        long k = 1;
        for(long i=1; i <= r; i++){
            k *= i;
        }
        return combination/k;
    }
}
