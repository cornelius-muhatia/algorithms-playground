package com.cmuhatia.playground.java.changes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 08/02/2021
 */
class SwitchExpressionTest {

    @Test
    void weekDay() {
        SwitchExpression switchExpr = new SwitchExpression();
        assertEquals("Sunday", switchExpr.weekDay(1));
        assertThrows(IllegalArgumentException.class, () -> switchExpr.weekDay(15));
    }
}