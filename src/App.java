import models.Persona;
import trees.IntTree;
import trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Estudiante: Geovanny Cabrera");
        runIntTree();
        runTree();
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
}
