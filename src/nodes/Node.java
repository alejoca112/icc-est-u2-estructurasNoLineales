package nodes;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    // Lista de los nodos conocidos
    private List<Node<T>> conocidos;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.conocidos = new ArrayList<Node<T>>();
    }

    public T getValue(){
        return value;
    }

    public Node<T> getLeft(){
        return left;
    }

    public Node<T> getRight(){
        return right;
    }

    public void setLeft(Node<T> left){
        this.left = left;
    }

    public void setRight(Node<T> right){
        this.right = right;
    }
}
