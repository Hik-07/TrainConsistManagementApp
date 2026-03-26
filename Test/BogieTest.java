import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class TrainConsistManagementAppTest {

    // Helper class to mimic Bogie from Main
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Loop-based filtering method
    private List<Bogie> loopFilter(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering method
    private List<Bogie> streamFilter(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // Generate a sample dataset
    private List<Bogie> generateBogies(int count) {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 48));
        }
        return bogies;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = generateBogies(10);
        List<Bogie> filtered = loopFilter(bogies, 60);
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = generateBogies(10);
        List<Bogie> filtered = streamFilter(bogies, 60);
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = generateBogies(100);
        List<Bogie> loopFiltered = loopFilter(bogies, 60);
        List<Bogie> streamFiltered = streamFilter(bogies, 60);
        assertEquals(loopFiltered.size(), streamFiltered.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = generateBogies(1000);

        long loopStart = System.nanoTime();
        loopFilter(bogies, 60);
        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        long streamStart = System.nanoTime();
        streamFilter(bogies, 60);
        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = generateBogies(100_000); // Large dataset
        List<Bogie> loopFiltered = loopFilter(bogies, 60);
        List<Bogie> streamFiltered = streamFilter(bogies, 60);

        // Verify results are consistent
        assertEquals(loopFiltered.size(), streamFiltered.size());
        assertTrue(loopFiltered.stream().allMatch(b -> b.capacity > 60));
        assertTrue(streamFiltered.stream().allMatch(b -> b.capacity > 60));
    }
}