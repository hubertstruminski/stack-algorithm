package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import codecool.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StaticStackTest {

    private StaticStack staticStack;

    @BeforeEach
    void setUp() {
        staticStack = new StaticStack(1);
    }

    @Test
    void testMethodAddsElementToStack() throws StackOverflowException {
        staticStack.push(21);

        assertEquals(1, staticStack.size());
    }

    @Test
    void testIfStackIsFullThrowStackOverflowException() throws StackOverflowException {
        staticStack.push(47);

        assertThrows(StackOverflowException.class, () -> {staticStack.push(17);});
    }

    @Test
    void testStackIsEmptyThrowStackUnderflowException() {
        StaticStack staticStack = new StaticStack(0);

        assertThrows(StackUnderflowException.class, () -> {staticStack.pop();});
    }

    @Test
    void testMethodPopElementFromStack() throws StackOverflowException, StackUnderflowException {
        StaticStack staticStack = new StaticStack(2);
        staticStack.push(24);
        staticStack.push(11);


        assertEquals(11, staticStack.pop());
        assertEquals(1, staticStack.size());
    }

    @Test
    void testMethodPeekReturnLastElement() throws StackOverflowException, StackUnderflowException {
        StaticStack staticStack = new StaticStack(2);
        staticStack.push(4);
        staticStack.push(9);

        assertEquals(9, staticStack.peek());
    }



}