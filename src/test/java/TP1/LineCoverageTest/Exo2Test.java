package TP1.LineCoverageTest;

import TP1.Correction.Anagram;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo2Test {

    @Test
    void testValidAnagram() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
    }

    @Test
    void testAnagramWithSpacesAndCases() {
        assertTrue(Anagram.isAnagram("Listen", "Silent"));
    }

    @Test
    void testDifferentLengthStrings() {
        assertFalse(Anagram.isAnagram("abc", "ab"));
    }

    @Test
    void testNonAnagramSameLength() {
        assertFalse(Anagram.isAnagram("abcd", "abce"));
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }
}

