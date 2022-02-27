/*
 * Copyright 2022 Cornelius M.
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
package com.cmuhatia.playground.tree;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Copied from <a href="https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java">Tushar Roy</a>
 * @version 1.0.0, 26/02/2022
 */
public class TrieTree {

    private final TrieNode root = new TrieNode();

    public void insertAll(Collection<String> words) {
        words.forEach(this::insert);
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }

        current.endOfWord = true;
    }

    public boolean contains(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);

            if (node == null) {
                return false;
            }
            current = node;
        }

        return current.endOfWord;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;

            return current.children.size() == 0;
        }

        char ch = word.charAt(index);

        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }

        return false;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();

        boolean endOfWord;
    }
}
