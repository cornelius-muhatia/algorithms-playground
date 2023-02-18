package com.cmuhatia.playground.search;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 02/08/2020
 */
public class StringsPracticeTest {

    @Test
    @Disabled
    public void countSpecialStrings() {
        assertEquals(10, StringsPractice.countSpecialStrings("aaaa"));
    }
}