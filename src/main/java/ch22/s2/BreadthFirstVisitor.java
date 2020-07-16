package ch22.s2;

import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;
import services.GraphVisitor;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static ch22.GraphColor.*;
import static ch22.GraphProperties.*;

//Should ideally make a copy of graph instead of modifying input

public class BreadthFirstVisitor<V extends Vertex, E extends Edge> implements GraphVisitor<V, E> {

    @Override
    public Graph<V, E> visit(Graph<V, E> graph) {
        initialize(graph);

        List<V> vertices = graph.getVertices();
        vertices.forEach(vertex -> {
            if (WHITE.equals(vertex.getProperty(COLOR)))
                visitSubGraph(graph, vertex);
        });

        return graph;
    }

    @Override
    public Graph<V, E> visit(Graph<V, E> graph, int startIndex) {
        initialize(graph);
        V source = initializeSource(graph.getVertex(startIndex));
        visitSubGraph(graph, source);

        return graph;
    }

    private void visitSubGraph(Graph<V, E> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            V vertex = queue.poll();

            List<V> neighbors = graph.getAdjacentVertices(vertex.getIndex());
            neighbors.forEach(neighbor -> {
                if (WHITE.equals(neighbor.getProperty(COLOR))) {
                    neighbor.setProperty(COLOR, GRAY);
                    neighbor.setProperty(DISTANCE, (Integer) vertex.getProperty(DISTANCE) + 1);
                    neighbor.setProperty(PARENT, vertex);
                    queue.add(neighbor);
                }
            });

            vertex.setProperty(COLOR, BLACK);
        }
    }

    private void initialize(Graph<V, E> graph) {
        List<V> vertices = graph.getVertices();
        vertices.forEach(vertex -> {
            vertex.setProperty(COLOR, WHITE);
            vertex.setProperty(PARENT, null);
            vertex.setProperty(DISTANCE, Integer.MAX_VALUE);
        });
    }

    private V initializeSource(V vertex) {
        vertex.setProperty(COLOR, GRAY);
        vertex.setProperty(DISTANCE, 0);

        return vertex;
    }

}
