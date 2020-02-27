package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
    Anagram anagram = new Anagram();

    @BeforeEach
    void setUp() {anagram = new Anagram();}

    @Test
    void shouldBeSuccessfulIsAnagram () {
        assertTrue(anagram.isAnagram("123456", "654321"));
        assertTrue(anagram.isAnagram("aBcDe", "EdCbA"));
        assertTrue(anagram.isAnagram("", ""));
    }

    @Test
    void shouldBeUnsuccessfulIsAnagram () {
        assertFalse(anagram.isAnagram("123456", "987654"));
        assertFalse(anagram.isAnagram("aBcDeTt", "EdCbApP"));
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerExceptionIsAnagram() {
        Throwable exception1 = assertThrows(NullPointerException.class, () -> {
            anagram.isAnagram(null, "123");
        });
        assertEquals(null, exception1.getMessage());

        Throwable exception2 = assertThrows(NullPointerException.class, () -> {
            anagram.isAnagram("null", null);
        });
        assertEquals(null, exception2.getMessage());

    }

    @DisplayName("Test String is empty")
    @Test
    void shouldBeEmptyIsAnagram () {
        assertFalse(anagram.isAnagram("", "987654"));
        assertFalse(anagram.isAnagram("aBcDeTt", ""));
    }
}