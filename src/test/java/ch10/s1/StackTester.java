package ch10.s1;

import datastructures.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTester {

    private Stack<Integer> getStackInstance(){
        return new ArrayStack<>();
    }

    @Test
    void testPush(){
        Stack<Integer> stack = getStackInstance();
        for( int i = 0 ; i < 100; i++)
            stack.push(i);

        assertEquals(99, stack.pop());
    }

    @Test
    void testPop(){

        Stack<Integer> stack = getStackInstance();
        for( int i = 0 ; i < 100; i++)
            stack.push(i);

        for(int i = 99; i >= 0; i--)
            assertEquals(i, stack.pop());
    }

    @Test
    void testEmptyStack(){
        Stack<Integer> stack = getStackInstance();
        assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());

        assertThrows(Exception.class, stack::pop);
    }

}
