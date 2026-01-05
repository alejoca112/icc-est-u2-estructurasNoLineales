
import trees.IntTree;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Estudiante: Geovanny Cabrera");
        runIntTree();

    }
    private static void runIntTree(){
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
        System.out.println("\nSize: ");
        tree.size();
        
    }
}
