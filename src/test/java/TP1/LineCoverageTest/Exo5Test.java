package TP1.LineCoverageTest;

import TP1.Correction.RomanNumeral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo5Test {

    @Test
    void testBasicConversion() {
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("X", RomanNumeral.toRoman(10));
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("XL", RomanNumeral.toRoman(40));
        assertEquals("M", RomanNumeral.toRoman(1000));
    }

    @Test
    void testLimits() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }
}

