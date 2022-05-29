package test.topkelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxDistinctElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1,2,3};
        int k = 1;
        int[] result = getMaxDistinctArr(arr, k);

        for (Integer elem : result) {
            System.out.print(elem + ",");
        }
    }

    private static int[] getMaxDistinctArr(final int[] arr, final int k) {
        if(arr == null || arr.length == 0 || k > arr.length)
            throw new UnsupportedOperationException();

        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(Integer elem: arr){
            if(frequencyMap.containsKey(elem))
                frequencyMap.put(elem, frequencyMap.get(elem) + 1);
            else
                frequencyMap.put(elem,1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((entry1, entry2) -> getFrequency(entry1) - getFrequency(entry2));

        int[] result = new int[arr.length - k];

        // Keep filing the result array with distinct numbers first, if not distinct add to minHeap
        int index = 0;
        for(Map.Entry<Integer,Integer> entry: frequencyMap.entrySet()){
            if(getFrequency(entry) == 1){
                result[index] = entry.getKey();
                index++;
                if(index >= result.length)
                    break;
            }
            else
                minHeap.add(entry);
        }

        // Next try to add each number from the heap to the array. Mark the index of the first duplicate element. Fill the array till its complete
        int firstDuplicateIndex = index;
        while ( !minHeap.isEmpty() && index < result.length){
            Map.Entry<Integer,Integer> entry = minHeap.poll();
            int num = entry.getKey();
            result[index] = num;
            index++;
            frequencyMap.put(num, entry.getValue() - 1);
        }

        //After the heap is empty keep filing the array with the least duplicate elements
        while (index < result.length){
            int duplicateNum = result[firstDuplicateIndex];
            if(frequencyMap.containsKey(duplicateNum)){
                result[index] = duplicateNum;
                frequencyMap.put(duplicateNum, frequencyMap.get(duplicateNum) - 1 );
                index++;
                if(frequencyMap.get(duplicateNum) == 0)
                    frequencyMap.remove(duplicateNum);
            }
            firstDuplicateIndex++;
        }

        return result;
    }

    private static int getFrequency(final Map.Entry<Integer, Integer> entry) {
        return entry.getValue();
    }
}
