package TP0;

import TP0.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testPushAndPeek() {
        Stack stack = new Stack();
        stack.push(5);
        assertEquals(5, stack.peek());
    }

    @Test
    void testPushAndPop() {
        Stack stack = new Stack();
        stack.push(10);
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsEmpty_WhenStackIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsEmpty_WhenStackIsNotEmpty() {
        Stack stack = new Stack();
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testSize() {
        Stack stack = new Stack();
        assertEquals(0, stack.size());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    void testPopOnEmptyStack_ShouldThrowException() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void testPeekOnEmptyStack_ShouldThrowException() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    void testExpandArray() {
        Stack stack = new Stack();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertEquals(15, stack.size());
        assertEquals(14, stack.peek());
    }
}

