import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;

class TrainAppTest {

    // Helper method to validate Train ID
    private boolean isValidTrainID(String trainID) {
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Matcher trainMatcher = trainPattern.matcher(trainID);
        return trainMatcher.matches();
    }

    // Helper method to validate Cargo Code
    private boolean isValidCargoCode(String cargoCode) {
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);
        return cargoMatcher.matches();
    }

    // --------------------- Train ID Tests ---------------------

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isValidTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrainID("TRAIN12"));
        assertFalse(isValidTrainID("TRN12A"));
        assertFalse(isValidTrainID("1234-TRN"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrainID("TRN-123"));    // too few digits
        assertFalse(isValidTrainID("TRN-12345"));  // too many digits
    }

    @Test
    void testRegex_EmptyTrainID() {
        assertFalse(isValidTrainID(""));           // empty input
    }

    @Test
    void testRegex_ExactPatternTrainID() {
        assertFalse(isValidTrainID(" TRN-1234 ")); // extra spaces
        assertFalse(isValidTrainID("TRN-1234A"));  // extra characters
    }

    // --------------------- Cargo Code Tests ---------------------

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargoCode("PET-ab"));
        assertFalse(isValidCargoCode("PET123"));
        assertFalse(isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isValidCargoCode("PET-aB"));   // lowercase letters not allowed
        assertFalse(isValidCargoCode("PET-ab"));   // all lowercase not allowed
    }

    @Test
    void testRegex_EmptyCargoCode() {
        assertFalse(isValidCargoCode(""));         // empty input
    }

    @Test
    void testRegex_ExactPatternCargoCode() {
        assertFalse(isValidCargoCode(" PET-AB ")); // extra spaces
        assertFalse(isValidCargoCode("PET-ABC"));  // too many letters
    }
}