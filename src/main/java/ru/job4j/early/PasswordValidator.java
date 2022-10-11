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
        if (PasswordValidator.substrings(password)) {
            throw new IllegalArgumentException("The password must "
                    + "not contain case-insensitive substrings");
        }
        return password;
    }

        public static boolean isDigit(String password) {
            boolean valid = true;
            for (int i = 0; i < password.length(); i++) {
                int code = password.codePointAt(i);
                valid = !Character.isDigit(code);
                if (!valid) {
                    break;
                }
            }
            return valid;
        }

        public static boolean upLitter(String password) {
            boolean valid = true;
            for (int i = 0; i < password.length(); i++) {
                int code = password.codePointAt(i);
                valid = !Character.isUpperCase(code);
                if (!valid) {
                    break;
                }
            }
            return valid;
        }

        public static boolean lowLitter(String password) {
            boolean valid = true;
            for (int i = 0; i < password.length(); i++) {
                int code = password.codePointAt(i);
                valid = !Character.isLowerCase(code);
                if (!valid) {
                    break;
                }
            }
            return valid;
        }

        public static boolean specialSymbol(String password) {
            boolean valid = true;
            for (int i = 0; i < password.length(); i++) {
                int code = password.codePointAt(i);
                valid = !(code == 36 || code == 95);
                if (!valid) {
                    break;
                }
            }
            return valid;
    }

    public static boolean substrings(String password) {
        boolean contain = false;
        String[] subString = {"password", "user", "qwerty", "admin", "12345"};
        for (String s : subString) {
            contain = (password.toLowerCase().contains(s.toLowerCase()));
            if (contain) {
                break;
            }
        }
        return contain;
    }
}
