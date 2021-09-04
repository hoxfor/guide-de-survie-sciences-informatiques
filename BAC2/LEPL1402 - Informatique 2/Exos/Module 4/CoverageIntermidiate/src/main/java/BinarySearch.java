public class BinarySearch{

    /**
     * Find a value in an integer array
     *
     * @param array A non-null array of distinct integer
     *              values sorted in increasing order
     * @param value The value to look for in the array
     * @return The index of the value in the array of -1
     *         if the value is not in the array
     */
    public static int binarySearch(int [] array, int value) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            if (array[lo] == value)
                return lo;
            if (array[hi] == value)
                return hi;

            int mid = lo + (hi - lo)/2;

            if (array[mid] == value)
                return mid;

            if (array[mid] > value)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }
}