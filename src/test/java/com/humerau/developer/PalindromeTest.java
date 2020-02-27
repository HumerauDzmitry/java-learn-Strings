package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    Palindrome palindrome;

    @BeforeEach
    void setUp() {
        palindrome = new Palindrome();
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulIsPalindrome() {
        assertEquals((palindrome.isPalindrome("Radar")), true);
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulIsPalindrome() {
        assertEquals((palindrome.isPalindrome("12345")), false);
        assertEquals((palindrome.isPalindrome("")), false);
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerExceptionConvertStrToMap() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            palindrome.isPalindrome(null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }

}