import java.util.LinkedHashSet;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("==================================\n");

        // Create LinkedHashSet to maintain order + uniqueness
        LinkedHashSet<String> train = new LinkedHashSet<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");


        train.add("Sleeper"); // will be ignored

        System.out.println("Final Train Formation:");
        System.out.println(train);

        System.out.println("\nNote:");
        System.out.println("Duplicates are not allowed and insertion order is preserved.");

        System.out.println("\nUC5 insertion order validation completed...");
    }
}