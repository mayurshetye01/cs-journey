package common;

import ch06.s2.HeapPriorityQueue;
import datastructures.PriorityQueue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {

    @Test
    public void testPriorityQueue(){
        List<Integer> prioritiesList = new ArrayList<>();
        prioritiesList.add(4);
        prioritiesList.add(7);
        prioritiesList.add(0);
        prioritiesList.add(2);
        prioritiesList.add(20);
        prioritiesList.add(1);
        prioritiesList.add(1);

        PriorityQueue<Integer> priorityQueue = new HeapPriorityQueue<>(prioritiesList);
        assertEquals(prioritiesList.size(), priorityQueue.size());
        assertEquals(priorityQueue.pop(), 20);
        assertEquals(priorityQueue.pop(), 7);
        assertEquals(priorityQueue.pop(), 4);
        assertEquals(priorityQueue.pop(), 2);
        assertEquals(priorityQueue.pop(), 1);
        assertEquals(priorityQueue.pop(), 1);
        assertEquals(priorityQueue.pop(), 0);
    }
}
