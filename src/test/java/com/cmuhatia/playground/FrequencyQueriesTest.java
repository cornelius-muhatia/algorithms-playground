package com.cmuhatia.playground;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 15/06/2020
 */
public class FrequencyQueriesTest {

//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//    private final PrintStream originalErr = System.err;
//
//    @Before
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//        System.setErr(new PrintStream(errContent));
//    }
//
//    @After
//    public void restoreStreams() {
//        System.setOut(originalOut);
//        System.setErr(originalErr);
//    }


    @Test
    public void freqQuery() {
        List<List<Integer>> p1 = List.of(List.of(1, 5), List.of(1, 6), List.of(3, 2), List.of(1, 10), List.of(1, 10),
                List.of(1, 6), List.of(2, 5), List.of(3, 2));
        assertEquals(List.of(0, 1), FrequencyQueries.freqQuery(p1));

        List<List<Integer>> p2 = List.of(List.of(3, 4), List.of(2, 1003), List.of(1, 6), List.of(3, 1));
        assertEquals(List.of(0, 1), FrequencyQueries.freqQuery(p2));

    }
}