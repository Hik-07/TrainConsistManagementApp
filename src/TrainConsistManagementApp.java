import java.util.LinkedList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("UC4 - Maintain Ordered Train Consist");
        System.out.println("==================================\n");

        // Create LinkedList to maintain order
        LinkedList<String> train = new LinkedList<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC Chair");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(train);

        // Insert Pantry Car at position 2
        train.add(2, "Pantry Car");

        // Remove first and last bogie
        train.removeFirst();
        train.removeLast();

        System.out.println("\nFinal Train Consist:");
        System.out.println(train);

        System.out.println("\nUC4 ordering and modification completed...");
    }
}