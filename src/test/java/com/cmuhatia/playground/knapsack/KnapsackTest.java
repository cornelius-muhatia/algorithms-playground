package com.cmuhatia.playground.knapsack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        capacity = 50;
        items = new ArrayList<>(List.of(Map.entry(10, 60), Map.entry(20, 100), Map.entry(30, 120)));
        assertEquals(240, Knapsack.getMaxWeightFractional(items, capacity), DELTA);

        capacity = 15;
        items = new ArrayList<>(List.of(Map.entry(1, 5), Map.entry(3, 10), Map.entry(5, 15), Map.entry(4, 7),
                Map.entry(1, 8), Map.entry(3, 9), Map.entry(2, 4)));
        assertEquals(51, Knapsack.getMaxWeightFractional(items, capacity), DELTA);
    }
}