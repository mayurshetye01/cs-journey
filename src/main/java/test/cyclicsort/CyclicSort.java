package test.cyclicsort;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 4, 3, 2};
        cyclicSort(arr);
        for (Integer elem : arr) {
            System.out.println(elem + ",");
        }
    }

    private static void cyclicSort(final int[] arr) {
        int i = 0;
        while(i < arr.length){
            if(arr[i] != (i+1)){
                int temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
            }
            else
                i++;
        }
    }
}
