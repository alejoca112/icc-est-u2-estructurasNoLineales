import models.Persona;
import nodes.Node;
import trees.IntTree;
import trees.Tree;
import trees.Graph.Graphs;
import trees.Graph.PathFinder;
import trees.Graph.PathResult;
import trees.Graph.Implementation.BFSPathFinder;
import trees.Graph.Implementation.DFSPathFinder;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Estudiante: Geovanny Cabrera");
        System.out.println("\nCorrer IntTree");
        runIntTree();
        System.out.println("\nCorrer RunTree");
        runTree();
        System.out.println("\nCorrer RunGraph");
        //runGraph();
        System.out.println("\nCorrer Recorridos De RunGraph");
        runGraphRecorridos();
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

    public static void runGraph() {
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

        List<Node<String>> neighbors = graph.getNeighbors(node1); // Lista para conocer los nodos(neighbors)
        System.out.print("Neighbors de A: ");
        for (Node<String> neighbor : neighbors) {
            System.out.print(neighbor + " ");
        }
        System.out.println();
    }

    public static void runGraphRecorridos() {
        Graphs<Persona> grafo = new Graphs<Persona>();
        Persona pC23 = new Persona("Carlos", 23);
        Persona pL18 = new Persona("Luis", 18);
        Persona pA23 = new Persona("Andres", 23);
        Persona pA30 = new Persona("Ana", 30);
        Persona pJ25 = new Persona("Juan", 25);
        Persona pAn20 = new Persona("Ana", 20);
        Persona pM10 = new Persona("Mateo", 10);
        Persona pJ10 = new Persona("Julio", 10);

        grafo.addEdge(new Node<>(pC23), new Node<>(pA30));
        grafo.addDirectedEdge(new Node<>(pC23), new Node<>(pL18));
        grafo.addDirectedEdge(new Node<>(pC23), new Node<>(pA23));
        grafo.addDirectedEdge(new Node<>(pL18), new Node<>(pJ25));
        grafo.addEdge(new Node<>(pL18), new Node<>(pA23));
        grafo.addDirectedEdge(new Node<>(pAn20), new Node<>(pA30));
        grafo.addEdge(new Node<>(pA30), new Node<>(pM10));
        grafo.addEdge(new Node<>(pM10), new Node<>(pJ10));

        grafo.printGraph();
        System.out.println("\nBFS");
        grafo.bfs(new Node<>(pC23));
        System.out.println("\nDFS");
        grafo.dfs(new Node<>(pC23));

        System.out.println("\nBFS");
        grafo.bfs(new Node<>(pAn20));
        System.out.println("\nDFS");
        grafo.dfs(new Node<>(pAn20));


        PathFinder<Persona> finder = new BFSPathFinder<>();
        PathResult<Persona> result = finder.find(grafo, new Node<>(pC23), new Node<>(pJ10));

        System.out.println("\nOrden BFS");
        result.getVisitados().forEach(node -> System.out.println(node.getValue() + " "));

        System.out.println("\nRuta Encontrada");
        result.getPath().forEach(node -> System.out.println(node.getValue() + " "));
        
        PathFinder<Persona> finderDFS = new DFSPathFinder<>();
        PathResult<Persona> resultDFS = finderDFS.find(grafo, new Node<>(pC23), new Node<>(pJ10));

        System.out.println("\nOrden DFS");
        resultDFS.getVisitados().forEach(node -> System.out.println(node.getValue() + " "));

        System.out.println("\nRuta Encontrada");
        resultDFS.getPath().forEach(node -> System.out.println(node.getValue() + " "));

    }
    

}
