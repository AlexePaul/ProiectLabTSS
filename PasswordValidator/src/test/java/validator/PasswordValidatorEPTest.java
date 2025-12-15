package validator;

import org.example.validator.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorEPTest {

    @Test
    @DisplayName("EP1 - Parola este null")
    void returnsFalseWhenPasswordIsNull() {
        assertFalse(PasswordValidator.isValidPassword(null));
    }

    @Test
    @DisplayName("EP2 - Parola este prea scurtă")
    void returnsFalseWhenPasswordTooShort() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!"));
    }

    @Test
    @DisplayName("EP3 - Parola este prea lungă")
    void returnsFalseWhenPasswordTooLong() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!abcdabcdabcdabcdabcd"));
    }

    @Test
    @DisplayName("EP4 - Parolei ii lipsește litera mare")
    void returnsFalseWhenMissingUppercase() {
        assertFalse(PasswordValidator.isValidPassword("ab1!abcd"));
    }

    @Test
    @DisplayName("EP5 - Parolei ii lipsește litera mica")
    void returnsFalseWhenMissingLowercase() {
        assertFalse(PasswordValidator.isValidPassword("AB1!ABCD"));
    }

    @Test
    @DisplayName("EP6 - Parolei ii lipsește cifra")
    void returnsFalseWhenMissingDigit() {
        assertFalse(PasswordValidator.isValidPassword("Abc!abcd"));
    }

    @Test
    @DisplayName("EP7 - Parolei ii lipsește caracterul special")
    void returnsFalseWhenMissingSpecialCharacter() {
        assertFalse(PasswordValidator.isValidPassword("Ab1abcdE"));
    }

    @Test
    @DisplayName("EP8 - Parola îndeplinește toate criteriile")
    void returnsTrueWhenPasswordMeetsAllCriteria() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcd"));
    }
}
