package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password, String dest) {
        if (password == null) {
            return "password null";
        }
        if (password.length() < 8 || password.length() > 32) {
            return "the password must be between 8 and 32";
        }
        if (!password.matches("(.*[0-9].*)")) {
            return "The password must contain at least one digit";
        }
        if (!password.matches("(.*[A-Z].*)")) {
            return "The password must contain at least one uppercase character";
        }
        if (!password.matches("(.*[a-z].*)")) {
            return "The password must contain at least one lowercase character";
        }
        if (!password.matches("(.*[@,#,$,%].*$)")) {
            return "The password must contain at least one special character";
        }
        for (int i = password.length() - dest.length(); i >= 0; i--) {
            if (password.regionMatches(true, i, dest, 0, dest.length())) {
                return "The password must not contain case-insensitive substrings";
            }
        }
        return password;
    }
}





