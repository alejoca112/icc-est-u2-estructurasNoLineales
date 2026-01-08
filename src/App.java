import models.Persona;
import nodes.Node;
import trees.IntTree;
import trees.Tree;
import trees.Graph.Graphs;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Estudiante: Geovanny Cabrera");
        runIntTree();
        runTree();
        runGraph();
    }

    private static void runIntTree() {
        IntTree tree = new IntTree();

        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(15);
        System.out.println("PreOrder");
        tree.preOrder();
        System.out.println("\nPosOrder");
        tree.posOrder();
        System.out.println("\nInOrder");
        tree.inOrder();
        System.out.println("\nSize: " + tree.size());
    }

    private static void runTree() {
        Tree<Persona> tree = new Tree<Persona>();

        tree.insert(new Persona("Pablo", 21));
        tree.insert(new Persona("Maria", 23));
        tree.insert(new Persona("Ana", 25));
        tree.insert(new Persona("Pedro", 23));
        tree.insert(new Persona("Luis", 19));
        System.out.println("PreOrder");
        tree.preOrder();
        System.out.println("\nPosOrder");
        tree.posOrder();
        System.out.println("\nInOrder");
        tree.inOrder();
        // System.out.println("\nSize: " + tree.size());

        // Modificación para imprimir la búsqueda
        Persona encontrada = tree.searchByAge(23);
        if (encontrada != null) {
            System.out.println("\nPersona encontrada: " + encontrada);
        } else {
            System.out.println("\nPersona no encontrada con esa edad.");
        }
    }

    public static void runGraph(){
        Graphs<String> graph = new Graphs<String>();

        Node<String> node1 = new Node<String>("A");
        Node<String> node2 = new Node<String>("B");
        Node<String> node3 = new Node<String>("C");
        Node<String> node4 = new Node<String>("D");

        graph.addNode(node1);
        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node2, node4);
        graph.addEdge(node3, node4);

        graph.printGraph();

        List<Node<String>> neighbors = graph.getNeighbors(node1);
        System.out.print("Neighbors de A: ");
        for(Node<String> neighbor : neighbors){
            System.out.print(neighbor + " ");
        }
        System.out.println();
    }
}
