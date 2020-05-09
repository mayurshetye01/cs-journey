package ch08.s1;

import annotations.Complexity;
import annotations.Quality;
import annotations.Stage;
import services.Sorter;

@Quality(Stage.TESTED)
public class CountSorter implements Sorter<Integer> {

    @Override
    @Complexity(value = "O(n)", explanation = "Assuming that the values are small finite values")
    public void sort(Integer[] items) {
        /**
         * To handle negative integers, find the min and max value in the items
         */
        int maxVal = Integer.MIN_VALUE;
        int offset = Integer.MAX_VALUE;
        for(Integer item : items){
            if(item.compareTo(offset) < 0)
                offset = item;
            if(item.compareTo(maxVal) > 0)
                maxVal = item;
        }

        final Integer[] counts = new Integer[(maxVal - offset) + 1];

        //Initialize counts to 0
        for (int i = 0; i < counts.length; i++)
            counts[i] = 0;

        //counting the numbers, after this each item in count corresponds to how many of that item there was
        //in the original array
        for(Integer item : items){
            counts[item - offset]++;
        }

        //After below loop, every index will represent
        // the number of items in original array less than or equal to that index
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        Integer[] target = new Integer[items.length];

        //Use the counts information to determine position of each item(element) int the final output
        //As there can be more than one items of same value, decrement the count once copied to final array
        for (int j = items.length - 1; j >= 0; j--) {
            int curr = items[j];
            int finalPos = counts[curr - offset] - 1;
            target[finalPos] = curr;
            counts[curr - offset]--;
        }

        //Copy the result back to original array
        System.arraycopy(target, 0, items, 0, items.length);

    }
}
