package TP0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void testSetAndGet() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 1, 5);
        assertEquals(5, matrix.get(0, 1));
    }

    @Test
    void testAddValidMatrices() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(2);
        m1.set(0, 0, 1);
        m1.set(1, 1, 2);
        m2.set(0, 0, 3);
        m2.set(1, 1, 4);

        m1.add(m2);

        assertEquals(4, m1.get(0, 0));
        assertEquals(6, m1.get(1, 1));
    }

    @Test
    void testAddWithNullMatrixThrowsException() {
        Matrix m1 = new Matrix(2);
        assertThrows(NullPointerException.class, () -> m1.add(null));
    }

    @Test
    void testAddWithDifferentSizeThrowsException() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> m1.add(m2));
    }

    @Test
    void testMultiplyValidMatrices() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(2);

        // m1 = [[1, 2], [3, 4]]
        m1.set(0, 0, 1); m1.set(0, 1, 2);
        m1.set(1, 0, 3); m1.set(1, 1, 4);

        // m2 = [[2, 0], [1, 2]]
        m2.set(0, 0, 2); m2.set(0, 1, 0);
        m2.set(1, 0, 1); m2.set(1, 1, 2);

        m1.multiply(m2);

        // result = [[1*2+2*1, 1*0+2*2] = [4,4], [3*2+4*1, 3*0+4*2] = [10,8]]
        assertEquals(4, m1.get(0, 0));
        assertEquals(4, m1.get(0, 1));
        assertEquals(10, m1.get(1, 0));
        assertEquals(8, m1.get(1, 1));
    }

    @Test
    void testMultiplyWithNullMatrixThrowsException() {
        Matrix m1 = new Matrix(2);
        assertThrows(NullPointerException.class, () -> m1.multiply(null));
    }

    @Test
    void testMultiplyWithDifferentSizeThrowsException() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> m1.multiply(m2));
    }

    @Test
    void testTranspose() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 1, 3);
        matrix.set(1, 0, 7);

        matrix.transpose();

        assertEquals(7, matrix.get(0, 1));
        assertEquals(3, matrix.get(1, 0));
    }

    @Test
    void testToString() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(1, 0, 3);
        matrix.set(1, 1, 4);

        String expected = "[1, 2]\n[3, 4]\n";
        assertEquals(expected, matrix.toString());
    }
}

