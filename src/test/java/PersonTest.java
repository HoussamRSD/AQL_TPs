import org.example.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testGetFullName() {
        Person person = new Person("John", "Doe", 25);
        assertEquals("John Doe", person.getFullName());
    }

    @Test
    void testIsAdult_WhenAgeIs18OrMore() {
        Person person = new Person("Alice", "Smith", 18);
        assertTrue(person.isAdult());

        Person person2 = new Person("Bob", "Brown", 30);
        assertTrue(person2.isAdult());
    }

    @Test
    void testIsAdult_WhenAgeIsLessThan18() {
        Person person = new Person("Charlie", "Young", 17);
        assertFalse(person.isAdult());
    }
}
