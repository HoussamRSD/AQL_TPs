package TP0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    void testIsPrimeWithPrimes() {
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(3));
        assertTrue(Prime.isPrime(5));
        assertTrue(Prime.isPrime(7));
        assertTrue(Prime.isPrime(11));
        assertTrue(Prime.isPrime(13));
    }

    @Test
    void testIsPrimeWithNonPrimes() {
        assertFalse(Prime.isPrime(0));
        assertFalse(Prime.isPrime(1));
        assertFalse(Prime.isPrime(4));
        assertFalse(Prime.isPrime(6));
        assertFalse(Prime.isPrime(9));
        assertFalse(Prime.isPrime(15));
    }

    @Test
    void testIsPrimeWithNegativeNumbers() {
        assertFalse(Prime.isPrime(-1));
        assertFalse(Prime.isPrime(-5));
        assertFalse(Prime.isPrime(-11));
    }
}

