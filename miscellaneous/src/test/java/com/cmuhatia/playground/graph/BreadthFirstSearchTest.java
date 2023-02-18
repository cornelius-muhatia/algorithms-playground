package com.cmuhatia.playground.graph;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0.0, 28/05/2022
 */
class BreadthFirstSearchTest {

    @Test
    public void testDirectedGraph() {
        Graph<Character> graph = new Graph<>(true);

        Vertex<Character> a = new Vertex<>('A');
        Vertex<Character> b = new Vertex<>('B');
        Vertex<Character> c = new Vertex<>('C');
        Vertex<Character> d = new Vertex<>('D');

        graph.addEdge(a, new LinkedList<>(List.of(b, c)));
        graph.addEdge(b, d);
        graph.addEdge(c, d);

        assertArrayEquals(
                new Vertex[]{a, b, c, d},
                BreadthFirstSearch
                        .traverseGraph(graph, a).toArray()
        );
    }

    @Test
    public void testUnDirectedGraph() {
        Graph<Character> graph = new Graph<>(false);

        Vertex<Character> a = new Vertex<>('A');
        Vertex<Character> b = new Vertex<>('B');
        Vertex<Character> c = new Vertex<>('C');
        Vertex<Character> d = new Vertex<>('D');

        graph.addEdge(a, new LinkedList<>(List.of(b, c)));
        graph.addEdge(b, d);
        graph.addEdge(c, d);

        assertArrayEquals(
                new Vertex[]{a, b, c, d},
                BreadthFirstSearch
                        .traverseGraph(graph, a).toArray()
        );
    }

}