package TP1.BranchCoverageTest;

import TP1.Correction.FizzBuzz;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo6Test {

    @Test
    void testBranchFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45)); // divisible by 3 and 5
    }

    @Test
    void testBranchFizzOnly() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6)); // divisible by 3
    }

    @Test
    void testBranchBuzzOnly() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(20)); // divisible by 5
    }

    @Test
    void testBranchNone() {
        assertEquals("8", FizzBuzz.fizzBuzz(8)); // not divisible
    }

    @Test
    void testBranchInvalid() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(1));
    }
}

