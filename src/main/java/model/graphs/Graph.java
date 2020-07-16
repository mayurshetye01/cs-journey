package model.graphs;

import java.util.List;

public interface Graph<V extends Vertex, E extends Edge> {

    void add(V vertex);

    void delete(int index);

    void connect(V from, V to);

    void disconnect(V from, V to);

    V getVertex(int index);

    E getEdge(int from, int to);

    List<V> getVertices();

    List<V> getAdjacentVertices(int index);

    List<E> getEdges();
}
