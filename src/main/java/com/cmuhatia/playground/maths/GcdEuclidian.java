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
 * Examples related to greatest common divisor using Eclidian algorithm
 *
 * @author Cornelius M.
 * @version 1.0.0, 06/05/2020
 */
public class GcdEuclidian {

    /**
     * Get greatest common divisor of 2 integers. For example the gcd of 77 and 22 is 11
     *
     * @param large largest integer
     * @param small smallest integer
     * @return greatest common divisor
     */
    public static int getGcd(int large, int small){
        int remainder;
        while(true){
            remainder = large % small;
            if(remainder == 0){
                return small;
            } else{
                large = small;
                small = remainder;
            }
        }
    }

    /**
     * Simplify fraction. For example given 8/24 will result to 1/3
     *
     * @param numerator numerator of the fraction for example 8 from the example
     * @param denominator denominator of the fraction; 24 from the example
     * @param result simplified fraction the first index being the numerator and the second
     *               index denominator. Expects an array of atleast size 2 to be initialized
     */
    static void simplifyFraction(int numerator, int denominator, int [] result){
        int gcd = numerator > denominator ? getGcd(numerator, denominator) : getGcd(denominator, numerator);
        result[0] = numerator / gcd;
        result[1] = denominator / gcd;
    }

    /**
     * Get gcd of more than 2 numbers
     *
     * @param firstNumber first number
     * @param others other numbers
     * @return gcd of all the numbers
     */
    public static int getGcd(int firstNumber, int... others){
        int gcd = firstNumber;
        for(int next: others){
            gcd = getGcd(gcd, next);
        }
        return gcd;
    }
}
