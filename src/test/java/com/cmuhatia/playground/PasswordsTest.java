package com.cmuhatia.playground;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 31/05/2020
 */
public class PasswordsTest {

    @Test
    public void isValidPassword() {
        assertFalse(Passwords.isValidPassword(""));
        assertFalse(Passwords.isValidPassword(" "));
        assertFalse(Passwords.isValidPassword("12345678"));
        assertFalse(Passwords.isValidPassword("abcpfwki"));
        assertFalse(Passwords.isValidPassword("Tpassword"));
        assertTrue(Passwords.isValidPassword("Test2020."));
        assertFalse(Passwords.isValidPassword("Test2020.dTest2020.dTest2020.dq"));
        assertFalse(Passwords.isValidPassword("Password2019."));
    }
}