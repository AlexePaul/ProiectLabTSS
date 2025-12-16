package validator;

import org.example.validator.PasswordValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorCEGTest {

    @Test
    void returnsFalseWhenPasswordIsNull() {
        assertFalse(PasswordValidator.isValidPassword(null));
    }

    @Test
    void returnsFalseWhenLengthLessThanEight() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!a"));
    }

    @Test
    void returnsFalseWhenLengthGreaterThanTwenty() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!abcdefghijklmnopqrstu"));
    }

    @Test
    void returnsFalseWhenMissingUppercaseLetters() {
        assertFalse(PasswordValidator.isValidPassword("ab1!abcd"));
    }

    @Test
    void returnsFalseWhenMissingLowercaseLetters() {
        assertFalse(PasswordValidator.isValidPassword("AB1!ABCD"));
    }

    @Test
    void returnsFalseWhenMissingDigits() {
        assertFalse(PasswordValidator.isValidPassword("Abc!abcd"));
    }

    @Test
    void returnsFalseWhenMissingSpecialCharacters() {
        assertFalse(PasswordValidator.isValidPassword("Ab1abcdE"));
    }

    @Test
    void returnsTrueWhenAllConditionsMet() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcd"));
    }
}

