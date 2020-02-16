package com.cmuhatia.playground;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LoopsRoutineTest {

    @Test
    public void jumpOverNumbers() {
        List<Integer> data = List.of(3, 4, 1, 2, 5, 6, 9, 0, 1, 2, 3, 1);
        Assert.assertEquals(4, LoopsRoutine.jumpOverNumbers(data));
        data = List.of(0, 1, 3, 4);
        Assert.assertEquals(-1, LoopsRoutine.jumpOverNumbers(data));
    }

    @Test
    public void digitSum(){
        Assert.assertEquals(1, LoopsRoutine.digitSum(10L));
        Assert.assertEquals(2, LoopsRoutine.digitSum(2L));
        Assert.assertEquals(18, LoopsRoutine.digitSum(-3456L));
        Assert.assertEquals(43, LoopsRoutine.digitSum(1325132435356L));
    }

    @Test
    public void reverseString(){
        String test = "raw";
        Assert.assertEquals("war", LoopsRoutine.reverseString(test));
        Assert.assertEquals("r", LoopsRoutine.reverseString("r"));
        Assert.assertEquals("1001", LoopsRoutine.reverseString("1001"));
    }

    @Test
    public void isNumericPalindrome(){
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome(1001L));
        Assert.assertFalse(LoopsRoutine.isNumericPalindrome(1234L));
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome(3330333));
    }

    @Test
    public void isNumericPalindrome2(){
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome2(0L));
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome2(1L));
        Assert.assertFalse(LoopsRoutine.isNumericPalindrome2(42L));
        Assert.assertFalse(LoopsRoutine.isNumericPalindrome2(1234L));
        Assert.assertFalse(LoopsRoutine.isNumericPalindrome2(12345L));
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome2(100001L));
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome2(10001L));
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome2(3330333));
        Assert.assertFalse(LoopsRoutine.isNumericPalindrome2(10000000000L));
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome2(10000000001L));
    }

    @Test
    public void isNumericPalindrome3(){
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome3(0L));
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome3(1L));
        Assert.assertFalse(LoopsRoutine.isNumericPalindrome3(42L));
        Assert.assertFalse(LoopsRoutine.isNumericPalindrome3(1234L));
        Assert.assertFalse(LoopsRoutine.isNumericPalindrome3(12345L));
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome3(100001L));
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome3(10001L));
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome3(3330333));
        Assert.assertFalse(LoopsRoutine.isNumericPalindrome3(10000000000L));
        Assert.assertTrue(LoopsRoutine.isNumericPalindrome3(10000000001L));

    }
}