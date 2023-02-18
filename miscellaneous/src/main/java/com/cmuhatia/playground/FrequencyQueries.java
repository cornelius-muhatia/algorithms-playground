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

import java.util.*;

/**
 * Implements solution to <a href="http://hr.gs/3hn7z">Hackerrank's frequency query challenge</a>
 *
 * @author Cornelius M.
 * @version 1.0.0, 15/06/2020
 */
public class FrequencyQueries {

    /**
     * Returns 1 if their is an occurrence any integer with specified frequency
     * @param arr list of integers
     * @param freq frequency
     * @return 1 if has exact occurrence of frequency otherwise 0
     */
    public static int hasOccurrence(PriorityQueue<Integer> arr, int freq){
        int index = 0;
        int count = 1;
        for(Integer e: arr){
//            if(e < arr.peek()){
//                index = 0;
//                while(index < arr.size()){
//                    if()
//                }
//            }
//            for(Integer e2: arr){
//                if(e2.equals(e)){
//                    count++;
//                }
//                if(count > freq){
//                    count = 0;
//                    break;
//                }
//            }
//            if(count == freq){
//                return 1;
//            } else{
//                count = 0;
//            }
        }
        return 0;
    }

    /**
     * For given queries consisting of 2 entries. Given the first entry is:
     * <ul>
     *     <li>1: add second entry to array/data structure</li>
     *     <li>2: delete one occurrence of second entry from the data structure</li>
     *     <li>3: If structure has any integer of exact second entry frequency print 1 else 0</li>
     * </ul>
     * @param queries List of query entries
     * @return new construct list based on the above rules.
     */
    public static List<Integer> freqQuery(List<List<Integer>> queries){
        Map<Integer, Integer> temp = new HashMap<>();
        List<Integer> output = new LinkedList<>();
        queries.forEach(entry -> {
            if (entry.get(0) == 1) {
                try {
                    temp.put(entry.get(1), (temp.get(entry.get(1)) + 1));
                } catch (NullPointerException ex) {
                    temp.put(entry.get(1), 1);
                }
            } else if (entry.get(0) == 2) {
                try {
                    if (Integer.valueOf(1).equals(temp.get(entry.get(1)))) {
                        temp.remove(entry.get(1));
                    } else {
                        temp.put(entry.get(1), temp.get(entry.get(1)) - 1);
                    }
                } catch (NullPointerException ex) {
                    temp.remove(entry.get(1));
                }
            } else {
                if(temp.containsValue(entry.get(1))){
                    output.add(1);
                } else{
                    output.add(0);
                }
            }
        });
        return output;
    }
}
