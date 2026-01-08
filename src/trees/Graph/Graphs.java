package trees.Graph;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        return mapas.get(node);
    }


    
}
