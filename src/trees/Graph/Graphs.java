package trees.Graph;

import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import nodes.Node;

public class Graphs<T> {

    // 1- primera forma
    List<Node<T>> nodes;

    //2da forma
    private Map<Node<T>, List<Node<T>>> mapas;

    public Graphs() {
        this.mapas = new LinkedHashMap<Node<T>, List<Node<T>>>();
    }

    public void insertNode(T value){
        Node<T> newNode = new Node<T>(value);
        this.nodes.add(newNode);
    }

    public void addNode(Node<T> node){
        mapas.putIfAbsent(node, new ArrayList<>());
    }

    //Grafo no dirigido
    public void addEdge(Node<T> node1, Node<T> node2){
        addNode(node1);
        addNode(node2);
        mapas.get(node1).add(node2);
        mapas.get(node2).add(node1);
    }

    public void removeNode(Node<T> node){
        mapas.remove(node);
    }

    public void printGraph(){
        for (Map.Entry<Node<T>, List<Node<T>>> entry : mapas.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for(Node<T> neighbor : entry.getValue()){
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public List<Node<T>> getNeighbors(Node<T> node){
        //return mapas.get(node);     //Puede ocurrir errores si el nodo no existe, por eso se usa getOrDefault 
        return mapas.getOrDefault(node,List.of());
    }

    //Grafo dirigido
    public void addDirectedEdge(Node<T> n1, Node<T> n2){
        addNode(n1);
        addNode(n2);
        mapas.get(n1).add(n2);
    }

    public void bfs(Node<T> start){
        Set<Node<T>> visited = new LinkedHashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while(!queue.isEmpty()){
            Node<T> current = queue.poll();
            System.out.println(current.getValue() + " ");

            for(Node<T> neighbor: getNeighbors(current)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public void dfs(Node<T> start){
        Set<Node<T>> visited = new LinkedHashSet<>();
        dfsRecursive(start, visited);
    }
    private void dfsRecursive(Node<T> current, Set<Node<T>> visited){
        // -> current -> 23 | visited -> (23)
        visited.add(current);
        System.out.println(current.getValue() + " ");
        for(Node<T> neighbor: getNeighbors(current)){
            if(!visited.contains(neighbor)){
                // -> current -> 23 | visited -> (23)
                dfsRecursive(neighbor, visited);
            }
        }
    }


    
}
