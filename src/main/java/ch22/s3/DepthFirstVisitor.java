package ch22.s3;

import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;
import services.GraphVisitor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static ch22.GraphColor.*;
import static ch22.GraphProperties.*;

public class DepthFirstVisitor<V extends Vertex, E extends Edge> implements GraphVisitor<V, E> {

    @Override
    public Graph<V, E> visit(Graph<V, E> graph) {
        initialize(graph);
        AtomicInteger time = new AtomicInteger(0);

        List<V> vertices = graph.getVertices();
        vertices.forEach(vertex -> {
            if (WHITE.equals(vertex.getProperty(COLOR)))
                dfsVisit(graph, vertex, time);
        });

        return graph;
    }

    @Override
    public Graph<V, E> visit(Graph<V, E> graph, int startIndex) {
        initialize(graph);
        V source = graph.getVertex(startIndex);
        AtomicInteger time = new AtomicInteger(0);
        dfsVisit(graph, source, time);

        return graph;
    }

    private void dfsVisit(Graph<V, E> graph, V vertex, AtomicInteger time) {
        vertex.setProperty(DISCOVERY, time.incrementAndGet());
        vertex.setProperty(COLOR, GRAY);
        List<V> neighbors = graph.getAdjacentVertices(vertex.getIndex());
        neighbors.forEach(neighbor -> {
            if (WHITE.equals(neighbor.getProperty(COLOR))) {
                neighbor.setProperty(PARENT, vertex);
                dfsVisit(graph, neighbor, time);
            }
        });

        vertex.setProperty(COLOR, BLACK);
        vertex.setProperty(FINISH, time.incrementAndGet());
    }

    private void initialize(Graph<V, E> graph) {
        List<V> vertices = graph.getVertices();
        vertices.forEach(vertex -> {
            vertex.setProperty(COLOR, WHITE);
            vertex.setProperty(PARENT, null);
        });
    }
}
