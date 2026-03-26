// Custom exception class for invalid passenger bogie capacity
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger bogie class with capacity validation
class PassengerBogie {
    private String type;
    private int capacity;

    // Constructor enforces fail-fast validation
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    // Getters
    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "PassengerBogie{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

// Example usage
public class TrainConsistManagementApp {
    public static void main(String[] args) {
        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            PassengerBogie acChair = new PassengerBogie("AC Chair", 0); // This will throw exception
        } catch (InvalidCapacityException e) {
            System.out.println("Error creating bogie: " + e.getMessage());
        }
    }
}