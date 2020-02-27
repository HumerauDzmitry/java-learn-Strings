package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidShuffleOfTwoStringTest {
    ValidShuffleOfTwoString validShuffleOfTwoString;

    @BeforeEach
    void setUp() {
        validShuffleOfTwoString = new ValidShuffleOfTwoString();
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulIsValidShuffleOfTwoString() {
        assertTrue((validShuffleOfTwoString.isValidShuffleOfTwoString("123456", "abcde", "12abcd34e56")));
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulIsValidShuffleOfTwoString() {
        assertNotEquals((validShuffleOfTwoString.isValidShuffleOfTwoString("123456", "abcde", "12abcd3e65")), true);
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyIsValidShuffleOfTwoString() {
        assertFalse(validShuffleOfTwoString.isValidShuffleOfTwoString("", "abcde", "abcde"));
        assertFalse(validShuffleOfTwoString.isValidShuffleOfTwoString("123456", "", "123456"));
        assertFalse(validShuffleOfTwoString.isValidShuffleOfTwoString("123456", "abcde", ""));
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            validShuffleOfTwoString.isValidShuffleOfTwoString(null, "23", "67");
        });
        assertEquals("str1 is marked non-null but is null", exception.getMessage());

        Throwable exception2 = assertThrows(NullPointerException.class, () -> {
            validShuffleOfTwoString.isValidShuffleOfTwoString("23",null,  "67");
        });
        assertEquals("str2 is marked non-null but is null", exception2.getMessage());

        Throwable exception3 = assertThrows(NullPointerException.class, () -> {
            validShuffleOfTwoString.isValidShuffleOfTwoString( "23", "67",null);
        });
        assertEquals("strFull is marked non-null but is null", exception3.getMessage());
    }
}