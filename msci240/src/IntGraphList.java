

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class IntGraphList {
    private Map<Integer, LinkedList<Integer>> adjacencyList;

    public IntGraphList() {
        adjacencyList = new TreeMap<Integer, LinkedList<Integer>>();
    }

    // precondition: value has not been added before
    public void addVertex(int value) {
        adjacencyList.put(value, new LinkedList<Integer>());
    }

    // precondition: first and second must already be added as vertices
    public void addEdge(int first, int second) {
        checkVertex(first);
        checkVertex(second);
        adjacencyList.get(first).add(second);
        adjacencyList.get(second).add(first);
    }

    public int getNumVertices() {
        return adjacencyList.size();
    }

    public List<Integer> getAdjacencyList(int v) {
        checkVertex(v);
        return Collections.unmodifiableList(adjacencyList.get(v));
    }

    public Set<Integer> getVertices() {
        return Collections.unmodifiableSet(adjacencyList.keySet());
    }

    public boolean hasVertex(int v) {
        return adjacencyList.containsKey(v);
    }

    private void checkVertex(int v) {
        if (!adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("vertex " + v + " is not in the graph");
        }
    }
}