package ru.mai.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.Spy;
import ru.mai.Person;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Spy
    Person personSpy;

    @BeforeEach
    void setUp() {
        personSpy = Mockito.spy(Person.class);
    }

    @ParameterizedTest
    @MethodSource("firstnames")
    void setFirstname(String firstname, String expected) {
        personSpy.setFirstname(firstname);
        assertEquals(expected, personSpy.getFirstname());
    }

    static Stream<Arguments> firstnames() {
        return Stream.of(
                Arguments.arguments("Анна", "Анна"),
                Arguments.arguments("анна", null),
                Arguments.arguments("1434", null),
                Arguments.arguments("Ан6456", null)
        );
    }

    @ParameterizedTest
    @MethodSource("lastnames")
    void setLastname(String lastname, String expected) {
        personSpy.setLastname(lastname);
        assertEquals(expected, personSpy.getLastname());
    }

    static Stream<Arguments> lastnames() {
        return Stream.of(
                Arguments.arguments("Мамин-Сибиряк", "Мамин-Сибиряк"),
                Arguments.arguments("Иванова", "Иванова"),
                Arguments.arguments("иванова", null)
        );
    }

    @ParameterizedTest
    @MethodSource("patronymics")
    void setPatronymic(String patronymic, String expected) {
        personSpy.setLastname(patronymic);
        assertEquals(expected, personSpy.getPatronymic());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 127, 1000})
    void setAge(int age) {
        personSpy.setAge((byte) age);
        if (age < 0 || age > Byte.MAX_VALUE) {
            assertEquals(0, personSpy.getAge());
        } else {
            assertEquals(age, personSpy.getAge());
        }
    }

    static Stream<Arguments> patronymics() {
        return Stream.of(
                Arguments.arguments("Александровна", "Александровна"),
                Arguments.arguments("александровна", null),
                Arguments.arguments("1е34", null),
                Arguments.arguments("Ан6кп56а", null)
        );
    }

    @ParameterizedTest
    @ValueSource(bytes = {1, 18, 21})
    @NullSource
    void isMajor(Object age) {
        if (age != null) {
            final byte ageOfMajority = 18;
            personSpy.setAge((Byte) age);
            if ((Byte) age >= ageOfMajority) {
                assertTrue(personSpy.isMajor());
            } else {
                assertFalse(personSpy.isMajor());
            }
        } else {
            assertFalse(personSpy.isMajor());
        }
    }
}