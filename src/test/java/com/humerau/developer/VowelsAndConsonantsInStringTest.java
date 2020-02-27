package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class VowelsAndConsonantsInStringTest {
    VowelsAndConsonantsInString vowelsAndConsonantsInString;

    @BeforeEach
    void setUp() {
        vowelsAndConsonantsInString = new VowelsAndConsonantsInString();
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulGetVowelsAndConsonantsInString() {
        assertEquals(Arrays.toString(vowelsAndConsonantsInString.getVowelsAndConsonantsInString(" Abc_def ")), Arrays.toString(new int[]{2,4,0,3}));
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulGetVowelsAndConsonantsInString() {
        assertNotEquals(Arrays.toString(vowelsAndConsonantsInString.getVowelsAndConsonantsInString(" Abc_def ")), Arrays.toString(new int[]{0,4,0,3}));
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyGetVowelsAndConsonantsInString() {
        assertEquals(Arrays.toString(vowelsAndConsonantsInString.getVowelsAndConsonantsInString("")), Arrays.toString(new int[]{0,0,0,0}));
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            vowelsAndConsonantsInString.getVowelsAndConsonantsInString(null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }
}