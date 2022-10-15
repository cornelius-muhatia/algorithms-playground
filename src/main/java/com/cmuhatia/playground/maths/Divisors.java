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

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Cornelius M.
 * @version 1.0.0, 09/05/2020
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Divisors {

    /**
     * Sums all divisors of a number. For example given 8; the sum of all divisors is 15 (1, 2, 4, 8)
     *
     * @param number Number
     * @return total divisors
     */
    public static long sumDivisors(int number) {
        if (number == 1) {
            return 1;
        }

        long sum = 1L + number;

        int limit = (int) Math.sqrt(number);
        for (int i = 2; i <= limit; i++) {
            if ((number % i) == 0) {
                if (i * i == number) {
                    sum += i;
                } else {
                    sum += i + (number / i);
                }
            }
        }

        return sum;
    }

    /**
     * Brute force version of {@link Divisors#sumDivisors(int)}
     *
     * @param number Number
     * @return total divisors
     */
    public static long sumDivisors2(int number) {
        if (number == 1) {
            return 1;
        }

        int sum = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
