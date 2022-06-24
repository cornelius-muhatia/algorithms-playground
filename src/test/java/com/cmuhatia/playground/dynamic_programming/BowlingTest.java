package com.cmuhatia.playground.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 24/06/2022
 */
class BowlingTest {

    @Test
    public void recursively() {
        assertEquals(
                106,
                Bowling.recursively(new int[]{-1, 1, 1, 1, 9, 9, 3, -3, -5, 2, 2})
        );
    }

    @Test
    public void iteratively() {
        assertEquals(
                106,
                Bowling.iteratively(new int[]{-1, 1, 1, 1, 9, 9, 3, -3, -5, 2, 2})
        );
    }

}