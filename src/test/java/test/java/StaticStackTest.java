package test.java;

import org.junit.jupiter.api.Test;

import codecool.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StaticStackTest {

    private Integer number = 11;

    @Test
    void testMethodAddsElementToStack() throws StackOverflowException {
        StaticStack<Integer> staticStack = new StaticStack<>(1);
        staticStack.push(21);

        assertEquals(1, staticStack.size());
    }

    @Test
    void testIfStackIsFullThrowStackOverflowException() throws StackOverflowException {
        StaticStack<Integer> staticStack = new StaticStack<>(1);
        staticStack.push(47);

        assertThrows(StackOverflowException.class, () -> {staticStack.push(17);});
    }

    @Test
    void testStackIsEmptyThrowStackUnderflowException() {
        StaticStack<Integer> staticStackX = new StaticStack<>(2);

        assertThrows(StackUnderflowException.class, () -> {staticStackX.pop();});
    }

    @Test
    void testMethodPopElementFromStack() throws StackOverflowException, StackUnderflowException {
        StaticStack<Integer> staticStack = new StaticStack<>(2);
        staticStack.push(24);
        staticStack.push(11);

        assertEquals(number, staticStack.pop());
        assertEquals(1, staticStack.size());
    }

    @Test
    void testMethodPeekReturnLastElement() throws StackOverflowException, StackUnderflowException {
        StaticStack<Integer> staticStack = new StaticStack<>(2);

        staticStack.push(4);
        staticStack.push(11);

        assertEquals(number, staticStack.peek());
    }



}