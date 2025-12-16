package validator;

import org.example.validator.PasswordValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorBVATest {

    @Test
    void returnsFalseWhenLengthIsSeven() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!abc"));
    }

    @Test
    void returnsTrueWhenLengthIsEight() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcd"));
    }

    @Test
    void returnsTrueWhenLengthIsNine() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcde"));
    }

    @Test
    void returnsTrueWhenLengthIsNineteen() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcdefghijklmno"));
    }

    @Test
    void returnsTrueWhenLengthIsTwenty() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcdefghijklmnop"));
    }

    @Test
    void returnsFalseWhenLengthIsTwentyOne() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!abcdefghijklmnopq"));
    }
}

