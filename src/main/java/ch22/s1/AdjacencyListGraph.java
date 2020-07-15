package ch22.s1;

import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;

import java.util.*;

public class AdjacencyListGraph<V extends Vertex, E extends Edge> implements Graph<V, E> {
    final private List<V> vertices = new ArrayList<>();
    //Index based i.e vertex at index 0 has adjacencyList at 0 index
    final private List<LinkedList<V>> adjacencyLists = new ArrayList<>();

    @Override
    public void add(V vertex) {
        vertices.add(vertex);
        adjacencyLists.add(vertex.getIndex(), new LinkedList<>());
    }

    @Override
    public void delete(int index) {
        vertices.forEach(vertex -> {
            deleteEdge(vertex.getIndex(), index);
            deleteEdge(index, vertex.getIndex());
        });
        vertices.remove(index);
        adjacencyLists.remove(index);
    }

    @Override
    public void connect(V from, V to) {
        adjacencyLists.get(from.getIndex()).add(to);
    }

    @Override
    public void disconnect(V from, V to) {
        adjacencyLists.get(from.getIndex()).remove(to);
    }

    @Override
    public void deleteEdge(int from, int to) {
        V fromVertex = vertices.get(from);
        V toVertex = vertices.get(to);

        disconnect(fromVertex, toVertex);
    }

    @Override
    public V getVertex(int index) {
        return vertices.get(index);
    }

    @Override
    public E getEdge(int from, int to) {
        Edge edge = null;
        if (isConnected(from, to)) {
            edge = new Edge();
            edge.setFrom(vertices.get(from));
            edge.setTo(vertices.get(to));
        }
        return (E) edge;
    }

    @Override
    public List<V> getVertices() {
        return vertices;
    }

    @Override
    public List<V> getAdjacentVertices(int index) {
        return adjacencyLists.get(index);
    }

    @Override
    public List<E> getEdges() {
        final List<E> edges = new ArrayList<>();
        vertices.forEach(vertex -> {
            LinkedList<V> neighbors = adjacencyLists.get(vertex.getIndex());
            neighbors.forEach(neighbor -> {
                Edge edge = new Edge();
                edge.setFrom(vertex);
                edge.setTo(neighbor);
                edges.add((E) edge);
            });
        });
        return edges;
    }

    private boolean isConnected(int vertex1, int vertex2) {
        LinkedList<V> neighbors = adjacencyLists.get(vertex1);
        boolean isConnected = false;
        for (V neighbor : neighbors) {
            if (vertex2 == neighbor.getIndex()) {
                isConnected = true;
                break;
            }
        }
        return isConnected;
    }

}
