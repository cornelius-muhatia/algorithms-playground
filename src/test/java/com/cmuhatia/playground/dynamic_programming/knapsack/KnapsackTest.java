package com.cmuhatia.playground.dynamic_programming.knapsack;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Cornelius M.
 * @version 1.0.0, 21/06/2020
 */
class KnapsackTest {

    @Test
    void getMaxWeight01Test() {
        List<Item> items = List.of(
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        );

        assertEquals(220, Knapsack.getMaxWeight01(items, 50));

        items = List.of(
                new Item(2, 100),
                new Item(1, 60),
                new Item(3, 120)
        );
        assertEquals(220, Knapsack.getMaxWeight01(items, 5));

        items = List.of(
                new Item(5, 10),
                new Item(4, 400),
                new Item(6, 30),
                new Item(4, 50)
        );
        assertEquals(450, Knapsack.getMaxWeight01(items, 10));
    }

    @Test
    void getMaxWeightFractional() {
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
    void getMaxWeightItems01V2() {
        Item item1 = new Item(3, 2);
        Item item2 = new Item(5, 4);

        List<Item> selectedItems = Knapsack.getMaxWeightItems01(
                List.of(
                        new Item(4, 3),
                        item1,
                        item2,
                        new Item(6, 1)
                ),
                8
        );

        assertEquals(2, selectedItems.size());

        assertTrue(selectedItems.contains(item1));
        assertTrue(selectedItems.contains(item2));

        Item apple = new Item(2, 4);
        Item orange = new Item(3, 5);
        Item banana = new Item(1, 3);
        Item melon = new Item(4, 7);

        selectedItems = Knapsack.getMaxWeightItems01(List.of(apple, orange, banana, melon), 5);

        assertEquals(List.of(melon, banana), selectedItems);
    }

    @Test
    void getMaxWeightItems01V2SecondTest() {
        Item apple = new Item(2, 100);
        Item orange = new Item(1, 60);
        Item banana = new Item(3, 120);

        List<Item> items = List.of(apple, orange, banana);

        Assertions.assertTrue(
                Knapsack.getMaxWeightItems01(items, 5)
                        .containsAll(List.of(apple, banana))
        );
    }
}