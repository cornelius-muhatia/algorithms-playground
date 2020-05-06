package com.cmuhatia.playground.graph;


import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Cornelius Muhatia.
 * @version 1.0.0 4/23/20
 */
public class DijkstraAlgorithmTest {

    @Test
    public void calculateShortestPath() {
        WeightedGraph<String, Double> graph = new WeightedGraph<>();

        WeightedVertex<String, Double> a = new WeightedVertex<>("A");
        WeightedVertex<String, Double> b = new WeightedVertex<>("B");
        WeightedVertex<String, Double> c = new WeightedVertex<>("C");
        a.setAdjacentVertex(Map.of(b, 1.0, c, 3.0));

        WeightedVertex<String, Double> d = new WeightedVertex<>("D");
        b.setAdjacentVertex(Map.of(d, 4.0));
        c.setAdjacentVertex(Map.of(d, 7.0, b, 6.0));

        graph.vertices.addAll(List.of(a, b, c, d));

        DijkstraAlgorithm<String> dijkstra = new DijkstraAlgorithm<>(graph);
        dijkstra.calculateShortestPath(a);

        LinkedList<WeightedVertex<String, Double>> shortestPath = new LinkedList<>();
        shortestPath.add(a);
        shortestPath.add(b);

//        Assert.assertTrue(d.getWeight().equals(Double.valueOf(5.0)));
//        assertEquals(Double.valueOf(5.0), d.getWeight());
        assertEquals(shortestPath, d.getShortestPath());
    }
}