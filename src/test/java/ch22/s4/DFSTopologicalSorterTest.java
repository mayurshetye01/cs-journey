package ch22.s4;

import ch22.s1.AdjacencyListGraph;
import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;
import org.junit.jupiter.api.Test;
import services.TopologicalSorter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DFSTopologicalSorterTest {

    @Test
    void testTopologicalSort() {
        //Graph as per Pg No 613 of CLRS
        Graph<Vertex, Edge> graph = new AdjacencyListGraph<>(9);

        Vertex socks = new Vertex(0);
        Vertex undershorts = new Vertex(1);
        Vertex pants = new Vertex(2);
        Vertex shoes = new Vertex(3);
        Vertex watch = new Vertex(4);
        Vertex shirt = new Vertex(5);
        Vertex belt = new Vertex(6);
        Vertex tie = new Vertex(7);
        Vertex jacket = new Vertex(8);

        graph.add(socks);
        graph.add(undershorts);
        graph.add(pants);
        graph.add(shoes);
        graph.add(watch);
        graph.add(shirt);
        graph.add(belt);
        graph.add(tie);
        graph.add(jacket);

        graph.connect(socks, shoes);
        graph.connect(undershorts, pants);
        graph.connect(undershorts, shoes);
        graph.connect(pants, shoes);
        graph.connect(pants, belt);
        graph.connect(shirt, belt);
        graph.connect(shirt, tie);
        graph.connect(belt, jacket);
        graph.connect(tie, jacket);

        final TopologicalSorter<Vertex, Edge> sorter = new DFSTopologicalSorter<>();

        final List<Vertex> result = sorter.sort(graph);

        assertTrue(getPosition(socks, result) < getPosition(shoes, result));
        assertTrue(getPosition(undershorts, result) < getPosition(pants, result));
        assertTrue(getPosition(undershorts, result) < getPosition(shoes, result));
        assertTrue(getPosition(pants, result) < getPosition(shoes, result));
        assertTrue(getPosition(pants, result) < getPosition(belt, result));
        assertTrue(getPosition(shirt, result) < getPosition(belt, result));
        assertTrue(getPosition(shirt, result) < getPosition(tie, result));
        assertTrue(getPosition(tie, result) < getPosition(jacket, result));

    }

    private int getPosition(Vertex vertex, List<Vertex> result) {
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getIndex() == vertex.getIndex())
                return i;
        }
        return -1;
    }
}
