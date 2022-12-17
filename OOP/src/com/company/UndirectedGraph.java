package com.company;

import java.util.*;

public class UndirectedGraph<K, V>{

    private final Map<K, List<K>> vertexes = new HashMap<>();
    private final Map<K, V> vertexToValue = new HashMap<>();

    public void addVertex(K vertex, V value) {
        if (!hasVertex(vertex)) {
            vertexes.put(vertex, new ArrayList<>());
            vertexToValue.put(vertex, value);
        }
    }

    public void addVertex(K vertex) {
        if (!hasVertex(vertex)) {
            vertexes.put(vertex, new ArrayList<>());
        }
    }

    private boolean hasVertex(K vertexName) {
        return vertexes.containsKey(vertexName);
    }

    public void addEdge(K firstVertex, K secondVertex) {
        if (!hasVertex(firstVertex)) addVertex(firstVertex);
        if (!hasVertex(secondVertex)) addVertex(secondVertex);
        List<K> edges1 = vertexes.get(firstVertex);
        List<K> edges2 = vertexes.get(secondVertex);
        edges1.add(secondVertex);
        edges2.add(firstVertex);
    }

    public List<K> getNeighboringVertexes(K key) {
        return vertexes.get(key);
    }

    public V getValue(K key) {
        return vertexToValue.get(key);
    }

}
