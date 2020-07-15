package ch22.s2;

import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;
import services.GraphVisitor;

import java.util.*;


public class BreadthFirstVisitor<V extends Vertex, E extends Edge> implements GraphVisitor<V, E> {

    @Override
    public List<V> visit(Graph<V, E> graph, V source) {
        Set<V> visited = new HashSet<>();

        Queue<V> queue = new LinkedList<>();
        queue.add(source);

        List<V> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            V vertex = queue.poll();

            if (!visited.contains(vertex)) {
                List<V> adjacentVertices = graph.getAdjacentVertices(vertex.getIndex());
                if (adjacentVertices != null && !adjacentVertices.isEmpty())
                    queue.addAll(adjacentVertices);
                visited.add(vertex);
                result.add(vertex);
            }
        }

        return result;
    }
}
