package test.subset;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1,3,5};

        List<List<Integer>> subsets = getSubsets(arr);
        for(List<Integer> subset : subsets){
            for(Integer elem: subset){
                System.out.print(elem + ",");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> getSubsets(final int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for(Integer curr : arr){
            int subsetSize = subsets.size();
            for(int i = 0; i < subsetSize; i++){
                //It is important to create a NEW List using the subset
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(curr);
                subsets.add(subset);
            }
        }

        return subsets;
    }
}
