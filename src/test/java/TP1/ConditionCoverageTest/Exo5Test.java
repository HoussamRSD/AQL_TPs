package TP1.ConditionCoverageTest;

import TP1.Correction.RomanNumeral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo5Test {

    @Test
    void testConditionNLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
    }

    @Test
    void testConditionNGreaterThan3999() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4001));
    }

    @Test
    void testConditionValidInput() {
        assertDoesNotThrow(() -> RomanNumeral.toRoman(1999));
    }

    @Test
    void testResultOfComplexNumber() {
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999)); // test max val
    }
}
