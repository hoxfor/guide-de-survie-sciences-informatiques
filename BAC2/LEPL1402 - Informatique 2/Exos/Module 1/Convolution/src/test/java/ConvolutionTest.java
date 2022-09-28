import com.github.guillaumederval.javagrading.Grade;
import org.junit.Test;
import static org.junit.Assert.*;


public class ConvolutionTest {


    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void test1() {
        int [][] input = new int[][] {
                {1,2,1,5,6},
                {3,1,5,7,2},
                {1,4,5,2,1},
                {6,7,1,0,3}
        };

        int [][] kernel = new int[][] {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        int [][] expected = new int[][] {
                {0,0,0},
                {0,0,0}
        };

        int [][] res = Convolution.convolution(input,kernel);

        assertEquals(2, res.length);
        assertEquals(3, res[0].length);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expected[i][j], res[i][j]);
            }
        }

    }

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void test2() {
        int [][] input = new int[][] {
                {1,2,1,5,6},
                {3,1,5,7,2},
                {1,4,5,2,1},
                {6,7,1,0,3}
        };

        int [][] kernel = new int[][] {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        int [][] expected = new int[][] {
                {1,5,7},
                {4,5,2}
        };

        int [][] res = Convolution.convolution(input,kernel);

        assertEquals(2, res.length);
        assertEquals(3, res[0].length);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expected[i][j], res[i][j]);
            }
        }

    }

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void test3() {
        int [][] input = new int[][] {
                {1,2,1,5,6},
                {3,1,5,7,2},
                {1,4,5,2,1},
                {6,7,1,0,3}
        };

        int [][] kernel = new int[][] {
                {0,0,0},
                {0,1,1},
                {0,0,0}
        };

        int [][] expected = new int[][] {
                {6,12,9},
                {9,7,3}
        };

        int [][] res = Convolution.convolution(input,kernel);

        assertEquals(2, res.length);
        assertEquals(3, res[0].length);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expected[i][j], res[i][j]);
            }
        }

    }


}
