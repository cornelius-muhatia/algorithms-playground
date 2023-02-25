package com.cmuhatia.playground.leetcode.graphs;

import lombok.*;

import java.util.*;

/**
 * <p>
 * Given a reference of a node in a connected undirected graph. <br />
 * Return a deep copy (clone) of the graph. <br />
 * Each node in the graph contains a value (int) and a list {@link List<CloneGraph.Node>}) of its neighbors.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/clone-graph/">LeetCode Clone Graph</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloneGraph {

    public static Node of(Node node) {
        return node == null ? null : clone(node, new HashMap<>());
    }

    private static Node clone(Node node, Map<Integer, Node> temp) {
        if (temp.containsKey(node.val)) {
            return temp.get(node.val);
        }

        Node nodeCopy = new Node(node.val);
        temp.put(node.val, nodeCopy);
        for (var it : node.neighbors) {
            nodeCopy.neighbors.add(clone(it, temp));
        }

        return nodeCopy;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = {"val"})
    @Data
    public static class Node {
        int val;
        List<Node> neighbors = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

        public void addNeighbours(Collection<Node> nodes) {
            neighbors.addAll(nodes);
        }
    }
}
