package com.cmuhatia.playground.sort.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstBadVersionTest {

    @Test
    void findFirstBadVersion() {
        Assertions.assertEquals(
                4,
                FirstBadVersion.find(5, n -> n > 3)
        );
    }

    @Test
    void findFirstBadVersion2() {
        Assertions.assertEquals(
                1,
                FirstBadVersion.find(1, n -> n == 1)
        );

        Assertions.assertEquals(
                1,
                FirstBadVersion.find(9, n -> n > 0)
        );
    }

    @Test
    void findFirstBadVersion3() {
        Assertions.assertEquals(
                3,
                FirstBadVersion.find(7, n -> n > 2 && n < 6)
        );
    }

    @Test
    void findFirstBadVersion4() {
        Assertions.assertEquals(
                1,
                FirstBadVersion.find(2, n -> n == 1)
        );
    }

    @Test
    void findFirstBadVersion5() {
        Assertions.assertEquals(
                1,
                FirstBadVersion.find(9, n -> n > 0)
        );
    }

    @Test
    void findFirstBadVersion6() {
        Assertions.assertEquals(
                9,
                FirstBadVersion.find(9, n -> n == 9)
        );
    }

    @Test
    void findFirstBadVersion1() {
        Assertions.assertEquals(
                1702766719,
                FirstBadVersion.find(2126753390, n -> n >= 1702766719)
        );
    }
}