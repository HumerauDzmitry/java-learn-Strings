package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class RemoveGivenCharacterFromStringTest {
    RemoveGivenCharacterFromString removeGivenCharacterFromString;

    @BeforeEach
    void setUp() {
        removeGivenCharacterFromString = new RemoveGivenCharacterFromString();
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeTrueConvertNumericStringToInt() {
        assertEquals((removeGivenCharacterFromString.getStringWithoutGivenCharacter("abcdbef", 'b').get()), "acdef");
        assertEquals((removeGivenCharacterFromString.getStringWithoutGivenCharacter("abcdbef", ' ').get()), "abcdbef");
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeFalseConvertNumericStringToInt() {
        assertNotEquals((removeGivenCharacterFromString.getStringWithoutGivenCharacter("abcdbef", 'b').get()), "acdbef");
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyGetStringWithoutGivenCharacter() {
        assertEquals(removeGivenCharacterFromString.getStringWithoutGivenCharacter("", ' '), Optional.empty());
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerExceptionConvertStrToMap() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            removeGivenCharacterFromString.getStringWithoutGivenCharacter(null, ' ');
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }
}