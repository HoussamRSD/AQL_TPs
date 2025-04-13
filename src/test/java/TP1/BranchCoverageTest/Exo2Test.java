package TP1.BranchCoverageTest;

import TP1.Correction.Anagram;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo2Test {

    @Test
    void testNullInputs() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    @Test
    void testLengthMismatch() {
        assertFalse(Anagram.isAnagram("abc", "ab"));
    }

    @Test
    void testMismatchInLetterCount() {
        assertFalse(Anagram.isAnagram("abcd", "abce"));
    }

    @Test
    void testValidBranchAllMatch() {
        assertTrue(Anagram.isAnagram("elvis", "lives"));
    }
}

