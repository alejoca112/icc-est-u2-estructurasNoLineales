package trees.Graph.Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import nodes.Node;
import trees.Graph.Graphs;
import trees.Graph.PathFinder;
import trees.Graph.PathResult;

public class BFSPathFinder<T> implements PathFinder<T> {
    @Override
    public PathResult<T> find(Graphs<T> graph, Node<T> start, Node<T> end) {
        Queue<Node<T>> queue = new LinkedList<>();
        Set<Node<T>> visitados = new HashSet<>();

        Map<Node<T>, Node<T>> parentMap = new HashMap<>();
        List<Node<T>> visit = new ArrayList<>();

        queue.add(start);
        visitados.add(start);

        parentMap.put(start, null);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            // Imprimir
            visit.add(current);

            if (current.equals(end)) {
                return new PathResult<>(visit, buildPath(parentMap, start, end));
            }

            for (Node<T> neighbor : graph.getNeighbors(current)) {
                if (!visitados.contains(neighbor)) {
                    queue.add(neighbor);
                    visitados.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }
    }

    private List<Node<T>> buildPath(Map<Node<T>, Node<T>> parentMap, Node<T> start, Node<T> end) {
        List<Node<T>> path = new ArrayList<>();
        for (Node<T> node = end; node != null; node = parentMap.get(node)) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }
}
