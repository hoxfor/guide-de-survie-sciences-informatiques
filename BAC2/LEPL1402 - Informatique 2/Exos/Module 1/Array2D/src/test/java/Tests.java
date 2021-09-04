import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void testBuildFrom() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{10, 11}
        };
        String repr = "1 2 3\n10 11";
        assertEquals(matrix, Matrix.buildFrom(repr));
    }

    @Test
    public void testSum() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{10, 11}
        };
        assertEquals(27, Matrix.sum(matrix));
    }

    @Test
    public void testTranspose() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{10, 11, 12}
        };
        int[][] transposed = new int[][]{
                new int[]{1, 10},
                new int[]{2, 11},
                new int[]{3, 12}
        };
        assertArrayEquals(transposed, Matrix.transpose(matrix));
    }

    @Test
    public void testProduct() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{10, 11, 12}
        };
        int[][] mult = new int[][]{
                new int[]{4, 13},
                new int[]{5, 14},
                new int[]{6, 15}
        };

        int[][] product = new int[][]{
                new int[]{32, 86},
                new int[]{167, 464}
        };
        assertArrayEquals(product, Matrix.product(matrix, mult));
    }
}
