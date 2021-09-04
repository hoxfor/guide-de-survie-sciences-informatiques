import java.util.Comparator;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort<E> extends RecursiveAction {

    private volatile E[] array, aux;
    private int lo, hi;
    private Comparator<? super E> comp;

    private static final int threshold = 128;


    public ParallelMergeSort(E[] a, int lo, int hi, E[] aux, Comparator<? super E> comp) {
        this.array = a;
        this.lo = lo;
        this.hi = hi;
        this.aux = aux;
        this.comp = comp;
    }

    /*
     * Run a normal sort when the difference between hi and lo is under the threshold
     * Otherwise : Split the sub array in two and start the sort on each part of the array simultaneously
     */
    @Override
    protected void compute() {
        if (hi - lo < threshold) {
            sort(lo, hi);
        } else {
            int middle = (lo + hi) / 2;
            invokeAll(new ParallelMergeSort<>(array, lo, middle, aux, comp),
                    new ParallelMergeSort<>(array, middle + 1, hi, aux, comp));
            merge(lo, middle, hi);
        }

    }

    //Sort array between lo and hi using merge sort
    private void sort(int lo, int hi) {
        if (hi - lo > 0) {
            int mid = (lo + hi) / 2;
            sort(lo, mid);
            sort(mid + 1, hi);
            merge(lo, mid, hi);
        }
    }

    //merge two subarray and keep them sorted
    private void merge(int lo, int mid, int hi) {
        int auxID = lo, i = lo, j = mid + 1;
        while (auxID <= hi) {
            if (i <= mid && j <= hi) {
                if (comp.compare(array[j], array[i]) > 0) {
                    aux[auxID++] = array[i++];
                } else {
                    aux[auxID++] = array[j++];
                }
            } else if (i <= mid) {
                aux[auxID++] = array[i++];
            } else {
                aux[auxID++] = array[j++];
            }
        }
        System.arraycopy(aux, lo, array, lo, hi - lo + 1);
    }

}