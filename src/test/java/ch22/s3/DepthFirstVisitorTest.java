package ch22.s3;

import ch22.s2.BreadthFirstVisitor;
import common.GraphVisitorTest;
import model.graphs.Edge;
import model.graphs.Vertex;
import services.GraphVisitor;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstVisitorTest extends GraphVisitorTest {

    @Override
    protected GraphVisitor<Vertex, Edge> getGraphVisitor() {
        return new DepthFirstVisitor<>();
    }

    @Override
    protected List<Integer> getExpectedIndexSequence() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(1);
        expected.add(5);
        expected.add(2);
        expected.add(7);
        expected.add(6);
        expected.add(3);
        expected.add(0);

        return expected;
    }
}
