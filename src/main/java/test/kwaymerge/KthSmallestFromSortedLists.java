package test.kwaymerge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KthSmallestFromSortedLists {
    public static void main(String[] args) {
        Integer[] l1 = {2,6,8};
        Integer[] l2 = {3,6,7};
        Integer[] l3 = {1,3,4};

        List<Integer[]> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        System.out.println(getKthSmallestFromMSortedLists(lists, 5));

    }

    private static int getKthSmallestFromMSortedLists(final List<Integer[]> lists, final int k) {
        if(lists == null || lists.isEmpty())
            throw new IllegalArgumentException();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));

        Map<Integer, Integer> currentIndicesMap = new HashMap<>();

        for(int listNumber = 0; listNumber < lists.size(); listNumber++){
            currentIndicesMap.put(listNumber, 0);
        }

        int kthSmallest = Integer.MAX_VALUE;
        int i = 0;
        while (i < k){
            for(int currentListNumber = 0; currentListNumber < lists.size(); currentListNumber++){
                Integer[] currArr = lists.get(currentListNumber);
                int currentListIndex = currentIndicesMap.get(currentListNumber);
                if(currentListIndex < currArr.length){
                    minHeap.add(currArr[currentListIndex]);
                    currentIndicesMap.put(currentListNumber, currentListIndex+1);
                }
            }
            if(minHeap.isEmpty())
                throw new IllegalArgumentException("Value of k is larger than the number of elements in all lists combined");

            kthSmallest = minHeap.poll();
            i++;
        }

        return kthSmallest;
    }


}
