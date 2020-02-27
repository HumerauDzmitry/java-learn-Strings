package com.humerau.developer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.*;

class AllPermutationsOfStringTest {

    AllPermutationsOfString allPermutationsOfString;

    @BeforeEach
    void setUp() {
        allPermutationsOfString = new AllPermutationsOfString();
    }

    @DisplayName("Test string is empty")
    @Test
    void shouldBeEmptyPermutations() {
        allPermutationsOfString.permutations("");
        Set<String> result = allPermutationsOfString.getAllStringPermutations();
        assertTrue(result.isEmpty());
    }

    @DisplayName("Test string is null")
    @Test
    void shouldBeNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            allPermutationsOfString.permutations(null);
        });
            assertEquals("str is marked non-null but is null", exception.getMessage());
    }

    @DisplayName("Test for correctness")
    @Test
    void shouldBeuSuccessful() {
        allPermutationsOfString.permutations("123");
        TreeSet<String> actualValues = new TreeSet<>();
        actualValues.add("132");
        actualValues.add("123");
        actualValues.add("213");
        actualValues.add("231");
        actualValues.add("312");
        actualValues.add("321");
        assertEquals(allPermutationsOfString.getAllStringPermutations(), actualValues);
    }
}