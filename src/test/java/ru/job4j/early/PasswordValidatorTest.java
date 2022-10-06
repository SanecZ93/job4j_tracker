package ru.job4j.early;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void whenEmptyPasswordNull() {
        String rsl = PasswordValidator.validate(null, null);
        String expected = "password null";
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenEmptyPasswordNot8to32() {
        String rsl = PasswordValidator.validate("P@s$W1", null);
        String expected = "the password must be between 8 and 32";
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenEmptyPasswordNotDigit() {
        String rsl = PasswordValidator.validate("P@s$WORdd", null);
        String expected = "The password must contain at least one digit";
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenEmptyPasswordNotUpLitter() {
        String rsl = PasswordValidator.validate("p@s$w0rdd1", null);
        String expected = "The password must contain at least one uppercase character";
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenEmptyPasswordNotLowLitter() {
        String rsl = PasswordValidator.validate("P@S$W0RD1", null);
        String expected = "The password must contain at least one lowercase character";
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenEmptyPasswordNotSpecialSymbol() {
        String rsl = PasswordValidator.validate("PaSsW0RD1", null);
        String expected = "The password must contain at least one special character";
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whetContainSubstrings() {
        String rsl = PasswordValidator.validate("123#Password#321", "Password");
        String expected = "The password must not contain case-insensitive substrings";
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenValidPassword() {
        String rsl = PasswordValidator.validate("P@s$W0Rdd1", "Password");
        String expected = "P@s$W0Rdd1";
        assertThat(rsl).isEqualTo(expected);
    }
}