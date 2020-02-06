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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/**
 *
 * @author cornelius
 * @version 1.0.0 Nov 25, 2019
 */
public class RandomPractice {

    /**
     *
     *
     * @param N input
     * @return smallest number with same digit of N
     */
    public static int smallestInt(int N) {
        if (N < 10) {
            return 0;
        }
        String n = N + "";
        n = n.substring(1).replaceAll("\\d", "0");
        n = "1" + n;
        return Integer.parseInt(n);
    }

    public static int toDecimal(String str) {
        int decimal = 0;
        int base0 = (int) '0';
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if ('1' < ch || ch < '0') {
                return 0;
            }
            decimal = decimal * 2 + ((int) str.charAt(i) - base0);
        }
        return decimal;
    }

    private static boolean charIsNotBinary(char ch) {
        return '1' < ch || ch < '0';
    }

    /**
     *
     * @param S input
     * @return steps taken to reach zero
     * @throws NumberFormatException if number is to big to be parsed to an
     * integer
     */
    public static int evenOdd(String S) {
        int pow = S.length() - 1;
        System.out.println("Double representation " + toDecimal(S));
        try {
            Integer V = Integer.parseInt(S, 2);
            int steps = 0;
            while (V > 0) {
                if (V % 2 > 0) {
                    V = V - 1;
                } else {
                    V = V / 2;
                }
                steps++;
            }
            return steps;
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Sorry number too big for an integer", ex);
        }
    }

    public static byte[] toArray(String value) {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.order(ByteOrder.BIG_ENDIAN);
        for (int i = 0; i < value.length(); i++) {
            buffer.putChar(value.charAt(i));
        }
        buffer.flip();
        return buffer.array();
    }

    /**
     * Assumptions:
     * <ul>
     * <li>Array size is between 0 and 100,000</li>
     * <li>Array elements is between -1,000,000,000 and 1,000,000,000</li>
     * </ul>
     *
     * @param A input
     * @return number of identical pairs in the indices
     */
    public static int identityPair(int[] A) {
        int pairs = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j]) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public static ArrayList<Integer> toList(int[] A) {
        ArrayList<Integer> r = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            r.add(A[i]);
        }
        return r;
    }

    public static void main(String[] args) {
//        System.out.println("Nearest number " + smallestInt(5001));

//        System.out.println("Even odd steps " + evenOdd("011100"));
//          System.out.println("Event odd steps " + evenOdd("00000000000000011000011010100000"));
        System.out.println("Even odd steps " + evenOdd("0011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010011010"));

//        int[] a = {3, 5, 6, 3, 3, 5};
//        System.out.println("Array identity pairs " + identityPair(a));
    }

}
