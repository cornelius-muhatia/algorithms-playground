package com.cmuhatia.playground.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 26/02/2022
 */
class TrieTreeTest {

    @Test
    public void canInsertWords() {
        TrieTree tree = new TrieTree();

        assertFalse(tree.contains("random-word"));

        tree.insert("abc");
        assertTrue(tree.contains("abc"));

        tree.insert("abgl");
        tree.insert("cdf");
        tree.insert("abcd");
        tree.insert("lmn");

        assertTrue(tree.contains("abgl"));
        assertTrue(tree.contains("cdf"));
        assertTrue(tree.contains("abcd"));
        assertTrue(tree.contains("lmn"));
    }

    @Test
    public void canDeleteWords() {
        TrieTree tree = new TrieTree();
        tree.insertAll(List.of("abc", "cdf", "cdf", "abcd"));

        tree.delete("abc");
        assertFalse(tree.contains("abc"));

        tree.delete("cdf");
        assertFalse(tree.contains("cdf"));

        tree.delete("abcd");
        assertFalse(tree.contains("abcd"));
    }

}