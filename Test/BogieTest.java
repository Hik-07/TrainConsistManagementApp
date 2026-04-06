import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(arr);

        assertTrue(BinarySearchUtil.binarySearch(arr, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(arr);

        assertFalse(BinarySearchUtil.binarySearch(arr, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(arr);

        assertTrue(BinarySearchUtil.binarySearch(arr, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(arr);

        assertTrue(BinarySearchUtil.binarySearch(arr, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};
        Arrays.sort(arr);

        assertTrue(BinarySearchUtil.binarySearch(arr, "BG101"));
    }
}