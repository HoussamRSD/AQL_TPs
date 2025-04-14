package TP1.BranchCoverageTest;

import TP1.Correction.QuadraticEquation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo4Test {

    @Test
    void testBranchDeltaNegative() {
        assertNull(QuadraticEquation.solve(1, 1, 1)); // delta < 0
    }

    @Test
    void testBranchDeltaZero() {
        double[] result = QuadraticEquation.solve(1, -2, 1); // delta = 0
        assertArrayEquals(new double[]{1.0}, result, 1e-9);
    }

    @Test
    void testBranchDeltaPositive() {
        double[] result = QuadraticEquation.solve(1, 0, -1); // delta = 4
        assertArrayEquals(new double[]{1.0, -1.0}, result, 1e-9);
    }

    @Test
    void testBranchAZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
    }
}

