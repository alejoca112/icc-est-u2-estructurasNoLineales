package trees;

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
        System.out.print(node.getValue() + " ");
        inOrderRecursive(node.getRight());
    }

    public int size() {
        return this.size;
    }

}
