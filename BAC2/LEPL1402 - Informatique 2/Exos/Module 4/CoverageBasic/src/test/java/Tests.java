import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void test() {
        int[] a = new int[]{1, 2, 3, 4}; // your test array
        int[] b = new int[]{-4, 6, 9, 2, 5};

        int max = Maximum.maximum(a); // find the maximum
        int maxb =Maximum.maximum(b);
        assertEquals(4, max);
        assertEquals(9, maxb);
    }

// some other tests in order to have edge and node coverage

}
