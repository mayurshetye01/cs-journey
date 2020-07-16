package ch22.s3;

import ch22.SampleGraphs;
import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;
import org.junit.jupiter.api.Test;
import services.GraphVisitor;

import static ch22.GraphProperties.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepthFirstVisitorTest {

    private final GraphVisitor<Vertex, Edge> visitor = new DepthFirstVisitor<>();

    @Test
    void testDirected() {
        final Graph<Vertex, Edge> graph = SampleGraphs.directed();
        final Graph<Vertex, Edge> result = visitor.visit(graph);

        assertEquals(result.getVertex(2).getProperty(DISCOVERY), 4);
        assertEquals(result.getVertex(3).getProperty(DISCOVERY), 3);
        assertEquals(result.getVertex(4).getProperty(DISCOVERY), 9);
        assertEquals(result.getVertex(5).getProperty(DISCOVERY), 10);
        assertEquals(result.getVertex(0).getProperty(FINISH), 8);
        assertEquals(result.getVertex(1).getProperty(FINISH), 7);
        assertEquals(result.getVertex(2).getProperty(FINISH), 5);
        assertEquals(result.getVertex(3).getProperty(FINISH), 6);
        assertEquals(result.getVertex(4).getProperty(FINISH), 12);
        assertEquals(result.getVertex(5).getProperty(FINISH), 11);
        assertEquals(result.getVertex(0).getProperty(PARENT), null);
        assertEquals(result.getVertex(1).getProperty(PARENT), result.getVertex(0));
        assertEquals(result.getVertex(2).getProperty(PARENT), result.getVertex(3));
        assertEquals(result.getVertex(3).getProperty(PARENT), result.getVertex(1));
        assertEquals(result.getVertex(4).getProperty(PARENT), null);
        assertEquals(result.getVertex(5).getProperty(PARENT), result.getVertex(4));
    }

    @Test
    void testUndirected() {
        final Graph<Vertex, Edge> graph = SampleGraphs.undirected();
        final Graph<Vertex, Edge> result = visitor.visit(graph);

        assertEquals(result.getVertex(0).getProperty(DISCOVERY), 1);
        assertEquals(result.getVertex(1).getProperty(DISCOVERY), 2);
        assertEquals(result.getVertex(2).getProperty(DISCOVERY), 3);
        assertEquals(result.getVertex(3).getProperty(DISCOVERY), 4);
        assertEquals(result.getVertex(4).getProperty(DISCOVERY), 5);
        assertEquals(result.getVertex(5).getProperty(DISCOVERY), 6);
        assertEquals(result.getVertex(0).getProperty(FINISH), 12);
        assertEquals(result.getVertex(1).getProperty(FINISH), 11);
        assertEquals(result.getVertex(2).getProperty(FINISH), 10);
        assertEquals(result.getVertex(3).getProperty(FINISH), 9);
        assertEquals(result.getVertex(4).getProperty(FINISH), 8);
        assertEquals(result.getVertex(5).getProperty(FINISH), 7);
        assertEquals(result.getVertex(0).getProperty(PARENT), null);
        assertEquals(result.getVertex(1).getProperty(PARENT), result.getVertex(0));
        assertEquals(result.getVertex(2).getProperty(PARENT), result.getVertex(1));
        assertEquals(result.getVertex(3).getProperty(PARENT), result.getVertex(2));
        assertEquals(result.getVertex(4).getProperty(PARENT), result.getVertex(3));
        assertEquals(result.getVertex(5).getProperty(PARENT), result.getVertex(4));

    }

}
