package com.humerau.developer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.*;

class DuplicateCharactersTest {
    DuplicateCharacters duplicateCharacters = new DuplicateCharacters();

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyGetSetDuplicateCharactersFalse() {
        assertTrue(duplicateCharacters.getSetDuplicateCharacters("123456").isEmpty());
        assertTrue(duplicateCharacters.getSetDuplicateCharacters("").isEmpty());
    }

    @DisplayName("Test string is null")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            duplicateCharacters.getSetDuplicateCharacters(null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulGetSetDuplicateCharactersFalse() {
        Set<Character> actualSet = new TreeSet<Character>();
        actualSet.add('2');
        actualSet.add('5');
        assertEquals(duplicateCharacters.getSetDuplicateCharacters("1232455"), actualSet);
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulGetSetDuplicateCharactersFalse() {
        Set<Character> actualSet = new TreeSet<Character>();
        actualSet.add('2');
        actualSet.add('5');
        assertNotEquals(duplicateCharacters.getSetDuplicateCharacters("123245588"), actualSet);
    }
}