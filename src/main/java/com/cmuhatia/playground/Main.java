/*
 * Copyright (C) 2020 Cornelius M.
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

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cornelius Muhatia.
 * @version 1.0.0 4/15/20
 */
public class Main {

    public static void main(String[] args) {
        Map<String, Integer> test = new HashMap<>();
        int ii = test.get("test");
        System.out.println("Test is " + ii);
        Boolean passed = true;

        Long[] nthIndex = new Long[]{3L, 6L, 16L, 72L, 99L};
        Long[] nthPrimes = new Long[]{5L, 13L, 53L, 359L, 523L};
        for (int i = 0; i < nthIndex.length; i++) {
            Long prime = findNthPrime(nthPrimes[i]);
            if (Long.compare(prime, nthPrimes[i]) == 0) {
                System.out.println(String.format("Expected %s but got %d", nthPrimes[i], prime));
            }
        }

        if (!passed) {
            System.out.println("Some of the scenarios failed");
        }

    }

    private static Long findNthPrime(Long n) {
        Long nthPrime = null;
        Long i = 1L;
        while (i <= n) {
            if (n % 2 != 0 && n % 3 != 0) {
                i++;
                return i;
            }
        }
        return nthPrime;
    }
}
