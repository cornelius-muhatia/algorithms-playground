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
package com.cmuhatia.playground.search;

import java.util.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 02/08/2020
 */
public class StringsPractice {

    /**
     * A string is said to be a special string if either of two conditions is met:
     * <ul>
     *     <li>All of the characters are the same, e.g. aaa.</li>
     *     <li>All characters except the middle one are the same, e.g. aadaa.</li>
     * </ul>
     * Full problem statement can be found at <a href="http://hr.gs/3c9b9">Hackerrank</a>
     *
     * @param str string
     * @return special character counts
     */
    public static int countSpecialStrings(String str) {
        int n = str.length();
        int subLength = 0;
        int count = 0;
        for (int j = 1; j < n; j++) {
            if (str.charAt(j - 1) == str.charAt(j)) {
                subLength++;
            } else if (subLength > 0) {

            }
        }
        return count;
    }

    /**
     * Validates if an array of strings has a valid braces order. For example [{()}]
     *
     * @param values Strings array
     * @return String array containing values YES if braces are ordered otherwise false.
     */
    public static String[] braces(String[] values) {
        String[] results = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            try {
                Stack<Character> braces = new Stack<>();
                for (Character c : value.toCharArray()) {
                    if (c.equals('{') || c.equals('[') || c.equals('(')) {
                        braces.push(c);
                    } else if (c.equals('}') && braces.peek().equals('{')) {
                        braces.pop();
                    } else if (c.equals(']') && braces.peek().equals('[')) {
                        braces.pop();
                    } else if (c.equals(')') && braces.peek().equals('(')) {
                        braces.pop();
                    }
                }
                results[i] = braces.isEmpty() ? "YES" : "NO";
            } catch (EmptyStackException ex) {
                results[i] = "NO";
            }
        }
        return results;
    }

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. STRING_ARRAY s
     */

    public static String solve(int m, List<String> s) {
        // fill this function
        long sum = 0;
        for(String value: s){
            long total = 1;
            for(Character c: value.toCharArray()){
                total *= Math.pow(((int)c), m);
            }
            sum += total;
        }
        return sum % 2 == 0 ? "EVEN" : "ODD";
    }

    /*
     * Complete the 'closestStraightCity' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY c
     *  2. INTEGER_ARRAY x
     *  3. INTEGER_ARRAY y
     *  4. STRING_ARRAY q
     */

    public static List<String> closestStraightCity(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
        // Write your code here
        List<String> nearest = new ArrayList<>(c.size());
        for(int i = 0; i < q.size(); i++){
            int[] coords = getCoord(c, x, y, q.get(i));
            int nearestIdx = -1;
            for (int j = 0; j < c.size(); j++) {
                if(!q.get(i).equals(c.get(j))){
                    if(x.get(j).equals(coords[0])){
                        if(nearestIdx == -1){
                            nearestIdx = j;
                        }
                        else if(Math.abs((coords[1] - y.get(nearestIdx))) > Math.abs((coords[1] - y.get(j)))){
                            nearestIdx = j;
                        }
                    } else if(y.get(j).equals(coords[1])){
                        if(nearestIdx == -1){
                            nearestIdx = j;
                        }
                        else if(Math.abs((coords[0] - x.get(nearestIdx))) > Math.abs((coords[0] - x.get(j)))){
                            nearestIdx = j;
                        }
                    }
                }
            }
            if(nearestIdx == -1){
                nearest.add("NONE");
            } else{
                nearest.add(c.get(nearestIdx));
            }
        }
        return nearest;
    }

    /**
     * Get coordinates of city q.
     * @param c list of cities
     * @param x list of x coordinates
     * @param y list of y coordinates
     * @param q city name
     * @return integer array containing x coordinate at index 0 and y coordinates at index 1
     */
    private static int[] getCoord(List<String> c, List<Integer> x, List<Integer> y, String q){
        for(int i = 0; i < c.size(); i++){
            if(c.get(i).equals(q)){
                return new int[]{x.get(i), y.get(i)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        String[] braces = {"[{}]", "[{]}", "{}[]()"};
//        System.out.println("Answer: " + Arrays.toString(braces(braces)));
//        String[] braces2 = {"{}", "[]", "()"};
//        System.out.println("Answer: " + Arrays.toString(braces(braces2)));

//        System.out.println("Solve: " + solve(2, List.of("abc", "abcd")));
//        System.out.println("Solve: " + solve(50, List.of("aceace", "ceceaa", "abdbdbdbakjkljhkjh")));
//        System.out.println("Power: " + Math.pow(8, 2));

        List<String> close = closestStraightCity(List.of("fastcity", "bigbanana", "xyz"),
                List.of(23, 23, 23), List.of(1, 10, 20), List.of("fastcity", "bigbanana", "xyz"));
        System.out.println("Nearest cities: " + Arrays.toString(close.toArray()));
    }
}
