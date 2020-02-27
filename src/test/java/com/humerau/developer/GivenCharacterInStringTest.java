package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class GivenCharacterInStringTest {

    GivenCharacterInString givenCharacterInString;

    @BeforeEach
    void setUp() {
        givenCharacterInString = new GivenCharacterInString();
    }

    @DisplayName("Test string and char is empty")
    @Test
    void shouldBeEmptyGetOccurrenceCharacterInString() {
        assertEquals(givenCharacterInString.getOccurrenceCharacterInString("", 'w'), Optional.empty());
        assertEquals(givenCharacterInString.getOccurrenceCharacterInString("123456", ' '), Optional.empty());
    }

    @DisplayName("Test string is null")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            givenCharacterInString.getOccurrenceCharacterInString(null, '2');
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulGetOccurrenceCharacterInString() {
        assertEquals(givenCharacterInString.getOccurrenceCharacterInString("123234562", '2').get(), 3);
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulGetOccurrenceCharacterInString() {
        assertNotEquals(givenCharacterInString.getOccurrenceCharacterInString("123234562", '2').get(), 4);
    }

}