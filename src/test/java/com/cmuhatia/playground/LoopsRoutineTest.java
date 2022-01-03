package com.cmuhatia.playground;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoopsRoutineTest {

    @Test
    public void jumpOverNumbers() {
        List<Integer> data = List.of(3, 4, 1, 2, 5, 6, 9, 0, 1, 2, 3, 1);
        assertEquals(4, LoopsRoutine.jumpOverNumbers(data));
        data = List.of(0, 1, 3, 4);
        assertEquals(-1, LoopsRoutine.jumpOverNumbers(data));
    }

    @Test
    public void digitSum(){
        assertEquals(1, LoopsRoutine.digitSum(10L));
        assertEquals(2, LoopsRoutine.digitSum(2L));
        assertEquals(18, LoopsRoutine.digitSum(-3456L));
        assertEquals(43, LoopsRoutine.digitSum(1325132435356L));
    }

    @Test
    public void reverseString(){
        String test = "raw";
        assertEquals("war", LoopsRoutine.reverseString(test));
        assertEquals("r", LoopsRoutine.reverseString("r"));
        assertEquals("1001", LoopsRoutine.reverseString("1001"));
    }

    @Test
    public void isNumericPalindrome(){
        assertTrue(LoopsRoutine.isNumericPalindrome(1001L));
        assertFalse(LoopsRoutine.isNumericPalindrome(1234L));
        assertTrue(LoopsRoutine.isNumericPalindrome(3330333));
    }

    @Test
    public void isNumericPalindrome2(){
        assertTrue(LoopsRoutine.isNumericPalindrome2(0L));
        assertTrue(LoopsRoutine.isNumericPalindrome2(1L));
        assertFalse(LoopsRoutine.isNumericPalindrome2(42L));
        assertFalse(LoopsRoutine.isNumericPalindrome2(1234L));
        assertFalse(LoopsRoutine.isNumericPalindrome2(12345L));
        assertTrue(LoopsRoutine.isNumericPalindrome2(100001L));
        assertTrue(LoopsRoutine.isNumericPalindrome2(10001L));
        assertTrue(LoopsRoutine.isNumericPalindrome2(3330333));
        assertFalse(LoopsRoutine.isNumericPalindrome2(10000000000L));
        assertTrue(LoopsRoutine.isNumericPalindrome2(10000000001L));
    }

    @Test
    public void isNumericPalindrome3(){
        assertTrue(LoopsRoutine.isNumericPalindrome3(0L));
        assertTrue(LoopsRoutine.isNumericPalindrome3(1L));
        assertFalse(LoopsRoutine.isNumericPalindrome3(42L));
        assertFalse(LoopsRoutine.isNumericPalindrome3(1234L));
        assertFalse(LoopsRoutine.isNumericPalindrome3(12345L));
        assertTrue(LoopsRoutine.isNumericPalindrome3(100001L));
        assertTrue(LoopsRoutine.isNumericPalindrome3(10001L));
        assertTrue(LoopsRoutine.isNumericPalindrome3(3330333));
        assertFalse(LoopsRoutine.isNumericPalindrome3(10000000000L));
        assertTrue(LoopsRoutine.isNumericPalindrome3(10000000001L));
    }
}