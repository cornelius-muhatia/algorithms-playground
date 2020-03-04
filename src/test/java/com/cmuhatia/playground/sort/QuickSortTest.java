package com.cmuhatia.playground.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.fail;

public class QuickSortTest {

    @Test
    public void sarajQuickSort(){
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        int[] sortedArr = {10, 30, 40, 50, 70, 80, 90};
        for(int i = 0; i < arr.length; i++){
            Assert.assertEquals("Comparing element " + arr[i], arr[i], sortedArr[i]);
        }

    }

}