package TP0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    // Classe d’équivalence valide : n ≥ 0
    @Test
    void testFactorialOfZero() {
        assertEquals(1, Factorial.factorial(0)); // cas limite
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, Factorial.factorial(1));
    }

    @Test
    void testFactorialOfFive() {
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    void testFactorialOfTen() {
        assertEquals(3628800, Factorial.factorial(10));
    }

    // Classe d’équivalence invalide : n < 0
    @Test
    void testFactorialNegativeNumberShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }

    // Cas limite supérieur (attention à l’overflow pour int)
    @Test
    void testFactorialOfThirteen() {
        assertEquals(6227020800L ,(double) Factorial.factorial(13)); // Dépasse int !
    }
}

