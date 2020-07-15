package services;

import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;
import java.util.List;

public interface GraphVisitor<V extends Vertex, E extends Edge> {
    List<V> visit(Graph<V, E> graph, V source);
}
