package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringContainsOnlyDigitsTest {
    StringContainsOnlyDigits stringContainsOnlyDigits;

    @BeforeEach
    void setUp() {
        stringContainsOnlyDigits = new StringContainsOnlyDigits();
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulIsStringContainsOnlyDigits() {
        assertEquals((stringContainsOnlyDigits.isStringContainsOnlyDigits("123456")), true);
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulIsStringContainsOnlyDigits() {
        assertNotEquals((stringContainsOnlyDigits.isStringContainsOnlyDigits("1236y")), true);
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyIsStringContainsOnlyDigits() {
        assertEquals(stringContainsOnlyDigits.isStringContainsOnlyDigits(""), false);
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            stringContainsOnlyDigits.isStringContainsOnlyDigits(null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }
}