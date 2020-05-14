package ch10.s1;

import datastructures.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTester {

    private Queue<Integer> getQueueInstance() {
        return new ArrayQueue<>();
    }

    @Test
    void testEnqueue() {
        Queue<Integer> queue = getQueueInstance();
        for (int i = 0; i < 100; i++)
            queue.enqueue(i);

        assertEquals(0, queue.deque());
    }

    @Test
    void testDeque() {

        Queue<Integer> queue = getQueueInstance();
        for (int i = 0; i < 100; i++)
            queue.enqueue(i);

        for (int i = 0; i < 100; i++)
            assertEquals(i, queue.deque());
    }

    @Test
    void testEmptyQueue() {
        Queue<Integer> queue = getQueueInstance();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.deque();
        queue.deque();
        assertFalse(queue.isEmpty());
        queue.deque();
        assertTrue(queue.isEmpty());

        assertThrows(Exception.class, queue::deque);
    }

}
