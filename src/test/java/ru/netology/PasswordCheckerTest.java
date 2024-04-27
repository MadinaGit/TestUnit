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

    public void parameterizedTest1(String password, boolean expected) {
        passwordChecker.setMinLenght(3);
        passwordChecker.setMaxRepeats(2);
        boolean result = passwordChecker.verify(password);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void setMinLenght() {

        passwordChecker.setMinLenght(5);
        Throwable exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    throw new IllegalArgumentException("Минимальное число не должно быть отрицательным");
                });
        Assertions.assertEquals("Минимальное число не должно быть отрицательным", exception.getMessage());

    }

    @Test
    void setMaxRepeats() {

        Assertions.assertTimeout(
                Duration.ofSeconds(2),
                () -> {

                    Thread.sleep(1000);
                }
        );
    }
}