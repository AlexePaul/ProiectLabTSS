package validator;

import org.junit.jupiter.api.DisplayName;
import org.example.validator.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorBVATest {

    @Test
    @DisplayName("BVA1: Lungime sub minim (7 caractere) → invalid")
    void testLengthBelowMinimum() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!abc"));
    }

    @Test
    @DisplayName("BVA2: Lungime minimă (8 caractere) → valid")
    void testMinimumLength() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcd"));
    }

    @Test
    @DisplayName("BVA3: Lungime minim +1 (9 caractere) → valid")
    void testMinimumPlusOne() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcde"));
    }

    @Test
    @DisplayName("BVA4: Lungime maxim -1 (19 caractere) → valid")
    void testMaximumMinusOne() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcdefghijklmno"));
    }

    @Test
    @DisplayName("BVA5: Lungime maximă (20 caractere) → valid")
    void testMaximumLength() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcdefghijklmnop"));
    }

    @Test
    @DisplayName("BVA6: Lungime peste maxim (21 caractere) → invalid")
    void testAboveMaximum() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!abcdefghijklmnopq"));
    }
}
