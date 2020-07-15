package ch22;

import ch22.s1.AdjacencyListGraph;
import ch22.s1.AdjacencyMatrixGraph;
import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;

public class SampleGraphs {

    public static AdjacencyListGraph<Vertex, Edge> getUndirectedAdjacencyListGraph() {
        AdjacencyListGraph<Vertex, Edge> adjacencyListGraph = new AdjacencyListGraph<>();
        buildGraph(adjacencyListGraph);
        return adjacencyListGraph;
    }

    public static AdjacencyMatrixGraph<Vertex, Edge> getUndirectedAdjacencyMatrixGraph() {
        AdjacencyMatrixGraph<Vertex, Edge> adjacencyMatrixGraph = new AdjacencyMatrixGraph<>(8);
        buildGraph(adjacencyMatrixGraph);
        return adjacencyMatrixGraph;
    }

    private static void buildGraph(Graph<Vertex, Edge> graph) {
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);

        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);
        graph.add(v6);
        graph.add(v7);

        addUndirectedEdge(v0, v1, graph);
        addUndirectedEdge(v0, v2, graph);
        addUndirectedEdge(v0, v3, graph);
        addUndirectedEdge(v1, v4, graph);
        addUndirectedEdge(v2, v5, graph);
        addUndirectedEdge(v3, v6, graph);
        addUndirectedEdge(v6, v7, graph);
    }

    private static void addUndirectedEdge(Vertex from, Vertex to, Graph graph) {
        graph.connect(from, to);
        graph.connect(to, from);
    }
}
