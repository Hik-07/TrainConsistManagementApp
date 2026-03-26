import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

class PassengerBogieTest {

    // ---------------- UC14: Custom Exception Tests ----------------

    @Test
    void testException_ValidCapacityCreation() {
        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            assertEquals("Sleeper", sleeper.getType());
            assertEquals(72, sleeper.getCapacity());
        } catch (InvalidCapacityException e) {
            fail("Exception should not be thrown for valid capacity");
        }
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        InvalidCapacityException thrown = assertThrows(
                InvalidCapacityException.class,
                () -> new PassengerBogie("AC Chair", -10)
        );
        assertEquals("Capacity must be greater than zero", thrown.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        InvalidCapacityException thrown = assertThrows(
                InvalidCapacityException.class,
                () -> new PassengerBogie("First Class", 0)
        );
        assertEquals("Capacity must be greater than zero", thrown.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        InvalidCapacityException thrown = assertThrows(
                InvalidCapacityException.class,
                () -> new PassengerBogie("Sleeper", -5)
        );
        assertTrue(thrown.getMessage().contains("greater than zero"));
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() {
        try {
            PassengerBogie bogie = new PassengerBogie("AC Chair", 56);
            assertEquals("AC Chair", bogie.getType());
            assertEquals(56, bogie.getCapacity());
        } catch (InvalidCapacityException e) {
            fail("Exception should not occur for valid capacity");
        }
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        try {
            List<PassengerBogie> bogies = Arrays.asList(
                    new PassengerBogie("Sleeper", 72),
                    new PassengerBogie("AC Chair", 56),
                    new PassengerBogie("First Class", 24)
            );
            assertEquals(3, bogies.size());
            assertEquals(72, bogies.get(0).getCapacity());
            assertEquals(56, bogies.get(1).getCapacity());
            assertEquals(24, bogies.get(2).getCapacity());
        } catch (InvalidCapacityException e) {
            fail("Exception should not occur for valid capacities");
        }
    }
}