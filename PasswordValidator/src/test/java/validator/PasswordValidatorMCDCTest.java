package validator;

import org.example.validator.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorMCDCTest {

    @Test
    @DisplayName("M1 - Toate conditiile true")
    void returnsTrueWhenAllConditionsAreMet() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcda"));
    }

    @Test
    @DisplayName("M2 - Fără litera mare (C4=F)")
    void returnsFalseWhenMissingUppercase() {
        assertFalse(PasswordValidator.isValidPassword("ab1!abcda"));
    }

    @Test
    @DisplayName("M3 - Fără litera mica (C5=F)")
    void returnsFalseWhenMissingLowercase() {
        assertFalse(PasswordValidator.isValidPassword("AB1!ABCDA"));
    }

    @Test
    @DisplayName("M4 - Fără cifra (C6=F)")
    void returnsFalseWhenMissingDigit() {
        assertFalse(PasswordValidator.isValidPassword("Abc!abcda"));
    }

    @Test
    @DisplayName("M5 - Fără caracter special (C7=F)")
    void returnsFalseWhenMissingSpecialCharacter() {
        assertFalse(PasswordValidator.isValidPassword("Ab1abcdEa"));
    }
}
