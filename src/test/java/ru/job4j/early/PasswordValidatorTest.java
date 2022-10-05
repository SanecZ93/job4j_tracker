package ru.job4j.early;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void whenEmptyPasswordNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(null, null));
        assertThat(exception.getMessage()).isEqualTo(
                "password null");
    }

    @Test
    public void whenEmptyPasswordNot8to32() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("P@s$W1", null));
        assertThat(exception.getMessage()).isEqualTo(
                "the password must be between 8 and 32");
    }

    @Test
    public void whenEmptyPasswordNotDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("P@s$WORdd", null));
        assertThat(exception.getMessage()).isEqualTo(
                "The password must contain at least one digit");
    }

    @Test
    public void whenEmptyPasswordNotUpLitter() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("p@s$w0rdd1", null));
        assertThat(exception.getMessage()).isEqualTo(
                "The password must contain at least one uppercase character");
    }

    @Test
    public void whenEmptyPasswordNotLowLitter() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("P@S$W0RD1", null));
        assertThat(exception.getMessage()).isEqualTo(
                "The password must contain at least one lowercase character");
    }

    @Test
    public void whenEmptyPasswordNotSpecialSymbol() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("PaSsW0RD1", null));
        assertThat(exception.getMessage()).isEqualTo(
                "The password must contain at least one special character");
    }

    @Test
    public void whetContainSubstrings() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("123#Password#321", "Password"));
        assertThat(exception.getMessage()).isEqualTo(
                "The password must not contain case-insensitive substrings");
    }


    @Test
    public void whenValidPassword() {
        String rsl = PasswordValidator.validate("P@s$W0Rdd1", "Password");
        String expected = "P@s$W0Rdd1";
        assertThat(rsl).isEqualTo(expected);
    }
}