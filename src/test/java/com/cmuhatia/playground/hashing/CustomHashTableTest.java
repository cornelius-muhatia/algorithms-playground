package com.cmuhatia.playground.hashing;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 07/05/2022
 */
public class CustomHashTableTest {

    public void add() {
        CustomHashTable<String> hashTable = new CustomHashTable<>();
        hashTable.add(0, "String 0");
        hashTable.add(3, "String 3");
        hashTable.add(5, "String 5");

        assertEquals("String 0", hashTable.get(0));
        assertEquals("String 3", hashTable.get(3));
        assertEquals("String 5", hashTable.get(5));

        assertThrows(Exception.class, () -> hashTable.get(55));
    }
}