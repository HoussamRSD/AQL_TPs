package TP1.LineCoverageTest;

import TP1.Correction.QuadraticEquation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo4Test {

    @Test
    void testDeltaNegative() {
        assertNull(QuadraticEquation.solve(1, 2, 5)); // delta < 0
    }

    @Test
    void testDeltaZero() {
        double[] result = QuadraticEquation.solve(1, 2, 1); // delta = 0
        assertArrayEquals(new double[]{-1.0}, result, 1e-9);
    }

    @Test
    void testDeltaPositive() {
        double[] result = QuadraticEquation.solve(1, -3, 2); // delta = 1
        assertArrayEquals(new double[]{2.0, 1.0}, result, 1e-9);
    }

    @Test
    void testAEqualZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 2, 1));
    }
}
