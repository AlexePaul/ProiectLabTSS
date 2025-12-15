package validator;

import org.example.validator.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorCEGTest {

    @Test
    @DisplayName("CE1: Parola null → invalid")
    void testNullPassword() {
        assertFalse(PasswordValidator.isValidPassword(null));
    }

    @Test
    @DisplayName("CE2: Lungime < 8 → invalid")
    void testLengthBelowMin() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!a"));
    }

    @Test
    @DisplayName("CE3: Lungime > 20 → invalid")
    void testLengthAboveMax() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!abcdefghijklmnopqrstu"));
    }

    @Test
    @DisplayName("CE4: Lipsă literă mare → invalid")
    void testMissingUppercase() {
        assertFalse(PasswordValidator.isValidPassword("ab1!abcd"));
    }

    @Test
    @DisplayName("CE5: Lipsă literă mică → invalid")
    void testMissingLowercase() {
        assertFalse(PasswordValidator.isValidPassword("AB1!ABCD"));
    }

    @Test
    @DisplayName("CE6: Lipsă cifră → invalid")
    void testMissingDigit() {
        assertFalse(PasswordValidator.isValidPassword("Abc!abcd"));
    }

    @Test
    @DisplayName("CE7: Lipsă caracter special → invalid")
    void testMissingSpecialChar() {
        assertFalse(PasswordValidator.isValidPassword("Ab1abcdE"));
    }

    @Test
    @DisplayName("CE8: Toate condițiile valide → valid")
    void testAllValid() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcd"));
    }
}
