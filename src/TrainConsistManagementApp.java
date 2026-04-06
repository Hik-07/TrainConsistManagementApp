import java.util.Arrays;

// ---------------- UC19: Binary Search ----------------

class BinarySearchUtil {

    public static boolean binarySearch(String[] bogieIds, String key) {

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true; // Found
            } else if (comparison > 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return false; // Not found
    }
}

// ---------------- MAIN ----------------
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        // Ensure sorted (MANDATORY)
        Arrays.sort(bogieIds);

        String searchKey = "BG309";

        boolean found = BinarySearchUtil.binarySearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie found: " + searchKey);
        } else {
            System.out.println("Bogie not found: " + searchKey);
        }
    }
}