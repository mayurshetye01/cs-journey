package test.subset;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "ab7c";

        List<String> permutations = getStringPermutations(str);
        permutations.forEach(System.out::println);
    }

    //Get permutations of the input String such that order of charachters is same but case is changed
    private static List<String> getStringPermutations(final String str) {
        if(str == null || str.isEmpty())
            return new ArrayList<>();

        List<String> permutations = new ArrayList<>();
        permutations.add(str);

        for(int i = 0; i < str.length(); i++){
            int permutationSize = permutations.size();
            if(Character.isAlphabetic(str.charAt(i))) {
                for (int j = 0; j < permutationSize; j++) {
                    String permutation = permutations.get(j);
                    permutations.add(changeCaseOfChar(permutation, i));
                }
            }
        }

        return permutations;
    }

    private static String changeCaseOfChar(final String str, int index ){
        char[] chars = str.toCharArray();
        if(Character.isLowerCase(chars[index]))
            chars[index] = Character.toUpperCase(chars[index]);
        else
            chars[index] = Character.toLowerCase(chars[index]);
        return String.valueOf(chars);
    }
}
