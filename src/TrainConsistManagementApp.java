// ---------------- UC18: Linear Search ----------------

class BogieSearchUtil {

    // Linear Search Method
    public static boolean searchBogieById(String[] bogieIds, String key) {

        // Traverse array sequentially
        for (int i = 0; i < bogieIds.length; i++) {

            // Use equals() for string comparison
            if (bogieIds[i].equals(key)) {
                return true; // Early termination
            }
        }

        return false; // Not found after full traversal
    }
}

// ---------------- MAIN ----------------
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        String searchKey = "BG309";

        boolean found = BogieSearchUtil.searchBogieById(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie found: " + searchKey);
        } else {
            System.out.println("Bogie not found: " + searchKey);
        }
    }
}