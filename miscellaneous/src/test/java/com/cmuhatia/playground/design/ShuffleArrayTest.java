package com.cmuhatia.playground.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ShuffleArrayTest {

    @Test
    void shuffleArray() {
        int[] nums = {1, 2, 3};

        ShuffleArray solution = new ShuffleArray(nums);

        assertNotEquals(nums, solution.shuffle());
        assertArrayEquals(nums, solution.reset());
    }

}