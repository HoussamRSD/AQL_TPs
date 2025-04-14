package TP1.ConditionCoverageTest;

import TP1.Correction.BinarySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo3Test {

    @Test
    void testNullArrayThrows() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 10));
    }

    @Test
    void testFoundElementConditionTrue() {
        int[] arr = {1, 2, 3};
        assertEquals(1, BinarySearch.binarySearch(arr, 2)); // array[mid] == element
    }

    @Test
    void testLessThanCondition() {
        int[] arr = {1, 2, 3};
        assertEquals(2, BinarySearch.binarySearch(arr, 3)); // array[mid] < element
    }

    @Test
    void testGreaterThanCondition() {
        int[] arr = {1, 2, 3};
        assertEquals(-1, BinarySearch.binarySearch(arr, 0)); // array[mid] > element
    }
}
