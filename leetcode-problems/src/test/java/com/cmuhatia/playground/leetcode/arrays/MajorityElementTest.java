package com.cmuhatia.playground.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityElementTest {

    @Test
    void of() {
        assertEquals(3, MajorityElement.of(new int[]{3, 2, 3}));
    }

    @Test
    void of2() {
        assertEquals(2, MajorityElement.of(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}