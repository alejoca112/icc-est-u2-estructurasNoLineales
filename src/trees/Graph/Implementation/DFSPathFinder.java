package trees.Graph.Implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nodes.Node;
import trees.Graph.Graphs;
import trees.Graph.PathFinder;
import trees.Graph.PathResult;

public class DFSPathFinder<T> implements PathFinder<T> {

    @Override
    public PathResult<T> find(Graphs<T> graph, Node<T> start, Node<T> end) {
        /// iniciales
        List<Node<T>> visitados = new ArrayList<>();
        Set<Node<T>> setVisited = new HashSet<>();
        List<Node<T>> path = new ArrayList<>();
        
        findRecursive(graph, start, end, visitados, setVisited, path);
        return new PathResult<>(visitados, path);
    }

    private boolean findRecursive(Graphs<T> graph, Node<T> current, Node<T> end, List<Node<T>> visitados, Set<Node<T>> setVisited, List<Node<T>> path) {
        setVisited.add(current);
        visitados.add(current);
        path.add(current);

        if(current.equals(end)) {
            return true;
        }

        for(Node<T> neighbor : graph.getNeighbors(current)) {
            if(!setVisited.contains(neighbor)) {
                if(findRecursive(graph, neighbor, end, visitados, setVisited, path)) {
                    return true;
                }
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
}