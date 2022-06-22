package com.cmuhatia.playground.graph;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JohnsonsAlgorithmTest {

    @Test
    void calculateVerticesDistance() {
        WeightedGraph<String> graph = new WeightedGraph<>();

        WeightedNode<String> a = new WeightedNode<>("A");
        WeightedNode<String> b = new WeightedNode<>("B");
        WeightedNode<String> c = new WeightedNode<>("C");
        WeightedNode<String> d = new WeightedNode<>("D");

        a.setNeighbours(new HashMap<>(Map.of(c, -2.0)));
        b.setNeighbours(new HashMap<>(Map.of(a, 4.0, c, 3.0)));
        c.setNeighbours(new HashMap<>(Map.of(d, 2.0)));
        d.setNeighbours(new HashMap<>(Map.of(b, -1.0)));

        graph.addAll(Set.of(a, b, c, d));

        var verticesDistances = JohnsonsAlgorithm.calculateVerticesDistance(graph);

        assertEquals(
                Map.of(a, 0.0, b, -1.0, c, -2.0, d, 0.0),
                verticesDistances.get(a)
        );
        assertEquals(
                Map.of(a, 4.0, b, 0.0, c, 2.0, d, 4.0),
                verticesDistances.get(b)
        );
        assertEquals(
                Map.of(a, 5.0, b, 1.0, c, 0.0, d, 2.0),
                verticesDistances.get(c)
        );
        assertEquals(
                Map.of(a, 3.0, b, -1.0, c, 1.0, d, 0.0),
                verticesDistances.get(d)
        );
    }
}