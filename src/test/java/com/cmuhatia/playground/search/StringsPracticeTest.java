package com.cmuhatia.playground.search;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 02/08/2020
 */
public class StringsPracticeTest {

    @Test
    public void countSpecialStrings() {
        assertEquals(10, StringsPractice.countSpecialStrings("aaaa"));
    }
}