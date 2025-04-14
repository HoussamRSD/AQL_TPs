package TP1.LineCoverageTest;

import TP1.Correction.FizzBuzz;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo6Test {

    @Test
    void testFizzBuzzDivisibleBy15() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    @Test
    void testFizzDivisibleBy3Only() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
    }

    @Test
    void testBuzzDivisibleBy5Only() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    void testNotDivisibleBy3Or5() {
        assertEquals("7", FizzBuzz.fizzBuzz(7));
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-5));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(1));
    }
}

