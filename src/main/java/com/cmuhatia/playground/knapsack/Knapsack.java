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
package com.cmuhatia.playground.knapsack;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author Cornelius M.
 * @version 1.0.0, 21/06/2020
 */
public class Knapsack {

    /**
     * Gets the maximum profit for 0/1 Knapsack
     *
     * @param items items with weight as the key and profit as the value
     * @param capacity capacity of the knapsack
     * @return maximum profit the knapsack can hold
     */
    public static int getMaxWeight01(List<Map.Entry<Integer, Integer>> items, int capacity){
        int[][] table = new int[items.size()][capacity + 1];
        for(int k = 1; k <= capacity; k++){
            for(int i = 0; i < items.size(); i++){
                if (i == 0){
                    table[i][k] = items.get(i).getKey() > k ? 0 : items.get(i).getValue();
                }
                else{
                    int prevJ = k - items.get(i).getKey();
                    if(prevJ >= 0) {
                        int currentWeight = table[i - 1][prevJ] + items.get(i).getValue();
                        table[i][k] = Math.max(table[i - 1][k], currentWeight);
                    } else {
                        table[i][k] = table[i-1][k];
                    }
                }
            }
        }
        return table[items.size() - 1][capacity];
    }

    /**
     * Gets maximum profit for factional Knapsack problem
     *
     * @param items  items with weight as the key and profit as the value
     * @param capacity capacity of the knapsack
     * @return maximum profit the knapsack can hold
     */
    public static double getMaxWeightFractional(List<Map.Entry<Integer, Integer>> items, int capacity){
        items.sort((o1, o2) -> {
            int item1Ratio = o1.getValue() / o1.getKey();
            int item2Ratio = o2.getValue() / o2.getKey();
            return (Integer.compare(item1Ratio, item2Ratio));
        });
        double filled = 0;
        double maxWeight = 0.0;
        for(int i = items.size() - 1; i > -1; i--){
            if((filled + items.get(i).getKey()) <= capacity){
                maxWeight += items.get(i).getValue();
                filled += items.get(i).getKey();
            } else if((capacity - filled) > 0){
                double rem = capacity - filled;
                maxWeight += (Double.valueOf(items.get(i).getValue()) / Double.valueOf(items.get(i).getKey())) * rem;
            } else{
                break;
            }
        }
       return maxWeight;
    }
}
