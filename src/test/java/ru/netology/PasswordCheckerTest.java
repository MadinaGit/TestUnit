package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;


class PasswordCheckerTest {
    PasswordChecker passwordChecker = new PasswordChecker();

    @ParameterizedTest
    @CsvSource(value = {
            "5534846, true",
            "5553846, false",
            "52, false",
            "555, false",
            "523, true",
            "123654, true",
            "000000, false"
    })

    public void testParameterizedTestTrue(String password, boolean expected) {
        passwordChecker.setMinLenght(3);
        passwordChecker.setMaxRepeats(2);
        boolean result = passwordChecker.verify(password);
        Assertions.assertEquals(expected, result);
    }


    @Test
    void testPasswordSetMinLenght() {
        passwordChecker.setMinLenght(10);
        Assertions.assertEquals(10, passwordChecker.minLenght);


    }

    @Test
    void testPasswordSetMaxRepeats() {
        passwordChecker.setMaxRepeats(5);
        Assertions.assertNotEquals(3, passwordChecker.maxRepeats);
    }
}