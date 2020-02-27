package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class FirstNonRepeatedCharacterTest {
    FirstNonRepeatedCharacter firstNonRepeatedCharacter;

    @BeforeEach
    void setUp() {firstNonRepeatedCharacter = new FirstNonRepeatedCharacter();

    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyConvertStrToMap() {
        assertTrue(firstNonRepeatedCharacter.convertStrToMap("").isEmpty());
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerExceptionConvertStrToMap() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            firstNonRepeatedCharacter.convertStrToMap(null);
        });
        assertEquals("str is marked non-null but is null", exception.getMessage());
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulConvertStrToMap() {
        Map<Character, Integer> actualMap = new LinkedHashMap<Character, Integer>();
        actualMap.put('a', 1);
        actualMap.put('b', 2);
        actualMap.put('c', 1);
        assertEquals(firstNonRepeatedCharacter.convertStrToMap("abcb"), actualMap);
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulConvertStrToMap() {
        Map<Character, Integer> actualMap = new LinkedHashMap<Character, Integer>();
        actualMap.put('a', 1);
        actualMap.put('b', 2);
        actualMap.put('c', 1);
        assertNotEquals(firstNonRepeatedCharacter.convertStrToMap("abcbb"), actualMap);
    }

    @DisplayName("Test map is Collection.emptyMap()")
    @Test
    void shouldBeEmptyGetFirstEntry() {
        assertTrue(firstNonRepeatedCharacter.getFirstEntry(Collections.emptyMap()).isEmpty());
    }

    @DisplayName("Test throw NullPointerException")
    @Test
    void shouldBeNullPointerExceptionGetFirstEntry() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            firstNonRepeatedCharacter.getFirstEntry(null);
        });
        assertEquals(null, exception.getMessage());
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeSuccessfulGetFirstEntry() {
        Map<Character, Integer> testMap = new LinkedHashMap<Character, Integer>();
        testMap.put('a', 2);
        testMap.put('b', 1);
        testMap.put('c', 2);
        assertEquals(firstNonRepeatedCharacter.getFirstEntry(testMap).get(), 'b');
    }

    @DisplayName("Test for wrong")
    @Test
    void shouldBeUnsuccessfulGetFirstEntry() {
        Map<Character, Integer> testMap = new LinkedHashMap<Character, Integer>();
        testMap.put('a', 2);
        testMap.put('b', 1);
        testMap.put('c', 2);
        assertNotEquals(firstNonRepeatedCharacter.getFirstEntry(testMap).get(), 'a');
    }
}