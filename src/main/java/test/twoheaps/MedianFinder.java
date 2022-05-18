package test.twoheaps;

import java.util.PriorityQueue;

public class MedianFinder {
    //Store the larger part of the numbers
    PriorityQueue<Integer> minHeap;

    //Store the smaller part of the numbers
    PriorityQueue<Integer> maxHeap;

    public MedianFinder(){
        this.maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a ));
        this.minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a, b ));
    }

    public void insertNum(int num){
        if(maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        // Rebalance the heap sizes. At any given point, max heap can have 1 element more than min heap or else both heap sizes must be equal
        if(maxHeap.size() > minHeap.size() + 1 )
            minHeap.add(maxHeap.poll());
        else if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() throws IllegalAccessException {
        if(maxHeap.isEmpty() && minHeap.isEmpty())
            throw new IllegalAccessException("No numbers added");

        if(maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek())/2.0 ;
        return maxHeap.peek();
    }

    public static void main(String[] args) throws IllegalAccessException {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.insertNum(3);
        medianFinder.insertNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.insertNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.insertNum(4);
        System.out.println(medianFinder.findMedian());
    }
}
