package test.twopointers;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] sortedArrWithDuplicates = {2,3,6,9};
        final int lengthAfterRemovingDuplicates = removeDuplicates(sortedArrWithDuplicates);
        System.out.println("Length after removing duplicates : " + lengthAfterRemovingDuplicates);
        for (int i = 0; i < lengthAfterRemovingDuplicates; i++) {
            System.out.print(sortedArrWithDuplicates[i] + ",");
        }
    }

    private static int removeDuplicates(final int[] sortedArrWithDuplicates) {
        int current = 0;
        int nextNonDuplicate = 1;
        while(nextNonDuplicate < sortedArrWithDuplicates.length){
            if(sortedArrWithDuplicates[current] != sortedArrWithDuplicates[nextNonDuplicate]){
                sortedArrWithDuplicates[current+1] = sortedArrWithDuplicates[nextNonDuplicate];
                current++;
            }
            nextNonDuplicate++;
        }
        return current + 1;
    }
}
