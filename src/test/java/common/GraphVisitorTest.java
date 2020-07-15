package common;

import ch22.SampleGraphs;
import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;
import org.junit.jupiter.api.Test;
import services.GraphVisitor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class GraphVisitorTest {
    protected abstract GraphVisitor<Vertex, Edge> getGraphVisitor();

    protected abstract List<Integer> getExpectedIndexSequence();

    @Test
    void visitAdjacencyListGraph(){
        Graph<Vertex, Edge> graph = SampleGraphs.getUndirectedAdjacencyListGraph();
        testVisit(graph);
    }

    @Test
    void visitAdjacencyMatrixGraph(){
        Graph<Vertex, Edge> graph = SampleGraphs.getUndirectedAdjacencyMatrixGraph();
        testVisit(graph);
    }

    private void testVisit(Graph<Vertex,Edge> graph){
        GraphVisitor<Vertex, Edge> graphVisitor = getGraphVisitor();
        List<Vertex> result = graphVisitor.visit(graph, graph.getVertex(0));

        List<Integer> expectedIndexSequence = getExpectedIndexSequence();

        List<Vertex> expected = new ArrayList<>();

        expectedIndexSequence.forEach(index -> expected.add(graph.getVertex(index)));

        assertEquals(expected, result);
    }
}
