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
package com.cmuhatia.playground.dynamic_programming.knapsack;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Cornelius M.
 * @version 1.0.0, 21/06/2020
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Knapsack {

    /**
     * Gets the maximum profit for 0/1 Knapsack
     *
     * @param items    items with weight as the key and profit as the value
     * @param capacity capacity of the knapsack
     * @return maximum profit the knapsack can hold
     */
    public static int getMaxWeight01(List<Item> items, int capacity) {
        int[][] table = computeSubProblemsWeights(items, capacity);

        return table[items.size()][capacity];
    }

    private static int[][] computeSubProblemsWeights(List<Item> items, int capacity) {
        int[][] table = new int[items.size() + 1][capacity + 1];

        for (int row = 1; row <= items.size(); row++) {
            int itemIdx = row - 1;
            int itemWeight = items.get(itemIdx).getWeight();
            int itemValue = items.get(itemIdx).getValue();

            for (int col = 0; col <= capacity; col++) {
                if (col < itemWeight) {
                    table[row][col] = table[row - 1][col];
                    continue;
                }

                int totalValue = itemValue + table[row - 1][col - itemWeight];

                table[row][col] = Math.max(totalValue, table[row - 1][col]);
            }

        }

        return table;
    }

    public static List<Item> getMaxWeightItems01(List<Item> items, int capacity) {
        int[][] table = computeSubProblemsWeights(items, capacity);

        return getSelectedItems(items, capacity, table);
    }

    private static List<Item> getSelectedItems(List<Item> items, int capacity, int[][] table) {
        List<Item> selectedItems = new ArrayList<>(items.size());

        int remainder = table[items.size()][capacity];

        for (int row = table.length - 1; row > 0; row--) {
            for (int col = capacity; col > 0; col--) {
                if (remainder == table[row - 1][col]) {
                    break;
                }

                if (table[row][col] == remainder) {
                    selectedItems.add(items.get(row - 1));
                    remainder -= items.get(row - 1).getValue();
                }

                if (remainder <= 0) {
                    return selectedItems;
                }
            }
        }

        return selectedItems;
    }


    /**
     * Gets maximum profit for factional Knapsack problem
     *
     * @param items    items with weight as the key and profit as the value
     * @param capacity capacity of the knapsack
     * @return maximum profit the knapsack can hold
     */
    public static double getMaxWeightFractional(List<Map.Entry<Integer, Integer>> items, int capacity) {
        items.sort((o1, o2) -> {
            int item1Ratio = o1.getValue() / o1.getKey();
            int item2Ratio = o2.getValue() / o2.getKey();
            return (Integer.compare(item1Ratio, item2Ratio));
        });
        double filled = 0;
        double maxWeight = 0.0;
        for (int i = items.size() - 1; i > -1; i--) {
            if ((filled + items.get(i).getKey()) <= capacity) {
                maxWeight += items.get(i).getValue();
                filled += items.get(i).getKey();
            } else if ((capacity - filled) > 0) {
                double rem = capacity - filled;
                maxWeight += (Double.valueOf(items.get(i).getValue()) / Double.valueOf(items.get(i).getKey())) * rem;
            } else {
                break;
            }
        }
        return maxWeight;
    }
}
