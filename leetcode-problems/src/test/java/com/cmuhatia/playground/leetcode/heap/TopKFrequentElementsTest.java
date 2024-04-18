package com.cmuhatia.playground.leetcode.heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class TopKFrequentElementsTest {

    @Test
    void of() {
        int[] numbers = {1, 1, 1, 2, 2, 3};

        assertEquals(Set.of(1, 2), TopKFrequentElements.of(numbers, 2));
    }

    @Test
    void of2() {
        int[] numbers = {1};

        assertEquals(Set.of(1), TopKFrequentElements.of(numbers, 1));
    }

    @Test
    void of3() {
        int[] numbers = {4, 1, -1, 2, -1, 2, 3};
        assertEquals(Set.of(2, -1),
                TopKFrequentElements.of(numbers, 2)
        );

    }

    private void assertEquals(Set<Integer> expected, int[] actual) {
        assert expected.equals(
                Arrays.stream(actual)
                        .boxed()
                        .collect(Collectors.toSet())
        );
    }
}