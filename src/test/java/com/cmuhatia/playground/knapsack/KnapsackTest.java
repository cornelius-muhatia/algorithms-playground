package com.cmuhatia.playground.knapsack;

import org.junit.Test;

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
}