package ch22.s1;

import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;

import java.util.*;

public class AdjacencyListGraph<V extends Vertex, E extends Edge> implements Graph<V, E> {
    private final Object[] graph;

    public AdjacencyListGraph(int capacity) {
        graph = new Object[capacity];
    }

    @Override
    public void add(V vertex) {
        graph[vertex.getIndex()] = new Node(vertex, new LinkedList<V>());
    }

    @Override
    public void delete(int index) {
        List<V> vertices = getVertices();
        V current = getVertex(index);
        vertices.forEach(vertex -> {
            disconnect(current, vertex);
            disconnect(vertex, current);
        });
        graph[index] = null;
    }

    @Override
    public void connect(V from, V to) {
        getNode(from.getIndex()).adjacencyList.add(to);
    }

    @Override
    public void disconnect(V from, V to) {
        getNode(from.getIndex()).adjacencyList.remove(to);
    }

    @Override
    public V getVertex(int index) {
        return getNode(index).vertex;
    }

    @Override
    public E getEdge(int from, int to) {
        Edge edge = null;
        if (isConnected(from, to)) {
            edge = new Edge();
            edge.setFrom(getVertex(from));
            edge.setTo(getVertex(to));
        }
        return (E) edge;
    }

    @Override
    public List<V> getVertices() {
        List<V> vertices = new ArrayList<>();

        for (Object node : graph) {
            if (node != null)
                vertices.add(((Node) node).vertex);
        }

        return vertices;
    }

    @Override
    public List<V> getAdjacentVertices(int index) {
        return getNode(index).adjacencyList;
    }

    @Override
    public List<E> getEdges() {
        final List<E> edges = new ArrayList<>();
        final List<V> vertices = getVertices();
        vertices.forEach(vertex -> {
            List<V> neighbors = getAdjacentVertices(vertex.getIndex());
            neighbors.forEach(neighbor -> {
                Edge edge = new Edge();
                edge.setFrom(vertex);
                edge.setTo(neighbor);
                edges.add((E) edge);
            });
        });
        return edges;
    }

    private Node getNode(int index) {
        return (Node) graph[index];
    }

    private boolean isConnected(int from, int to) {
        List<V> neighbors = getAdjacentVertices(from);
        boolean isConnected = false;
        for (V neighbor : neighbors) {
            if (to == neighbor.getIndex()) {
                isConnected = true;
                break;
            }
        }
        return isConnected;
    }

    private class Node {
        V vertex;
        LinkedList<V> adjacencyList;

        public Node(V vertex, LinkedList<V> adjacencyList) {
            this.vertex = vertex;
            this.adjacencyList = adjacencyList;
        }
    }

}
