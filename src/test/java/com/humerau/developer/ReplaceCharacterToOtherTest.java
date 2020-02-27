package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class ReplaceCharacterToOtherTest {
    ReplaceCharacterToOther replaceCharacterToOther;

    @BeforeEach
    void setUp() {
        replaceCharacterToOther = new ReplaceCharacterToOther();
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulGetStringWithReplacedCharacters() {
        assertEquals((replaceCharacterToOther.getStringWithReplacedCharacters("Java is Great", " ", "%20").get()), "Java%20is%20Great");
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulGetStringWithReplacedCharacters() {
        assertNotEquals((replaceCharacterToOther.getStringWithReplacedCharacters("Java is Great", " ", "%20").get()), "Java is Great");
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyGetStringWithReplacedCharacters() {
        assertEquals(replaceCharacterToOther.getStringWithReplacedCharacters("", "q", "r"), Optional.empty());
        assertEquals(replaceCharacterToOther.getStringWithReplacedCharacters("Java is Great", "", "r"), Optional.empty());
        assertEquals(replaceCharacterToOther.getStringWithReplacedCharacters("Java is Great", "q", ""), Optional.empty());
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            replaceCharacterToOther.getStringWithReplacedCharacters(null, "q", "r");
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());

        Throwable exception2 = assertThrows(NullPointerException.class, () -> {
            replaceCharacterToOther.getStringWithReplacedCharacters("Java is Great", null, "r");
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());

        Throwable exception3 = assertThrows(NullPointerException.class, () -> {
            replaceCharacterToOther.getStringWithReplacedCharacters("Java is Great", "q", null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }
}