package com.cmuhatia.playground.leetcode.graphs;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CloneGraphTest {

    @Test
    void of() {
        assertTrue(
                equalsAndNotSameObject(
                        CloneGraph.of(new CloneGraph.Node()),
                        new CloneGraph.Node()
                )
        );
    }

    @Test
    void of2() {
        var graph1 = initializeExample1();
        assertTrue(
                equalsAndNotSameObject(
                        CloneGraph.of(graph1),
                        graph1
                )
        );
    }

    private CloneGraph.Node initializeExample1() {
        CloneGraph.Node one = new CloneGraph.Node(1);
        CloneGraph.Node two = new CloneGraph.Node(2);
        CloneGraph.Node three = new CloneGraph.Node(3);
        CloneGraph.Node four = new CloneGraph.Node(4);

        one.addNeighbours(List.of(two, four));
        two.addNeighbours(List.of(one, three));
        three.addNeighbours(List.of(two, four));
        four.addNeighbours(List.of(three, one));

        return one;
    }

    @Test
    void of3() {
        assertNull(CloneGraph.of(null));
    }

    @Test
    void testNodeEquality() {
        CloneGraph.Node node1 = new CloneGraph.Node(1, new ArrayList<>());
        CloneGraph.Node node2 = new CloneGraph.Node(1, new ArrayList<>());

        CloneGraph.Node node3 = node1;

        assertTrue(equalsAndNotSameObject(node1, node2));
        assertFalse(equalsAndNotSameObject(node1, node3));
    }

    private boolean equalsAndNotSameObject(CloneGraph.Node node1, CloneGraph.Node node2) {
        var node1Identity = ObjectUtils.identityToString(node1);
        var node2Identity = ObjectUtils.identityToString(node2);

        return Objects.equals(node1, node2) && !Objects.equals(node1Identity, node2Identity);
    }
}