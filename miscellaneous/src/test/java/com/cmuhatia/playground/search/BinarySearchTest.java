package com.cmuhatia.playground.search;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @Test
    public void contains() {
        Character[] sortedArray = {'b', 'c', 'd', 'e', 'f'};
        assertFalse(BinarySearch.contains(sortedArray, 'a'));
        assertTrue(BinarySearch.contains(sortedArray, 'b'));
        assertTrue(BinarySearch.contains(sortedArray, 'e'));
        assertTrue(BinarySearch.contains(sortedArray, 'f'));
        assertFalse(BinarySearch.contains(sortedArray, 'g'));

        String[] strings = {"Able", "Boy", "Cook", "Dam", "Eat"};
        assertTrue(BinarySearch.contains(strings, "Eat"));
        assertTrue(BinarySearch.contains(strings, "Able"));
        assertTrue(BinarySearch.contains(strings, "Cook"));
        assertFalse(BinarySearch.contains(strings, "Nope"));

        Integer[] numbers = {1, 2, 3, 4, 5, 100, 200};
        assertTrue(BinarySearch.contains(numbers, 100));
        assertFalse(BinarySearch.contains(numbers, 2000));
    }
}