package ch22.s3;

import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;
import services.GraphVisitor;

import java.util.*;

public class DepthFirstVisitor<V extends Vertex, E extends Edge> implements GraphVisitor<V, E> {

    private static final String WHITE = "white";
    private static final String GRAY = "gray";
    private static final String BLACK = "black";

    @Override
    public List<V> visit(Graph<V, E> graph, V source) {
        Map<V, String> colors = new HashMap<>();
        List<V> result = new ArrayList<>();
        graph.getVertices().forEach(vertex -> {
            colors.put(vertex, WHITE);
        });

        dfsVisit(graph, source, colors, result);

        return result;
    }

    private void dfsVisit(Graph<V, E> graph, V source, Map<V, String> colors, List<V> result) {
        colors.put(source, GRAY);
        List<V> adjacentVertices = graph.getAdjacentVertices(source.getIndex());
        adjacentVertices.forEach(adjacentVertex -> {
            if (WHITE.equals(colors.get(adjacentVertex)))
                dfsVisit(graph, adjacentVertex, colors, result);
        });
        result.add(source);
        colors.put(source, BLACK);
    }
}
