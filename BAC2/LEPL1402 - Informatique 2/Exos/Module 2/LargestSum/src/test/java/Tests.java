import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    public final int[] exampleArray = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    public final int[] bigArray = new int[]{-9, 3, -8, -6, 7, -15, -13, -12, 16, 4, 18, -12, -18, 10, -16};
    public final int[] veryBigArray = new int[]{12, -2, 17, 5, 2, -15, -7, -4, 16, 10, -7, -10, -11, 0, 4, 6, 19, 5, 13, -14, -12, 15, 19, 18, 7};

    @Test
    public void correctOutput() {
        assertArrayEquals(LargestSum.maxSubArray(this.exampleArray), new int[]{6, 3, 6});
        assertArrayEquals(LargestSum.maxSubArray(this.bigArray), new int[]{38, 8, 10});
        assertArrayEquals(LargestSum.maxSubArray(this.veryBigArray), new int[]{86, 0, 24});

    }

    @Test
    public void biggestSum() {
        int sum = LargestSum.maxSubArray(this.exampleArray)[0];
        int sum1 = LargestSum.maxSubArray(this.bigArray)[0];
        int sum2 = LargestSum.maxSubArray(this.veryBigArray)[0];

        assertEquals(sum, 6);
        assertEquals(sum1, 38);
        assertEquals(sum2, 86);
    }

    @Test
    public void indexStart() {
        int index = LargestSum.maxSubArray(this.exampleArray)[1];
        int index1 = LargestSum.maxSubArray(this.bigArray)[1];
        int index2 = LargestSum.maxSubArray(this.veryBigArray)[1];

        assertEquals(index, 3);
        assertEquals(index1, 8);
        assertEquals(index2, 0);
    }

    @Test
    public void indexEnd() {
        int index = LargestSum.maxSubArray(this.exampleArray)[2];
        int index1 = LargestSum.maxSubArray(this.bigArray)[2];
        int index2 = LargestSum.maxSubArray(this.veryBigArray)[2];

        assertEquals(index, 6);
        assertEquals(index1, 10);
        assertEquals(index2, 24);
    }


}


