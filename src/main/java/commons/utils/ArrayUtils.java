package commons.utils;

public class ArrayUtils {

    private ArrayUtils() {
        throw new UnsupportedOperationException();
    }

    public static void swap(int index1, int index2, Object[] array) {
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
