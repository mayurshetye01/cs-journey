package ch06.s1;

import services.Sorter;

public class HeapSorter<E extends Comparable<E>> implements Sorter<E> {

    @Override
    public void sort(E[] items) {
        buildMaxHeap(items);
        int heapSize = items.length;
        /**
         * Loop invariant - A[0] contains the largest element of the heap
         */
        for (int i = heapSize; i > 1; i--) {
            swap(items, 0, heapSize - 1);
            /**
             * After exchange largest element is at the other end of array in its final position
             * Hence, discard this element from the heap
             */
            heapSize--;
            maxHeapify(items, 0, heapSize);
        }
    }

    //Convert the input array to a max heap
    protected void buildMaxHeap(E[] arr) {
        int heapSize = arr.length;
        int endIndex = (int) Math.floor(heapSize / 2 - 1);
        for (int i = endIndex; i >= 0; i--)
            maxHeapify(arr, i, heapSize);
    }

    /**
     * Max heapify the array for the given root.
     * This would result in all children from the given root to be a max heap
     */
    protected void maxHeapify(E[] arr, int root, int heapSize) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        int largest = root;

        if (left < heapSize && arr[left].compareTo(arr[largest]) > 0)
            largest = left;
        if (right < heapSize && arr[right].compareTo(arr[largest]) > 0)
            largest = right;

        if (largest != root) {
            swap(arr, root, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    private void swap(E[] arr, int index1, int index2) {
        E temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
