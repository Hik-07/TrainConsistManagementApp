import java.util.*;
import java.util.stream.*;

class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        List<GoodsBogie> goodsBogies = Arrays.asList(
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Grain")
        );

        boolean safetyCompliant = goodsBogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum")
                );

        if (safetyCompliant) {
            System.out.println("Train is safety compliant.");
        } else {
            System.out.println("Train is NOT safety compliant.");
        }
    }
}