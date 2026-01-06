package trees;

import models.Persona;
import nodes.Node;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    public Tree() {
        this.root = null;
    }

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            size++;
            return new Node<>(value);
        }

        // Inserta Nodos de izquierda a derecha
        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
            // Usar else if porque no se puede insertar nodos duplicados
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }
        return current;
    }

    public void preOrder() {
        preOrderRecursive(root);
    }

    private void preOrderRecursive(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preOrderRecursive(node.getLeft());
        preOrderRecursive(node.getRight());
    }

    public void posOrder() {
        posOrderRecursive(root);
    }

    private void posOrderRecursive(Node<T> node) {
        if (node == null) {
            return;
        }
        posOrderRecursive(node.getLeft());
        posOrderRecursive(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<T> node) {
        if (node == null) {
            return;
        }
        inOrderRecursive(node.getLeft());
        System.out.println(node.getValue() + " ");
        inOrderRecursive(node.getRight());
    }

    public int size() {
        return this.size;
    }

    public T search (T value){
        return searchRecursive(root, value);
    }

    private T searchRecursive(Node<T> current, T value){
        if (current == null) {
            return null;
        }
        if (value.compareTo(current.getValue()) < 0) {
            return searchRecursive(current.getLeft(), value);
        } else if (value.compareTo(current.getValue()) > 0) {
            return searchRecursive(current.getRight(), value);
        }
        return current.getValue();
    }
    public T searchByAge(int edad) {
        return searchByAgeRecursive(root, edad);
    }

    private T searchByAgeRecursive(Node<T> current, int edad) {
        if (current == null) {
            return null;
        }
        Persona persona = (Persona) current.getValue();
        if(persona.getEdad() == edad){
            return current.getValue();
        }
        if(persona.getEdad() > edad){
            return searchByAgeRecursive(current.getLeft(), edad);
        } else {
            return searchByAgeRecursive(current.getRight(), edad);
        }
    }
}