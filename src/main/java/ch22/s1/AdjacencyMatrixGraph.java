package ch22.s1;

import model.graphs.Edge;
import model.graphs.Graph;
import model.graphs.Vertex;

import java.util.ArrayList;
import java.util.List;

/***
 * This needs a LOT of refactoring and preferably all together new design
 * @param <V>
 * @param <E>
 */
public class AdjacencyMatrixGraph<V extends Vertex, E extends Edge> implements Graph<V, E> {

    private final Integer[][] matrix;
    private final int CONNECTED = 1;
    private final int DISCONNECTED = 0;
    private final int EMPTY = Integer.MIN_VALUE;
    private final int NON_EMPTY = Integer.MAX_VALUE;

    public AdjacencyMatrixGraph(int capacity) {
        matrix = new Integer[capacity][capacity];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = EMPTY;
            }
        }
    }

    @Override
    public void add(V vertex) {
        //The matrix diagonal represents the vertices
        int index = vertex.getIndex();
        matrix[index][index] = NON_EMPTY;
    }

    @Override
    public void delete(int index) {
        matrix[index][index] = EMPTY;
    }

    @Override
    public void connect(V from, V to) {
        matrix[from.getIndex()][to.getIndex()] = CONNECTED;
    }

    @Override
    public void disconnect(V from, V to) {
        matrix[from.getIndex()][to.getIndex()] = DISCONNECTED;
    }

    @Override
    public void deleteEdge(int from, int to) {
        matrix[from][to] = DISCONNECTED;
    }

    @Override
    public V getVertex(int index) {
        Vertex vertex = null;
        if (matrix[index][index] == NON_EMPTY) {
            vertex = new Vertex();
            vertex.setIndex(index);
        }
        return (V) vertex;
    }

    @Override
    public E getEdge(int from, int to) {
        Edge edge = null;
        if (isConnected(from, to)) {
            V fromVertex = getVertex(from);
            V toVertex = getVertex(to);
            edge = new Edge();
            edge.setFrom(fromVertex);
            edge.setTo(toVertex);
        }
        return (E) edge;
    }

    @Override
    public List<V> getVertices() {
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            V vertex = getVertex(i);
            if (vertex != null)
                vertices.add(vertex);
        }
        return vertices;
    }

    @Override
    public List<V> getAdjacentVertices(int index) {
        List<V> adjacentVertices = new ArrayList<>();
        V current = getVertex(index);

        if (current != null) {
            for (int i = 0; i < matrix.length; i++) {
                if (isConnected(index, i))
                    adjacentVertices.add(getVertex(i));
            }
        }
        return adjacentVertices;
    }

    @Override
    public List<E> getEdges() {
        List<E> edges = new ArrayList<>();

        for(int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix.length; col++){
                    E edge = getEdge(row, col);
                    if(edge != null)
                        edges.add(edge);
            }
        }

        return edges;
    }

    private boolean isConnected(int from, int to) {
        return matrix[from][to] == CONNECTED;
    }
}
