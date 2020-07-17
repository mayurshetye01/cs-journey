package ch22.s4;

import ch22.s3.DepthFirstVisitor;
import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;
import services.GraphSorter;
import services.GraphVisitor;

import java.util.List;

import static ch22.GraphProperties.FINISH;

/*
 * The TopologicalSorter works only for a Directed Acyclic Graph (DAG)
 * Returns list of vertices with DECREASING order of finish time
 * i.e The vertex which finishes last is returned first
 * @param <V>
 * @param <E>
 */
public class TopologicalSorter<V extends Vertex, E extends Edge> implements GraphSorter<V, E> {
    @Override
    public List<V> sort(Graph<V, E> graph) {
        final GraphVisitor<V, E> visitor = new DepthFirstVisitor<>();
        Graph<V, E> result = visitor.visit(graph);

        List<V> vertices = result.getVertices();

        vertices.sort((first, second) -> {
            Object firstFinishTime = first.getProperty(FINISH);
            Object secondFinishTime = second.getProperty(FINISH);

            if (firstFinishTime == null || secondFinishTime == null)
                throw new RuntimeException("Finish time not calculated for vertex");

            //Return vertices in REVERSE order of finish time
            return ((Integer) firstFinishTime).compareTo((Integer) secondFinishTime) * -1;
        });

        return vertices;
    }
}
