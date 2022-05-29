package test.topkelements;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestFinder {

    private final int k;
    private Queue<Integer> minHeap;

    public KthLargestFinder(int[] initialArr, int k){
        this.k = k;
        this.minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));

        for(int i = 0; i < k; i++)
            minHeap.add(initialArr[i]);

        for(int i = k; i < initialArr.length;i++){
            int curr = initialArr[i];
            if(curr > minHeap.peek()){
                minHeap.poll();
                minHeap.add(curr);
            }
        }
    }

    public int add(int num){
        if(num > minHeap.peek()){
            minHeap.poll();
            minHeap.add(num);
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,12,2,11};
        int k = 4;

        KthLargestFinder kthLargestFinder = new KthLargestFinder(arr,k);
        System.out.println(kthLargestFinder.add(6));
        System.out.println(kthLargestFinder.add(13));
        System.out.println(kthLargestFinder.add(4));
    }
}
