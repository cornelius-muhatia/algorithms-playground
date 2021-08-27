package com.cmuhatia.playground.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Cornelius M.
 * @version 1.0.0, 11/08/2021
 */
public class GraphTraversalAlgorithmsTest {

    private DirectedGraph<Integer> directedGraph1;
    private DirectedGraph<Integer> directedGraph2;
    /**
     * Graph from: https://algs4.cs.princeton.edu/42digraph/
     */
    private DirectedGraph<Integer> complexDirectedGraph;

    @BeforeEach
    void setUp() {
        directedGraph1 = new DirectedGraph<>();
        directedGraph1.addEdge(0, 1);
        directedGraph1.addEdge(0, 3);
        directedGraph1.addEdge(1, 4);
        directedGraph1.addEdge(4, 3);
        directedGraph1.addEdge(3, 1);
        directedGraph1.addEdge(2, 5);
        directedGraph1.addEdge(2, 4);
        directedGraph1.addEdge(5, 5);

        directedGraph2 = new DirectedGraph<Integer>()
                .addEdge(1, 5)
                .addEdge(1, 4)
                .addEdge(2, 7)
                .addEdge(2, 6)
                .addEdge(3, null);
    }

    @Test
    public void testBreadthFirstSearch() {
        Assertions.assertEquals(
                List.of(2, 5, 4, 3, 1),
                GraphTraversalAlgorithms.breadthFirstSearch(directedGraph1, 2)
        );
    }

    @Test
    public void testBreadthSecondSearch() {
        Assertions.assertEquals(
                List.of(5),
                GraphTraversalAlgorithms.breadthFirstSearch(directedGraph1, 5)
        );
    }

    @Test
    public void testBreadthThirdSearch() {
        Assertions.assertEquals(
                List.of(0, 1, 3, 4),
                GraphTraversalAlgorithms.breadthFirstSearch(directedGraph1, 0)
        );
    }

    @Test
    public void depthFirstSearch() {
        directedGraph1 = new DirectedGraph<>();
        directedGraph1.addEdge(0, 1);
        directedGraph1.addEdge(0, 3);
        directedGraph1.addEdge(1, 4);
        directedGraph1.addEdge(4, 3);
        directedGraph1.addEdge(3, 1);
        directedGraph1.addEdge(2, 4);
        directedGraph1.addEdge(2, 5);
        directedGraph1.addEdge(5, 5);

        Assertions.assertEquals(
                List.of(2, 4, 3, 1, 5),
                GraphTraversalAlgorithms.depthFirstSearch(directedGraph1, 2)
        );
    }
}