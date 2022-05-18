package test.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1,3,5};

        List<List<Integer>> permutations = getPermutations(arr);

        for(List<Integer> permutation : permutations){
            for(Integer elem: permutation){
                System.out.print(elem + ",");
            }
            System.out.println();
        }
    }

    // Permutation of a sequence is all the possible ways in which a sequence can be arranged
    private static List<List<Integer>> getPermutations(final int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());

        for(Integer curr: arr){
            int size = permutations.size();
            for(int i = 0; i < size; i++){
                List<Integer> oldPermutation = permutations.poll();
                for(int j = 0; j <= oldPermutation.size(); j++){
                    List<Integer> newPermutation = new LinkedList<>(oldPermutation);
                    newPermutation.add(j,curr);

                    if(newPermutation.size() == arr.length)
                        result.add(newPermutation);
                    else
                        permutations.add(newPermutation);
                }
            }
        }

        return result;
    }
}
