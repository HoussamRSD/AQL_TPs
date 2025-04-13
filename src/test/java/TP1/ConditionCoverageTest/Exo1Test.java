package TP1.ConditionCoverageTest;

import TP1.Correction.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo1Test {

    @Test
    void testConditionTrueMismatch() {
        assertFalse(Palindrome.isPalindrome("java")); // condition vraie : charAt(i) != charAt(j)
    }

    @Test
    void testConditionFalseMatch() {
        assertTrue(Palindrome.isPalindrome("laval")); // condition fausse : tous les charAt(i) == charAt(j)
    }

    @Test
    void testConditionNullInput() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null)); // condition s == null vraie
    }

    @Test
    void testConditionNonNullInput() {
        assertDoesNotThrow(() -> Palindrome.isPalindrome("lol")); // condition s == null fausse
    }
}

