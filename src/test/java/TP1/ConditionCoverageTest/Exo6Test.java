package TP1.ConditionCoverageTest;

import TP1.Correction.FizzBuzz;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo6Test {

    @Test
    void testConditionNLessOrEqualToOne() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(1));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
    }

    @Test
    void testConditionFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(60));
    }

    @Test
    void testConditionFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(18));
    }

    @Test
    void testConditionBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(25));
    }

    @Test
    void testConditionDefaultCase() {
        assertEquals("13", FizzBuzz.fizzBuzz(13));
    }
}

