public class Maximum {

    /**
     * Find the maximum in an array
     *
     * @param array A non-null and non empty array of integers
     * @return The maximum value in the array
     */
    public static int maximum(int [] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
