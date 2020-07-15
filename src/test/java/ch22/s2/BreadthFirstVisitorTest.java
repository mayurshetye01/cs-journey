package ch22.s2;

import common.GraphVisitorTest;
import model.graphs.Edge;
import model.graphs.Vertex;
import services.GraphVisitor;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstVisitorTest extends GraphVisitorTest {

    @Override
    protected GraphVisitor<Vertex, Edge> getGraphVisitor() {
        return new BreadthFirstVisitor<>();
    }

    @Override
    protected List<Integer> getExpectedIndexSequence() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);

        return expected;
    }
}
