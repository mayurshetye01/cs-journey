package test.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Edge edge1 = new Edge(v3,v2);
        Edge edge2 = new Edge(v3,v0);
        Edge edge3 = new Edge(v2,v0);
        Edge edge4 = new Edge(v2,v1);
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);

        List<Vertex> vertices = TopologicalSort.sort(edges);
        for (Vertex vertex : vertices) {
            System.out.print(vertex.value + ",");
        }
    }

    private static List<Vertex> sort(final List<Edge> edges) {
        // Build adjacency list and in-degree map
        Map<Vertex,List<Vertex>> adjacencyList = new HashMap<>();
        Map<Vertex,Integer> inDegreeMap = new HashMap<>();

        for(Edge edge: edges){
            if(adjacencyList.containsKey(edge.start))
                adjacencyList.get(edge.start).add(edge.end);
            else{
                List<Vertex> neighbors = new ArrayList<>();
                neighbors.add(edge.end);
                adjacencyList.put(edge.start, neighbors);
            }

            if(inDegreeMap.containsKey(edge.end))
                inDegreeMap.put(edge.end, inDegreeMap.get(edge.end) + 1);
            else
                inDegreeMap.put(edge.end,1);
        }

        //Add the sources to queue
        Queue<Vertex> queue = new LinkedList<>();
        for(Map.Entry<Vertex,List<Vertex>> entry : adjacencyList.entrySet()){
            Vertex curr = entry.getKey();
            if(isSource(curr, inDegreeMap)){
                queue.add(curr);
            }
        }

        //
        List<Vertex> sortedList = new ArrayList<>();
        while (!queue.isEmpty()){
            Vertex curr = queue.poll();
            sortedList.add(curr);
            List<Vertex> neighbors = adjacencyList.get(curr) == null ? new ArrayList<>() : adjacencyList.get(curr);
            for(Vertex neighbor : neighbors){
                int currInDegree = inDegreeMap.get(neighbor);
                int newInDegree = currInDegree - 1;
                inDegreeMap.put(neighbor, newInDegree);
                if(newInDegree == 0)
                    queue.add(neighbor);
            }
        }

        return sortedList;

    }

    private static boolean isSource(Vertex vertex, Map<Vertex,Integer> inDegreeMap){
        return  !inDegreeMap.containsKey(vertex) || inDegreeMap.get(vertex) == 0;
    }


    private static class Vertex {
        int value;
        public Vertex(int value){
            this.value = value;
        }
    }

    private static class Edge {
        Vertex start;
        Vertex end;

        public Edge(Vertex start, Vertex end){
            this.start = start;
            this.end = end;
        }
    }
}
