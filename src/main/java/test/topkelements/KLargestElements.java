package test.topkelements;

import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElements {

    public static void main(String[] args) {
        int[] unsortedArr = {3,5,1,23,34,12,56,111,23,25,67,45};
        int k = 3;
        int[] result = getKLargestElements(unsortedArr, k);

        for (Integer num : result) {
            System.out.print(num + ",");
        }

    }

    private static int[] getKLargestElements(final int[] unsortedArr, int k) {
        if(unsortedArr == null || unsortedArr.length == 0 || k > unsortedArr.length)
            throw new UnsupportedOperationException();

        //Min Heap
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));

        for(int i = 0; i < k; i++)
            minHeap.add(unsortedArr[i]);

        for(int i = k; i < unsortedArr.length; i++){
            int curr = unsortedArr[i];
            int min = minHeap.peek();

            if(curr > min){
                minHeap.poll();
                minHeap.add(curr);
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--)
            result[i] = minHeap.remove();

        return result;
    }
}
