/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmuhatia.playground;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cornelius
 */
public class OddOccurrencesInArrayTest {
    
    public OddOccurrencesInArrayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of solution method, of class OddOccurrencesInArray.
     */
    @Test
    public void testSolution() {
        System.out.println("solution");
        OddOccurrencesInArray occurrence = new OddOccurrencesInArray();
        int a[] = {2,2,3};
        assertEquals("Best case", 3, occurrence.solution(a));
    }
    
}
