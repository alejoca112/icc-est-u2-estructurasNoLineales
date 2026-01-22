package trees.Graph;

import nodes.Node;
import trees.Graph.PathResult;

public interface PathFinder<T> {
    PathResult<T> find(Graphs<T> graph, Node<T> start, Node<T> end);
}
