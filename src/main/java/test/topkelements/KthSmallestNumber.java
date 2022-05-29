package test.topkelements;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestNumber {
    public static void main(String[] args) {
        int[] arr = {1,4,2,11,34,21,22,18};
        System.out.println(getKthSmallestNumber(arr, 2));
    }

    private static int getKthSmallestNumber(final int[] arr, int k) {
        if(arr == null || arr.length == 0 || k > arr.length)
            throw new UnsupportedOperationException();

        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int i = 0; i < k; i++)
            maxHeap.add(arr[i]);

        for(int i = k; i < arr.length;i++){
            if(arr[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

        return maxHeap.peek();
    }
}
