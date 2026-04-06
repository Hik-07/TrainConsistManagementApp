// ---------------- UC14 (reuse) ----------------
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}

// ---------------- UC15 START ----------------

// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie Class
class GoodsBogie {
    private String shape;   // Rectangular / Cylindrical
    private String cargo;   // Petroleum / Food / etc.

    public GoodsBogie(String shape) {
        this.shape = shape;
        this.cargo = null;
    }

    public String getShape() {
        return shape;
    }

    public String getCargo() {
        return cargo;
    }

    // CORE LOGIC: try-catch-finally inside method
    public void assignCargo(String cargoType) {
        try {
            // Safety validation
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargoType.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe cargo: Petroleum cannot be assigned to Rectangular bogie"
                );
            }

            // Safe assignment
            this.cargo = cargoType;
            System.out.println("Cargo assigned successfully: " + cargoType);

        } catch (CargoSafetyException e) {
            // Handle exception internally (IMPORTANT)
            System.out.println("Error: " + e.getMessage());

        } finally {
            // MUST always execute
            System.out.println("Cargo assignment attempt completed.");
        }
    }
}

// ---------------- MAIN ----------------
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Safe case
        GoodsBogie bogie1 = new GoodsBogie("Cylindrical");
        bogie1.assignCargo("Petroleum");

        System.out.println();

        // Unsafe case
        GoodsBogie bogie2 = new GoodsBogie("Rectangular");
        bogie2.assignCargo("Petroleum");

        System.out.println();

        // Program should CONTINUE
        GoodsBogie bogie3 = new GoodsBogie("Rectangular");
        bogie3.assignCargo("Food");
    }
}