/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmuhatia.playground;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cornelius
 */
public class OddOccurrencesInArrayTest {
    
    public OddOccurrencesInArrayTest() {
    }

    /**
     * Test of solution method, of class OddOccurrencesInArray.
     */
    @Test
    public void testSolution() {
        System.out.println("solution");
        OddOccurrencesInArray occurrence = new OddOccurrencesInArray();
        int a[] = {2,2,3};
        assertEquals(3, occurrence.solution(a));
    }
    
}
