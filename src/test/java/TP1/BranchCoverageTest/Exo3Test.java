package TP1.BranchCoverageTest;

import TP1.Correction.BinarySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo3Test {

    @Test
    void testBranchMidEqualsElement() {
        int[] arr = {2, 4, 6};
        assertEquals(1, BinarySearch.binarySearch(arr, 4)); // branch: mid == element
    }

    @Test
    void testBranchMidLessThanElement() {
        int[] arr = {1, 3, 5, 7};
        assertEquals(3, BinarySearch.binarySearch(arr, 7)); // branch: mid < element
    }

    @Test
    void testBranchMidGreaterThanElement() {
        int[] arr = {2, 4, 6, 8};
        assertEquals(-1, BinarySearch.binarySearch(arr, 1)); // branch: mid > element
    }
}

