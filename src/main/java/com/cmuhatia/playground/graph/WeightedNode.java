package com.cmuhatia.playground.graph;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Data
@RequiredArgsConstructor
@ToString(of = {"label", "weight"})
public class WeightedNode<T> implements Cloneable {

    final T label;

    Map<WeightedNode<T>, Double> neighbours = new HashMap<>();

    Double weight;

    WeightedNode<T> parent;

    /**
     * Returns the shortest path in a reversed order starting with the current node
     *
     * @return shortest path nodes
     */
    public LinkedList<WeightedNode<T>> getShortestPath() {
        LinkedList<WeightedNode<T>> shortestPath = new LinkedList<>();
        shortestPath.add(this);

        WeightedNode<T> currentParent = parent;

        while (currentParent != null) {
            shortestPath.add(currentParent);
            currentParent = currentParent.getParent();
        }

        return shortestPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeightedNode<?> node = (WeightedNode<?>) o;

        return getLabel().equals(node.getLabel());
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}
