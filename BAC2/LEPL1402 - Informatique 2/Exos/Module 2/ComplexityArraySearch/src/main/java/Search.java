
public class Search {

    /**
     * @param tab is an ordered array of int.
     * @return index of elem or -1
     */
    public static int search(int[] tab, int elem) {
        int low = 0;
        int high = tab.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int middleValue = tab[middle];

            if (middleValue < elem) {
                low = middle + 1;
            } else if (middleValue > elem) {
                high = middle - 1;
            } else return middle;
        }
        return -1;
    }
}
