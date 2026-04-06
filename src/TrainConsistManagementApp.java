import java.util.Arrays;

// ---------------- UC17: Arrays.sort() ----------------

class BogieSorter {

    // Method to sort bogie names
    public static void sortBogieNames(String[] bogies) {
        Arrays.sort(bogies);
    }
}

// ---------------- MAIN ----------------
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        String[] bogieTypes = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogieTypes));

        BogieSorter.sortBogieNames(bogieTypes);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(bogieTypes));
    }
}