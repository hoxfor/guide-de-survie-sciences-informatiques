import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MaxFinder {

    private final int nThreads, length, width, depth;
    private final int[][][] data;
    private final CyclicBarrier barrier;
    private int[] sums;
    private int max;

    /**
     * Worker class, responsible for the computation of some 2D-arrays.
     * <p>
     * The constructor of the worker take only an integer as parameter.
     * For instance:
     * <p>
     * public Worker(int threadId) {
     * // some code
     * }
     * <p>
     * To know which matrix the thread should process, use this formula:
     * <p>
     * threadId + nThread*x with x = 0,1,2,...
     * <p>
     * For instance, if there is 2 threads and threadId = 0, we have that this
     * thread should compute data[0], data[2], data[4], etc.
     * <p>
     * After each computation, the thread must put the result in the `sums` array
     * and wait for the barrier to get the results. Then it continues until there
     * is no more element to compute.
     */
    class Worker implements Runnable {
        private int rowNumber;

        public Worker(int threadID) {
            this.rowNumber = threadID;
        }

        @Override
        public void run() {
            int currentRow = this.rowNumber;
            while (currentRow < length) {

                sums[rowNumber] = 0;
                for (int[] line : data[currentRow]) {
                    for (int elem : line) {
                        sums[rowNumber] += elem;
                    }
                }
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException ignored) {
                }
                currentRow += nThreads;
            }
        }
    }


    /**
     * Initialize the instance variables, start the threads for the computation
     * and create the barrier.
     * <p>
     * Explication for the instances variables:
     * - nTreahds: number of threads, given as argument
     * - length: number of 2D-Arrays. First dimension of the matrix
     * - width: Second dimension of the matrix. First dimension of the 2D-arrays
     * - depth: Third dimension of the matrix. Second dimension of the 2D-arrays
     * - data: the 3D-array for the computation. Given as argument
     * - barrier: The cyclic barrier that will fetch the results.
     * - sums: the array in which the thread will put their computation. This array
     * should be of size nThreads
     * - max: The maximum values found by the threads. Will be update by the barrier
     */
    private MaxFinder(int[][][] matrix, int nThreads) throws InterruptedException {

        data = matrix;
        this.nThreads = nThreads;
        length = data.length;
        width = data[0].length;
        depth = data[0][0].length;
        sums = new int[this.nThreads];

        Runnable barrierAction = () -> {
            int currentMax = Integer.MIN_VALUE;
            for (int elem : sums) {
                max = Math.max(max, elem);
            }
        };

        barrier = new CyclicBarrier(this.nThreads, barrierAction);

        Thread[] threads = new Thread[this.nThreads];

        for (int i = 0; i < this.nThreads; i++) {
            threads[i] = new Thread(new Worker(i));
            threads[i].start();
        }

        // wait until done
        for (Thread thread : threads)
            thread.join();
    }

    /*
     * subSize is the length of the subarray
     * rowSize is the rowlength for all the array
     *
     */
    public static int getMaxSum(int[][][] matrix, int nThreads) {
        try {
            MaxFinder mf = new MaxFinder(matrix, nThreads);
            return mf.max;
        } catch (InterruptedException e) {
            return -1;
        }

    }
}
