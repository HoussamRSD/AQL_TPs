package TP1.BranchCoverageTest;

import TP1.Correction.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @Test
    void testPalindromeNormalBranch() {
        assertTrue(Palindrome.isPalindrome("radar")); // branche: false dans charAt(i) != charAt(j)
    }

    @Test
    void testNonPalindromeTriggersMismatchBranch() {
        assertFalse(Palindrome.isPalindrome("test")); // branche: true dans charAt(i) != charAt(j)
    }

    @Test
    void testNullThrowsException() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null)); // branche: s == null
    }
}

