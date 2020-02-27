package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeInStringTest {
    LongestPalindromeInString longestPalindromeInString;

    @BeforeEach
    void setUp() {
        longestPalindromeInString = new LongestPalindromeInString();
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyGetLongestPalindromesInString() {
        assertEquals(longestPalindromeInString.getLongestPalindromesInString(""), Collections.EMPTY_LIST);
    }

    @DisplayName("Test string is null")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            longestPalindromeInString.getLongestPalindromesInString(null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulGetLongestPalindromesInString() {
        List<String> actualList = new ArrayList<String>();
        actualList.add("12344321");
        actualList.add("qwerrewq");
        assertEquals(longestPalindromeInString.getLongestPalindromesInString("123456 radar 12344321 lol qwerrewq abc"), actualList);
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulGetLongestPalindromesInString() {
        List<String> actualList = new ArrayList<String>();
        actualList.add("12344321");
        actualList.add("qwertrewq");
        assertNotEquals(longestPalindromeInString.getLongestPalindromesInString("123456 radar 12344321 lol qwerrewq abc"), actualList);
    }
}