package ch22.s2;

import ch22.SampleGraphs;
import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;
import org.junit.jupiter.api.Test;
import services.GraphVisitor;

import static ch22.GraphProperties.DISTANCE;
import static ch22.GraphProperties.PARENT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreadthFirstVisitorTest {

    private final GraphVisitor<Vertex, Edge> visitor = new BreadthFirstVisitor<>();

    @Test
    void testDirectedGraph() {
        final Graph<Vertex, Edge> graph = SampleGraphs.directed();
        final Graph<Vertex, Edge> result = visitor.visit(graph, 0);

        assertEquals(result.getVertex(0).getProperty(DISTANCE), 0);
        assertEquals(result.getVertex(1).getProperty(DISTANCE), 1);
        assertEquals(result.getVertex(2).getProperty(DISTANCE), 2);
        assertEquals(result.getVertex(3).getProperty(DISTANCE), 1);
        assertEquals(result.getVertex(4).getProperty(DISTANCE), Integer.MAX_VALUE);
        assertEquals(result.getVertex(5).getProperty(DISTANCE), Integer.MAX_VALUE);
        assertEquals(result.getVertex(0).getProperty(PARENT), null);
        assertEquals(result.getVertex(1).getProperty(PARENT), result.getVertex(0));
        assertEquals(result.getVertex(2).getProperty(PARENT), result.getVertex(3));
        assertEquals(result.getVertex(3).getProperty(PARENT), result.getVertex(0));
        assertEquals(result.getVertex(4).getProperty(PARENT), null);
        assertEquals(result.getVertex(5).getProperty(PARENT), null);
    }

    @Test
    void testUndirectedGraph() {
        final Graph<Vertex, Edge> graph = SampleGraphs.undirected();
        final Graph<Vertex, Edge> result = visitor.visit(graph, 0);

        assertEquals(result.getVertex(0).getProperty(DISTANCE), 0);
        assertEquals(result.getVertex(1).getProperty(DISTANCE), 1);
        assertEquals(result.getVertex(2).getProperty(DISTANCE), 1);
        assertEquals(result.getVertex(3).getProperty(DISTANCE), 1);
        assertEquals(result.getVertex(4).getProperty(DISTANCE), 2);
        assertEquals(result.getVertex(5).getProperty(DISTANCE), 2);
        assertEquals(result.getVertex(0).getProperty(PARENT), null);
        assertEquals(result.getVertex(1).getProperty(PARENT), result.getVertex(0));
        assertEquals(result.getVertex(2).getProperty(PARENT), result.getVertex(0));
        assertEquals(result.getVertex(3).getProperty(PARENT), result.getVertex(0));
        assertEquals(result.getVertex(4).getProperty(PARENT), result.getVertex(3));
        assertEquals(result.getVertex(5).getProperty(PARENT), result.getVertex(1));
    }

}
