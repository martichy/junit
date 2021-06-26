package ru.mai.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.Spy;
import ru.mai.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Spy
    Calculator calculatorSpy;

    @BeforeEach
    void setUp() {
        calculatorSpy = Mockito.spy(Calculator.class);
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "10.66, 10,11"})
    void summarize(double number0, double number1) {
        assertEquals(number0 + number1, calculatorSpy.summarize(number0,number1));
    }

    @ParameterizedTest
    @CsvSource({"1, 3", "10.55, 20.55"})
    void deduct(double reduction, double subtracted) {
        assertEquals(reduction - subtracted, calculatorSpy.deduct(reduction, subtracted));
    }

    @ParameterizedTest
    @CsvSource({"1, 0", "2, 3", "1.44, 2.77"})
    void divide(double divisible, double divisor) {
        if (divisor == 0) {
            assertEquals(0, calculatorSpy.divide(divisible, divisor));
        } else {
            assertEquals(divisible / divisor, calculatorSpy.divide(divisible, divisor));
        }
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "5, 2", "3, 0"})
    void mod(double divisible, double divisor) {
        if (divisor == 0) {
            assertEquals(0,calculatorSpy.mod(divisible, divisor));
        } else {
            assertEquals(divisible % divisor, calculatorSpy.mod(divisible, divisor));
        }
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "2.5, 2", "1.66, 3.44", "0, 3"})
    void multiply(double number0, double number1) {
        assertEquals(number0 * number1, calculatorSpy.multiply(number0, number1));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1, 2, 0, 10, 100, 101})
    void reverseNumber(double a) {
        if (a != 0) {
            assertEquals(1 / a, calculatorSpy.reverseNumber(a));
        } else {
            assertEquals(a, calculatorSpy.reverseNumber(a));
        }
    }
}