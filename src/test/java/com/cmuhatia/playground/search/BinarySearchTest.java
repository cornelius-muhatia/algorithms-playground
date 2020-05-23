package com.cmuhatia.playground.search;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void contains() {
        Character[] sortedArray = {'b', 'c', 'd', 'e', 'f'};
        Assert.assertFalse(BinarySearch.contains(sortedArray, 'a'));
        Assert.assertTrue(BinarySearch.contains(sortedArray, 'b'));
        Assert.assertTrue(BinarySearch.contains(sortedArray, 'e'));
        Assert.assertTrue(BinarySearch.contains(sortedArray, 'f'));
        Assert.assertFalse(BinarySearch.contains(sortedArray, 'g'));

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