// ---------------- UC16: Bubble Sort Implementation ----------------

class BubbleSortUtil {

    // Bubble Sort method
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer loop → number of passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop → compare adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {

                // If current > next → swap
                if (arr[j] > arr[j + 1]) {

                    // Swap logic
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Utility to print array
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

// ---------------- MAIN ----------------
public class Main {
    public static void main(String[] args) {

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Before Sorting: ");
        BubbleSortUtil.printArray(capacities);

        BubbleSortUtil.bubbleSort(capacities);

        System.out.print("After Sorting: ");
        BubbleSortUtil.printArray(capacities);
    }
}