import java.util.regex.*;
import java.util.Scanner;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Train ID: ");
        String trainID = sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = sc.nextLine();

        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        Matcher trainMatcher = trainPattern.matcher(trainID);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        if(trainMatcher.matches()) {
            System.out.println("Train ID is valid.");
        } else {
            System.out.println("Train ID is invalid.");
        }

        if(cargoMatcher.matches()) {
            System.out.println("Cargo Code is valid.");
        } else {
            System.out.println("Cargo Code is invalid.");
        }
    }
}