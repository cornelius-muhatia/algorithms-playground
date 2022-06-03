package com.cmuhatia.playground.graph;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Cornelius M.
 * @version 1.0.0, 09/06/2020
 */
public class BellmanFordTest {

    @Test
    public void calculateShortestPath() {
        WeightedGraph<String> graph = new WeightedGraph<>();

        WeightedGraph.Node<String> a = new WeightedGraph.Node<>("A");
        WeightedGraph.Node<String> b = new WeightedGraph.Node<>("B");
        WeightedGraph.Node<String> c = new WeightedGraph.Node<>("C");
        WeightedGraph.Node<String> d = new WeightedGraph.Node<>("D");
        WeightedGraph.Node<String> e = new WeightedGraph.Node<>("E");

        graph.addAll(Set.of(a, b, c, d, e));
        assertEquals(5, graph.size());

        a.setNeighbours(Map.of(b, -1.0, c, 4.0));
        b.setNeighbours(Map.of(c, 3.0, d, 2.0, e, 2.0));
        c.setNeighbours(Map.of());
        d.setNeighbours(Map.of(c, 5.0, b, 1.0));
        e.setNeighbours(Map.of(d, -3.0));

        BellmanFord.calculateShortestPath(graph, a);

        assertEquals(Double.valueOf(0.0), a.getWeight());
        assertEquals(Double.valueOf(-1.0), b.getWeight());
        assertEquals(Double.valueOf(2.0), c.getWeight());
        assertEquals(Double.valueOf(-2.0), d.getWeight());
        assertEquals(Double.valueOf(1.0), e.getWeight());


    }

    @Test
    public void calculateShortestPath2(){
        WeightedGraph<String> graph = new WeightedGraph<>();

        WeightedGraph.Node<String> one = new WeightedGraph.Node<>("1");
        WeightedGraph.Node<String> two = new WeightedGraph.Node<>("2");
        WeightedGraph.Node<String> three = new WeightedGraph.Node<>("3");
        WeightedGraph.Node<String> four = new WeightedGraph.Node<>("4");
        WeightedGraph.Node<String> five = new WeightedGraph.Node<>("5");
        WeightedGraph.Node<String> six = new WeightedGraph.Node<>("6");
        WeightedGraph.Node<String> seven = new WeightedGraph.Node<>("7");

        graph.addAll(Set.of(one, two, three, four, five, six, seven));
        assertEquals(7, graph.size());

        one.setNeighbours(Map.of(two, 6.0, three, 5.0, four, 5.0));
        two.setNeighbours(Map.of(five, -1.0));
        three.setNeighbours(Map.of(five, 1.0, two, -2.0));
        four.setNeighbours(Map.of(three, -2.0, six, -1.0));
        five.setNeighbours(Map.of(seven, 3.0));
        six.setNeighbours(Map.of(seven, 3.0));

        BellmanFord.calculateShortestPath(graph, one);

        assertEquals(Double.valueOf(0.0), one.getWeight());
        assertEquals(Double.valueOf(1.0), two.getWeight());
        assertEquals(Double.valueOf(3.0), three.getWeight());
        assertEquals(Double.valueOf(5.0), four.getWeight());
        assertEquals(Double.valueOf(0.0), five.getWeight());
        assertEquals(Double.valueOf(4.0), six.getWeight());
        assertEquals(Double.valueOf(3.0), seven.getWeight());
    }

    @Test
    public void calculateShortestPath3(){
        WeightedGraph<String> graph = new WeightedGraph<>();

        WeightedGraph.Node<String> one = new WeightedGraph.Node<>("1");
        WeightedGraph.Node<String> two = new WeightedGraph.Node<>("2");
        WeightedGraph.Node<String> three = new WeightedGraph.Node<>("3");
        WeightedGraph.Node<String> four = new WeightedGraph.Node<>("4");

        graph.addAll(Set.of(one, two, three, four));

        one.setNeighbours(Map.of(two, 4.0, four, 5.0));
        two.setNeighbours(Map.of(four, 5.0));
        three.setNeighbours(Map.of(two, -10.0));
        four.setNeighbours(Map.of(three, 3.0));

        assertThrows(StackOverflowError.class, () -> BellmanFord.calculateShortestPath(graph, one));
    }
}