/**
 * Solution fortement inspiré d'@Oldgram et @BarghestEPL + internet
 * Sources :
 * https://github.com/Oldgram/SINFEDU/blob/master/LEPL1402/Module%202/MergeSortImplementation/src/main/java/MergeSort.java
 * https://github.com/BarghestEPL/InginiousTasks/blob/master/LEPL1402_MergeSortImplementation/src/main/java/MergeSort.java
 * https://www.geeksforgeeks.org/merge-sort/
 * https://www.baeldung.com/java-merge-sort
 */
public class MergeSort {


    /**
     * Pre-conditions: a[lo..mid] and a[mid+1..hi] are sorted
     * Post-conditions: a[lo..hi] is sorted
     */
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int i = 0; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else a[k] = aux[i++];
        }
    }

    /**
     * Rearranges the array in ascending order, using the natural order
     */
    public static void sort(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int[] aux = new int[a.length];

        sortHelper(a, aux, lo, hi);
    }

    public static void sortHelper(int[] a, int[] aux, int lo, int hi) {
        int middle = (lo + hi) / 2;
        if (lo < hi) {
            sortHelper(a, aux, lo, middle);
            sortHelper(a, aux, middle + 1, hi);
        }
        merge(a, aux, lo, middle, hi);
    }

}
