package TP0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testGetFullName() {
        Person person = new Person("Houssam", "ZOUAOUI", 25);
        assertEquals("Houssam ZOUAOUI", person.getFullName());
    }

    @Test
    void testIsAdult_WhenAgeIs18OrMore() {
        Person person = new Person("Adem", "RAMDANE", 18);
        assertTrue(person.isAdult());

        Person person2 = new Person("Zakaria", "BOUGADI", 30);
        assertTrue(person2.isAdult());
    }

    @Test
    void testIsAdult_WhenAgeIsLessThan18() {
        Person person = new Person("Yahia", "HANANI", 17);
        assertFalse(person.isAdult());
    }
}
