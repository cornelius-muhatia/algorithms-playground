package com.cmuhatia.playground.dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumSubArrayTest {

    @Test
    void getMaximumSum() {
        Assertions.assertEquals(
                6,
                MaximumSubArray.getMaximumSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})
        );
    }

    @Test
    void getMaximumSum2() {
        Assertions.assertEquals(
                9,
                MaximumSubArray.getMaximumSum(new int[]{5, 4, -1})
        );
    }

    @Test
    void getMaximumSum3() {
        Assertions.assertEquals(
                -1,
                MaximumSubArray.getMaximumSum(new int[]{-5, -4, -1})
        );
    }

    @Test
    void getMaximumSum4() {
        Assertions.assertEquals(
                0,
                MaximumSubArray.getMaximumSum(new int[]{})
        );
    }
}