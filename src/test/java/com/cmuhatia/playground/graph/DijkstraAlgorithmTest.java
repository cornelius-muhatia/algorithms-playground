package com.cmuhatia.playground.graph;


import com.cmuhatia.playground.search.Node;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Cornelius Muhatia.
 * @version 1.0.0 4/23/20
 */
public class DijkstraAlgorithmTest {

    @Test
    public void testCalculateShortestPath() {
        //graph one
        WeightedGraph<String> graph = new WeightedGraph<>();
        WeightedGraph.Node<String> a = new WeightedGraph.Node<>("A");
        WeightedGraph.Node<String> b = new WeightedGraph.Node<>("B");
        WeightedGraph.Node<String> c = new WeightedGraph.Node<>("C");
        WeightedGraph.Node<String> d = new WeightedGraph.Node<>("D");

        graph.addAll(Set.of(a, b, c, d));
        assertEquals(4, graph.size());

        Map<WeightedGraph.Node<String>, Double> aNeighbours = new HashMap<>();
        aNeighbours.put(b, 20.0);
        aNeighbours.put(c, 30.0);
        a.setNeighbours(aNeighbours);
        b.setNeighbours(Map.of(d, 11.0));
        c.setNeighbours(Map.of(d, 15.0));

        DijkstraAlgorithm.calculateShortestPath(a);

        assertEquals(Double.valueOf(20.0), b.getWeight());
        assertEquals(Double.valueOf(30.0), c.getWeight());
        assertEquals(Double.valueOf(31.0), d.getWeight());

        //graph two
        WeightedGraph<String> graph2 = new WeightedGraph<>();
        a = new WeightedGraph.Node<>("A");
        b = new WeightedGraph.Node<>("B");
        c = new WeightedGraph.Node<>("C");
        d = new WeightedGraph.Node<>("D");
        WeightedGraph.Node<String> e = new WeightedGraph.Node<>("E");
        WeightedGraph.Node<String> f = new WeightedGraph.Node<>("f");

        graph2.addAll(Set.of(a, b, c, d, e, f));
        assertEquals(6, graph2.size());

        a.setNeighbours(Map.of(b, 10.0, c, 15.0));
        b.setNeighbours(Map.of(f, 15.0, d, 12.0));
        c.setNeighbours(Map.of(e, 10.0));
        d.setNeighbours(Map.of(f, 1.0, e, 2.0));
        f.setNeighbours(Map.of(e, 24.0));

        DijkstraAlgorithm.calculateShortestPath(a);

        assertEquals(Double.valueOf(10.0), b.getWeight());
        assertEquals(Double.valueOf(15.0), c.getWeight());
        assertEquals(Double.valueOf(22.0), d.getWeight());
        assertEquals(Double.valueOf(24.0), e.getWeight());
        assertEquals(Double.valueOf(23.0), f.getWeight());

        assertEquals(List.of(e, d, b, a), e.getShortestPath());
        assertEquals(List.of(f, d, b, a), f.getShortestPath());

    }
}