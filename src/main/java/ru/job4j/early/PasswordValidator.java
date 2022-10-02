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
            if (!password.matches("(.*[0-9].*)")) {
                throw new IllegalArgumentException("The password must "
                        + "contain at least one digit");
            }
            if (!password.matches("(.*[A-Z].*)")) {
                throw new IllegalArgumentException("The password must "
                        + "contain at least one uppercase character");
            }
            if (!password.matches("(.*[a-z].*)")) {
                throw new IllegalArgumentException("The password must "
                        + "contain at least one lowercase character");
            }
            if (!password.matches("(.*[@,#,$,%].*$)")) {
                throw new IllegalArgumentException("The password must "
                        + "contain at least one special character");
            }
            return password;
        }
        public static boolean processRegionMatches(String password, String dest) {
            for (int i = password.length() - dest.length(); i >= 0; i--) {
                if (password.regionMatches(true, i, dest, 0, dest.length())) {
                    throw new IllegalArgumentException("The password must not contain case-insensitive substrings");
                }
            }
            return true;
        }
}
