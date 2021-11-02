package com.cmuhatia.playground.knapsack;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 21/06/2020
 */
public class KnapsackTest {

    @Test
    public void getMaxWeight01Test(){
        List<Map.Entry<Integer, Integer>> items = List.of(Map.entry(10, 60), Map.entry(20, 100), Map.entry(30, 120));
        int capacity = 50;
        assertEquals(220, Knapsack.getMaxWeight01(items, capacity));

        items = List.of(Map.entry(20, 100), Map.entry(10, 60), Map.entry(30, 120));
        assertEquals(220, Knapsack.getMaxWeight01(items, capacity));

        items = List.of(Map.entry(5, 10), Map.entry(4, 400), Map.entry(6, 30), Map.entry(4, 50));
        assertEquals(450, Knapsack.getMaxWeight01(items, 10));

    }

    @Test
    public void getMaxWeightFractional() {
        final double DELTA = 1e-15;
        List<Map.Entry<Integer, Integer>> items = new ArrayList<>(List.of(Map.entry(10, 60), Map.entry(20, 100), Map.entry(30, 120)));

        int capacity = 50;
        assertEquals(240.0, Knapsack.getMaxWeightFractional(items, capacity), DELTA);

        items = new ArrayList<>(List.of(Map.entry(10, 60), Map.entry(20, 100), Map.entry(30, 120)));
        assertEquals(240, Knapsack.getMaxWeightFractional(items, capacity), DELTA);
        capacity = 15;
        items = new ArrayList<>(List.of(Map.entry(1, 5), Map.entry(3, 10), Map.entry(5, 15), Map.entry(4, 7),
                Map.entry(1, 8), Map.entry(3, 9), Map.entry(2, 4)));
        assertEquals(51, Knapsack.getMaxWeightFractional(items, capacity), DELTA);
    }

    @Test
    public void getMaxWeightItems01V2() {
        Item<Integer> item1 = new Item<>(3, 2);
        Item<Integer> item2 = new Item<>(5, 4);

        List<Item<Integer>> selectedItems = Knapsack.getMaxWeightItems01(
                List.of(
                        new Item<>(4, 3),
                        item1,
                        item2,
                        new Item<>(6, 1)
                ),
                8
        );

        assertEquals(2, selectedItems.size());

        assertTrue(selectedItems.contains(item1));
        assertTrue(selectedItems.contains(item2));

        Item<Integer> apple = new Item<>(2, 4);
        Item<Integer> orange = new Item<>(3, 5);
        Item<Integer> banana = new Item<>(1, 3);
        Item<Integer> melon = new Item<>(4, 7);

        selectedItems = Knapsack.getMaxWeightItems01(List.of(apple, orange, banana, melon), 5);

        assertEquals(List.of(melon, banana), selectedItems);
    }
}