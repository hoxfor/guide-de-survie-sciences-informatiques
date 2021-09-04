import org.junit.Test;

import static org.junit.Assert.*;


public class Tests {

    /**
     * Generate a sorted array from [start ; end]
     *
     * @param start first elem in the array (inclusive)
     * @param end   last elem in the array (inclusive)
     * @return a sorted array
     */
    public int[] generateArray(int start, int end) {
        int length = Math.abs(end - start) + 1;
        int count = start;
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = count;
            count++;
        }
        return array;
    }

    @Test
    public void basicTest() {
        int[] array = generateArray(1, 10);
        int highValue = BinarySearch.binarySearch(array, 9);
        int smallValue = BinarySearch.binarySearch(array, 1);
        int middleValue = BinarySearch.binarySearch(array, 5);
        int notInArray = BinarySearch.binarySearch(array, 11);

        assertEquals(8, highValue);
        assertEquals(0, smallValue);
        assertEquals(4, middleValue);
        assertEquals(-1, notInArray);
    }

    @Test
    public void negativeValue() {
        int[] array = generateArray(-10, 10);
        int neg1 = BinarySearch.binarySearch(array, -7);

        assertEquals(3, neg1);

    }

}
