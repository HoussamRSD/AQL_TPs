package TP1.BranchCoverageTest;

import TP1.Correction.RomanNumeral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo5Test {

    @Test
    void testBranchIllegalArgumentLow() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
    }

    @Test
    void testBranchIllegalArgumentHigh() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    @Test
    void testBranchNormalConversion() {
        assertEquals("XX", RomanNumeral.toRoman(20)); // active plusieurs branches while
    }

    @Test
    void testBranchSingleSymbol() {
        assertEquals("V", RomanNumeral.toRoman(5));
    }
}

