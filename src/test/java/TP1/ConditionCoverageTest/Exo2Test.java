package TP1.ConditionCoverageTest;

import TP1.Correction.Anagram;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo2Test {

    @Test
    void testS1IsNullConditionTrue() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }

    @Test
    void testS2IsNullConditionTrue() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    @Test
    void testBothStringsNotNullConditionFalse() {
        assertDoesNotThrow(() -> Anagram.isAnagram("a", "a"));
    }

    @Test
    void testLetterCountConditionTrue() {
        assertFalse(Anagram.isAnagram("abc", "def")); // c != 0
    }

    @Test
    void testLetterCountConditionFalse() {
        assertTrue(Anagram.isAnagram("restful", "fluster")); // c == 0 for all
    }
}

