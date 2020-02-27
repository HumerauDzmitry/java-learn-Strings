package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringContainsAnotherStringTest {
    StringContainsAnotherString stringContainsAnotherString;

    @BeforeEach
    void setUp() {
        stringContainsAnotherString = new StringContainsAnotherString();
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulGetIndexOfOccurrenceString() {
        assertEquals((stringContainsAnotherString.getIndexOfOccurrenceString("123456", "345")), 2);
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulGetIndexOfOccurrenceString() {
        assertEquals((stringContainsAnotherString.getIndexOfOccurrenceString("123456", "349")), -1);
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyGetIndexOfOccurrenceString() {
        assertEquals(stringContainsAnotherString.getIndexOfOccurrenceString("", "69"), -1);
        assertEquals(stringContainsAnotherString.getIndexOfOccurrenceString("69", ""), -1);
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            stringContainsAnotherString.getIndexOfOccurrenceString(null, "9");
        });
        assertEquals("fullStr is marked non-null but is null", exception.getMessage());

        Throwable exception2 = assertThrows(NullPointerException.class, () -> {
            stringContainsAnotherString.getIndexOfOccurrenceString("null", null);
        });
        assertEquals("fullStr is marked non-null but is null", exception.getMessage());
    }
}