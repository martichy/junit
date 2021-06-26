package ru.mai.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.mockito.Spy;
import ru.mai.StringWork;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringWorkTest {

    @Spy
    StringWork stringWorkSpy;

    @BeforeEach
    void setUp() {
        stringWorkSpy = Mockito.spy(StringWork.class);
    }

    @ParameterizedTest
    @MethodSource("stringsForMakePence")
    void makePence(String expected, String source) {
        assertEquals(expected,stringWorkSpy.makePence(source));
    }

    static Stream<Arguments> stringsForMakePence() {
        return Stream.of(
                Arguments.arguments("ПрИвЕт", "привет"),
                Arguments.arguments("ПрИвЕт", "ПРИВЕТ"),
                Arguments.arguments("ПрИвЕт, КаК ДеЛа?", "привет, как дела?")
        );
    }

    @ParameterizedTest
    @MethodSource("stringsForStartWithCapital")
    void startWithCapital(String expected, String source) {
        assertEquals(expected,stringWorkSpy.startWithCapital(source));
    }

    static Stream<Arguments> stringsForStartWithCapital() {
        return Stream.of(
                Arguments.arguments("Привет", "привет"),
                Arguments.arguments("Привет", "ПРИВЕТ"),
                Arguments.arguments("Привет, Как Дела?", "привет, как дела?")
        );
    }

    @ParameterizedTest
    @MethodSource("stringsForUpperChar")
    void upperChar(String expected, String source, char symbol) {
        assertEquals(expected,stringWorkSpy.upperChar(source, symbol));
    }

    static Stream<Arguments> stringsForUpperChar() {
        return Stream.of(
                Arguments.arguments("привЕт", "привет", 'е'),
                Arguments.arguments("Привет", "ПРИВЕТ", 'П'),
                Arguments.arguments("привет, кАк делА?", "привет, как дела?", 'а')
        );
    }

    @ParameterizedTest
    @MethodSource("stringsForLowerChar")
    void lowerChar(String expected, String source, char symbol) {
        assertEquals(expected,stringWorkSpy.lowerChar(source,symbol));
    }

    static Stream<Arguments> stringsForLowerChar() {
        return Stream.of(
                Arguments.arguments("ПРИВеТ", "привет", 'е'),
                Arguments.arguments("пРИВЕТ", "ПРИВЕТ", 'П'),
                Arguments.arguments("ПРИВЕТ, КаК ДЕЛа?", "привет, как дела?", 'а')
        );
    }
}