package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumericStringToIntTest {

    NumericStringToInt numericStringToInt;

    @BeforeEach
    void setUp() {
        numericStringToInt = new NumericStringToInt();
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeTrueConvertNumericStringToInt() {
        assertEquals((numericStringToInt.convertNumericStringToInt("123456").get()), 123456);
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeFalseConvertNumericStringToInt() {
        assertNotEquals((numericStringToInt.convertNumericStringToInt("123").get()), 321);
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyGetFirstEntry() {
        assertTrue(numericStringToInt.convertNumericStringToInt("").isEmpty());
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerExceptionConvertStrToMap() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            numericStringToInt.convertNumericStringToInt(null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }
}