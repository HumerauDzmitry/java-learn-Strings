package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class HighestOccurredCharacterInStringTest {

    HighestOccurredCharacterInString highestOccurredCharacterInString;

    @BeforeEach
    void setUp() {
        highestOccurredCharacterInString = new HighestOccurredCharacterInString();
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyGetMapFromString() {
        assertEquals(highestOccurredCharacterInString.getMapFromString(""), Collections.emptyMap());
    }

    @DisplayName("Test string is null")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            highestOccurredCharacterInString.getMapFromString(null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulGetMapFromString() {
        assertEquals(highestOccurredCharacterInString.getMapFromString("112222333333333334444").size(), 4);
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulGetMapFromString() {
        assertNotEquals(highestOccurredCharacterInString.getMapFromString("112222333333333334444").size(), 5);
    }

    @DisplayName("Test map is empty")
    @Test
    void shouldBeEmptyGetListMostCommonCharacter() {
        assertEquals(highestOccurredCharacterInString.getListMostCommonCharacter(Collections.emptyMap()), Collections.EMPTY_LIST);
    }

    @DisplayName("Test map is null")
    @Test
    void shouldBeNullPointerExceptionGetListMostCommonCharacter() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            highestOccurredCharacterInString.getListMostCommonCharacter(null);
        });
        assertNull(exception.getMessage());
    }
}