package ch22;

import ch22.s1.AdjacencyListGraph;
import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;

public class SampleGraphs {

    public static Graph<Vertex, Edge> undirected() {
        final Graph<Vertex, Edge> graph = new AdjacencyListGraph<>(6);
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        graph.connect(v0, v1);
        graph.connect(v0, v2);
        graph.connect(v0, v3);
        graph.connect(v1, v0);
        graph.connect(v1, v2);
        graph.connect(v1, v5);
        graph.connect(v2, v0);
        graph.connect(v2, v1);
        graph.connect(v2, v3);
        graph.connect(v3, v0);
        graph.connect(v3, v2);
        graph.connect(v3, v4);
        graph.connect(v4, v3);
        graph.connect(v4, v5);
        graph.connect(v5, v4);
        graph.connect(v5, v1);
        return graph;
    }

    public static Graph<Vertex, Edge> directed() {
        final Graph<Vertex, Edge> graph = new AdjacencyListGraph<>(6);
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        graph.connect(v0, v1);
        graph.connect(v0, v3);
        graph.connect(v1, v3);
        graph.connect(v2, v0);
        graph.connect(v3, v2);
        graph.connect(v4, v5);
        return graph;
    }
}
