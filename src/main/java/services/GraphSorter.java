package services;

import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;

import java.util.List;

public interface GraphSorter<V extends Vertex, E extends Edge> {
    List<V> sort(Graph<V, E> graph);
}
