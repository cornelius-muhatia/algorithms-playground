/*
 * Copyright 2019 Cornelius M.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cmuhatia.playground;

/**
 *
 * @author Cornelius M.
 * @version 1.0.0, 31/05/2020
 */
public class Passwords {

    /**
     * Checks validity of the password. Rules:
     * <ul>
     *     <li>Should be at-least 8 and not more than 30 characters</li>
     *     <li>Should have at-least 1 number</li>
     *     <li>Should have at-least 1 uppercase character</li>
     *     <li>Should not contain the word "password"</li>
     *     <li>Should not have an empty space</li>
     * </ul>
     * @param password password string
     * @return true if it is a valid password and false otherwise
     */
    public static boolean isValidPassword(String password){
        return (!password.toLowerCase().contains("password")) && password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.<,!@#$%^&+=])(?=\\S+$).{8,30}$");
    }
}
