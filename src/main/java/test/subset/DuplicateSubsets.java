package test.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateSubsets {
    public static void main(String[] args) {

        //Input array has duplicate numbers but result should have distinct subsets only
        int[] arr = {1,3,5,3};

        List<List<Integer>> subsets = getSubsets(arr);
        for(List<Integer> subset : subsets){
            for(Integer elem: subset){
                System.out.print(elem + ",");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> getSubsets(final int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        int startIndex = 0;
        int endIndex = 0;

        for(int i = 0; i < arr.length; i++){
            startIndex = 0;
            if(i-1 >= 0 && arr[i-1] == arr[i])
                startIndex = endIndex + 1;

            endIndex = subsets.size() - 1;
            for(int j = startIndex; j <= endIndex; j++){
                //It is important to create a NEW List using the subset
                List<Integer> subset = new ArrayList<>(subsets.get(j));
                subset.add(arr[i]);
                subsets.add(subset);
            }
        }

        return subsets;
    }
}
