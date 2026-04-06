import java.util.Arrays;

// ---------------- UC20: Defensive Search ----------------

class SafeSearchUtil {

    public static boolean searchBogie(String[] bogieIds, String key) {

        // 🔥 FAIL-FAST CHECK
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Search cannot be performed: No bogies available in the train");
        }

        // Linear search (can reuse UC18 logic)
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }
}

// ---------------- MAIN ----------------
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Case 1: Empty array → should fail fast
        String[] emptyTrain = {};

        try {
            SafeSearchUtil.searchBogie(emptyTrain, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        // Case 2: Valid search → should work
        String[] bogies = {"BG101","BG205","BG309"};

        boolean found = SafeSearchUtil.searchBogie(bogies, "BG205");

        if (found) {
            System.out.println("Bogie found");
        } else {
            System.out.println("Bogie not found");
        }
    }
}