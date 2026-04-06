import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SafeSearchTest {

    @Test
    void testSearch_EmptyArrayThrowsException() {
        String[] arr = {};

        IllegalStateException thrown = assertThrows(
                IllegalStateException.class,
                () -> SafeSearchUtil.searchBogie(arr, "BG101")
        );

        assertTrue(thrown.getMessage().contains("No bogies available"));
    }

    @Test
    void testSearch_NullArrayThrowsException() {
        IllegalStateException thrown = assertThrows(
                IllegalStateException.class,
                () -> SafeSearchUtil.searchBogie(null, "BG101")
        );

        assertTrue(thrown.getMessage().contains("No bogies available"));
    }

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309"};

        assertTrue(SafeSearchUtil.searchBogie(arr, "BG205"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309"};

        assertFalse(SafeSearchUtil.searchBogie(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};

        assertTrue(SafeSearchUtil.searchBogie(arr, "BG101"));
    }
}