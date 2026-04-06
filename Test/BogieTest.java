import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GoodsBogieTest {

    // ✅ Safe assignment
    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.getCargo());
    }

    // ❗ IMPORTANT: Exception is HANDLED internally → so no assertThrows here
    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");

        // cargo should NOT be assigned
        assertNull(bogie.getCargo());
    }

    // ❗ Ensure cargo remains null after failure
    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    // ✅ Program continuation check
    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        bogie1.assignCargo("Petroleum"); // fails

        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");
        bogie2.assignCargo("Petroleum"); // should still work

        assertEquals("Petroleum", bogie2.getCargo());
    }

    // ✅ Finally block indirectly validated (no crash + execution completes)
    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}