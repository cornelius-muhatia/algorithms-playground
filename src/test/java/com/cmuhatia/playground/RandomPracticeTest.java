package com.cmuhatia.playground;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 25/06/2020
 */
public class RandomPracticeTest {

    @Test
    public void commonPrefix() {
    }

    @Test
    public void canCreateEqualPairs() {
        assertTrue(RandomPractice.canCreateEqualPairs(new int[]{1,2,2,1}));
        assertFalse(RandomPractice.canCreateEqualPairs(new int[]{7, 7, 7}));
        assertFalse(RandomPractice.canCreateEqualPairs(new int[]{1, 2, 2, 3}));
        assertFalse(RandomPractice.canCreateEqualPairs(new int[]{1, 2, 3, 3}));
        assertFalse(RandomPractice.canCreateEqualPairs(new int[]{1, 3, 2, 3}));
    }

    @Test
    public void findDestination() {
        assertEquals(3, RandomPractice.findDestination(new int[]{0, 1, 2, 4, 5}, new int[]{2, 3, 3, 3, 2}));
        assertEquals(-1, RandomPractice.findDestination(new int[]{2, 3, 3, 4}, new int[]{1, 1, 0, 0}));
        assertEquals(0, RandomPractice.findDestination(new int[]{1, 2, 3}, new int[]{0, 0, 0}));
        assertEquals(0, RandomPractice.findDestination(new int[]{1, 2, 3, 0}, new int[]{0, 0, 0, 0}));
    }

    @Test
    public void objectSize() {
        Object obj;
    }

}