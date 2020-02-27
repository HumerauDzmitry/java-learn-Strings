package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsInSentenceTest {
    ReverseWordsInSentence reverseWordsInSentence;

    @BeforeEach
    void setUp() {
        reverseWordsInSentence = new ReverseWordsInSentence();
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulGetInvertedWord() {
        assertEquals((reverseWordsInSentence.getInvertedWord("abc def 123 456").get()), "456 123 def abc");
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulGetInvertedWord() {
        assertNotEquals((reverseWordsInSentence.getInvertedWord("abc def 123 456").get()), "abc def 123 456");
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyGetInvertedWord() {
        assertEquals(reverseWordsInSentence.getInvertedWord(""), Optional.empty());
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            reverseWordsInSentence.getInvertedWord(null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }
}