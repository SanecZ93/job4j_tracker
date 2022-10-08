package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("password null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("the password must "
                    + "be between 8 and 32");
        }
        if (PasswordValidator.isDigit(password)) {
            throw new IllegalArgumentException("The password must "
                    + "contain at least one digit");
        }
        if (PasswordValidator.upLitter(password)) {
            throw new IllegalArgumentException("The password must "
                    + "contain at least one uppercase character");
        }
        if (PasswordValidator.lowLitter(password)) {
            throw new IllegalArgumentException("The password must "
                    + "contain at least one lowercase character");
        }
        if (PasswordValidator.specialSymbol(password)) {
            throw new IllegalArgumentException("The password must "
                    + "contain at least one special character");
        }
        boolean valid = password.toUpperCase().contains("PASSWORD".toUpperCase())
                    || password.toLowerCase().contains("password".toLowerCase())
                    || password.toUpperCase().contains("USER".toUpperCase())
                    || password.toLowerCase().contains("user".toLowerCase())
                    || password.toUpperCase().contains("QWERTY".toUpperCase())
                    || password.toLowerCase().contains("qwerty".toLowerCase())
                    || password.toUpperCase().contains("ADMIN".toUpperCase())
                    || password.toLowerCase().contains("admin".toLowerCase())
                    || password.contains("12345");
            if (valid) {
                throw new IllegalArgumentException("The password must "
                        + "not contain case-insensitive substrings");
            }
            return password;
    }

    private static boolean isDigit(String password) {
        Boolean valid = null;
        for (int i = 0; i < password.length(); i++) {
            int code = password.codePointAt(i);
            valid = !Character.isDigit(code);
            if (!valid) {
                break;
            }
        }
        return Boolean.TRUE.equals(valid);
    }

    private static boolean upLitter(String password) {
        Boolean valid = null;
        for (int i = 0; i < password.length(); i++) {
            int code = password.codePointAt(i);
            valid = !Character.isUpperCase(code);
            if (!valid) {
                break;
            }
        }
        return Boolean.TRUE.equals(valid);
    }

    private static boolean lowLitter(String password) {
        Boolean valid = null;
        for (int i = 0; i < password.length(); i++) {
            int code = password.codePointAt(i);
            valid = !Character.isLowerCase(code);
            if (!valid) {
                break;
            }
        }
        return Boolean.TRUE.equals(valid);
    }

    private static boolean specialSymbol(String password) {
        Boolean valid = null;
        for (int i = 0; i < password.length(); i++) {
            int code = password.codePointAt(i);
            valid = !(code == 36 || code == 95);
            if (!valid) {
                break;
            }
        }
        return Boolean.TRUE.equals(valid);
    }
}
