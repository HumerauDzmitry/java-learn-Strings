package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ReverseTest {
    Reverse reverse;

    @BeforeEach
    void setUp() {
        reverse = new Reverse();
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulExecuteReversString() {
        assertEquals((reverse.executeReversString("abcdef123").get()), "321fedcba");
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulExecuteReversString() {
        assertNotEquals((reverse.executeReversString("abcdef123").get()), "abcdef123");
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyExecuteReversString() {
        assertEquals(reverse.executeReversString(""), Optional.empty());
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerExceptionExecuteReversString() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            reverse.executeReversString(null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }
}