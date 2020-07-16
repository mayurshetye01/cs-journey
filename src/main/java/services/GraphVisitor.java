package services;

import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;

public interface GraphVisitor<V extends Vertex, E extends Edge> {
    Graph<V, E> visit(Graph<V, E> graph);

    Graph<V, E> visit(Graph<V, E> graph, int startIndex);
}
