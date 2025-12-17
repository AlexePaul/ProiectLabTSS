package validator;

import org.example.validator.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorCEGTest {

    @Test
    @DisplayName("CE1 - C1=1 (parola null)")
    void returnsFalseWhenPasswordIsNull() {
        assertFalse(PasswordValidator.isValidPassword(null));
    }

    @Test
    @DisplayName("CE2 - C2=1 (lungime < 8)")
    void returnsFalseWhenLengthLessThanEight() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!a"));
    }

    @Test
    @DisplayName("CE3 - C3=1 (lungime > 20)")
    void returnsFalseWhenLengthGreaterThanTwenty() {
        assertFalse(PasswordValidator.isValidPassword("Ab1!abcdefghijklmnopqrstu"));
    }

    @Test
    @DisplayName("CE4 - C4=1 (fără litere mari)")
    void returnsFalseWhenMissingUppercaseLetters() {
        assertFalse(PasswordValidator.isValidPassword("ab1!abcd"));
    }

    @Test
    @DisplayName("CE5 - C5=1 (fără litere mici)")
    void returnsFalseWhenMissingLowercaseLetters() {
        assertFalse(PasswordValidator.isValidPassword("AB1!ABCD"));
    }

    @Test
    @DisplayName("CE6 - C6=1 (fără cifre)")
    void returnsFalseWhenMissingDigits() {
        assertFalse(PasswordValidator.isValidPassword("Abc!abcd"));
    }

    @Test
    @DisplayName("CE7 - C7=1 (fără caractere speciale)")
    void returnsFalseWhenMissingSpecialCharacters() {
        assertFalse(PasswordValidator.isValidPassword("Ab1abcdE"));
    }

    @Test
    @DisplayName("CE8 - toate cauzele false => parola validă")
    void returnsTrueWhenAllConditionsMet() {
        assertTrue(PasswordValidator.isValidPassword("Ab1!abcd"));
    }
}
