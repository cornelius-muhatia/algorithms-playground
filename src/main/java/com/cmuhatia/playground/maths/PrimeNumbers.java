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

/**
 * @author Cornelius M.
 * @version 1.0.0, 15/05/2020
 */
public class PrimeNumbers {

    /**
     * Count prime numbers from 1 to the specified number
     *
     * @param n number
     * @return number of prime numbers
     */
    public static int countPrimeNumbers(int n){
        int count = 0;

        while(n > 1){
            boolean isPrime = true;

            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    isPrime = false;

                    break;
                }
            }

            if(isPrime){
                count++;
            }

            n--;
        }

        return count;
    }
}
