package TP1.ConditionCoverageTest;

import TP1.Correction.QuadraticEquation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo4Test {

    @Test
    void testConditionAIsZeroTrue() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 2));
    }

    @Test
    void testConditionDeltaNegative() {
        assertNull(QuadraticEquation.solve(1, 1, 1)); // delta < 0
    }

    @Test
    void testConditionDeltaZero() {
        assertArrayEquals(new double[]{2.0}, QuadraticEquation.solve(1, -4, 4), 1e-9);
    }

    @Test
    void testConditionDeltaPositive() {
        double[] result = QuadraticEquation.solve(1, -5, 6); // delta = 1
        assertArrayEquals(new double[]{3.0, 2.0}, result, 1e-9);
    }
}

