package org.example.validator;
@SuppressWarnings("unused")
public class PasswordValidator {

    @SuppressWarnings("unused")
    public static boolean isValidPassword(String password) {

        if (password == null) {
            return false;
        }

        int length = password.length();
        if (length < 8) {
            return false;
        }
        if (length > 20) {
            System.out.println(length);
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if ("!@#$%^&*".indexOf(c) >= 0) {
                hasSpecial = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecial;
    }
}
