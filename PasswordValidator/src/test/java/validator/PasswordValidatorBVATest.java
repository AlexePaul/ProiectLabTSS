package validator;

import org.example.validator.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorBVATest {

    @Test
    @DisplayName("BVA1 - Lungime 7 (invalid)")
    void returnsFalseWhenLengthIsSeven() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!abc"));
    }

    @Test
    @DisplayName("BVA2 - Lungime 8 (valid)")
    void returnsTrueWhenLengthIsEight() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcd"));
    }

    @Test
    @DisplayName("BVA3 - Lungime 9 (valid)")
    void returnsTrueWhenLengthIsNine() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcde"));
    }

    @Test
    @DisplayName("BVA4 - Lungime 19 (valid)")
    void returnsTrueWhenLengthIsNineteen() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcdefghijklmno"));
    }

    @Test
    @DisplayName("BVA5 - Lungime 20 (valid)")
    void returnsTrueWhenLengthIsTwenty() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcdefghijklmnop"));
    }

    @Test
    @DisplayName("BVA6 - Lungime 21 (invalid)")
    void returnsFalseWhenLengthIsTwentyOne() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!abcdefghijklmnopq"));
    }
}
