package com.cmuhatia.playground.graph;


import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Cornelius Muhatia.
 * @version 1.0.0 4/23/20
 */
public class DijkstraAlgorithmTest {

    @Test
    public void calculateShortestPath() {
        WeightedGraph_<String, Double> graph = new WeightedGraph_<>();

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

    @Test
    public void testCalculateShortestPath() {
        WeightedGraph<String> graph = new WeightedGraph<>();
        WeightedGraph.Node<String> a = new WeightedGraph.Node<>("A");
        WeightedGraph.Node<String> b = new WeightedGraph.Node<>("B");
        WeightedGraph.Node<String> c = new WeightedGraph.Node<>("C");
        WeightedGraph.Node<String> d = new WeightedGraph.Node<>("D");
        TreeMap<WeightedGraph.Node<String>, Double> aNeighbours = new TreeMap<>();
        aNeighbours.put(b, 30.0);
        aNeighbours.put(c, 30.0);
        a.setNeighbours(aNeighbours);
        b.setNeighbours(new TreeMap<>(Map.of(d, 11.0)));
        c.setNeighbours(new TreeMap<>(Map.of(d, 15.0)));
        DijkstraAlgorithm.calculateShortestPath(graph, a);
//        assertEquals(Double.valueOf(20.0), a.getWeight());
    }
}