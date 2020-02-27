package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicateCharactersFromStringTest {
    RemoveDuplicateCharactersFromString removeDuplicateCharactersFromString;

    @BeforeEach
    void setUp() {
        removeDuplicateCharactersFromString = new RemoveDuplicateCharactersFromString();
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulGetStringWithoutDuplicateCharacters() {
        assertEquals((removeDuplicateCharactersFromString.getStringWithoutDuplicateCharacters("123123123abcabcabc").get()), "123abc");
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulGetStringWithoutDuplicateCharacters() {
        assertNotEquals((removeDuplicateCharactersFromString.getStringWithoutDuplicateCharacters("123").get()), "321");
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyGetStringWithoutDuplicateCharacters() {
        assertEquals(removeDuplicateCharactersFromString.getStringWithoutDuplicateCharacters(""), Optional.empty());
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            removeDuplicateCharactersFromString.getStringWithoutDuplicateCharacters(null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }
}