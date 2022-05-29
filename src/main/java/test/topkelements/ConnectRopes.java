package test.topkelements;

import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectRopes {
    public static void main(String[] args) {
        int[] arr = {1,3,11,5};

        System.out.println(getMinCostToConnectRopes(arr));
    }

    private static int getMinCostToConnectRopes(final int[] arr) {
        if(arr == null || arr.length == 0)
            throw new UnsupportedOperationException();

        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));

        for(Integer num: arr)
            minHeap.add(num);

        int cost = 0;
        while (minHeap.size() > 1){
            int temp = minHeap.poll() + minHeap.poll();
            minHeap.add(temp);
            cost += temp;
        }

        return cost;
    }
}
