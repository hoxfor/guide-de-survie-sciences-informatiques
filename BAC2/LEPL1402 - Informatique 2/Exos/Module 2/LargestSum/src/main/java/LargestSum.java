/**
 * Tip : look at Kadane's algorithm
 */
public class LargestSum {

    /**
     * Given the array [-2,1,-3,4,-1,2,1,-5,4]
     * The contiguous subarray that produces the best result is [4,-1,2,1]
     * For this array your method should return [6, 3, 6]
     */
    public static int[] maxSubArray(int[] a) {
        int currentSum = Integer.MIN_VALUE;
        int bestEnd = 0;
        int startIndex = 0;
        int endIndex = 0;
        int s = 0;

        for (int i = 0; i < a.length; i++) {
            bestEnd += a[i];

            if (currentSum < bestEnd) {
                currentSum = bestEnd;
                startIndex = s;
                endIndex = i;
            }
            if (bestEnd < 0) {
                bestEnd = 0;
                s = i + 1;
            }
        }
        return new int[]{currentSum, startIndex, endIndex};
    }
}
