package TP1.LineCoverageTest;

import TP1.Correction.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @Test
    void testSimplePalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak"));
    }

    @Test
    void testPalindromeWithSpacesAndCase() {
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
    }

    @Test
    void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("bonjour"));
    }

    @Test
    void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    void testNullString() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }
}

