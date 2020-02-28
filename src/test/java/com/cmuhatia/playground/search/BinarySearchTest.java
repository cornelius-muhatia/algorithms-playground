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
    }
}