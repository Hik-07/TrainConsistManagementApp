import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BogieSearchTest {

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(BogieSearchUtil.searchBogieById(arr, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(BogieSearchUtil.searchBogieById(arr, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(BogieSearchUtil.searchBogieById(arr, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(BogieSearchUtil.searchBogieById(arr, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};

        assertTrue(BogieSearchUtil.searchBogieById(arr, "BG101"));
    }
}