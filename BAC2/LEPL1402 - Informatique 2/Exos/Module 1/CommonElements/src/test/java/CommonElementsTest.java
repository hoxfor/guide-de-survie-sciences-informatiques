import com.github.guillaumederval.javagrading.Grade;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CommonElementsTest {

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void test1() {
        int [] tab1 = new int[] {3,1,5,7,7};
        int [] tab2 = new int[] {3,1,6,7,7,5};

        assertEquals(4, CommonElements.count(tab1,tab2));
        assertEquals(4, CommonElements.count(tab2,tab1));

    }

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void test2() {
        int [] tab1 = new int[] {3,5,2,2,2};
        int [] tab2 = new int[] {3,1,6,7,2,5};

        assertEquals(2, CommonElements.count(tab1,tab2));
        assertEquals(2, CommonElements.count(tab2,tab1));

    }

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void test3() {
        int [][] tab1 = new int[][] {
                {1,2,1,5,6},
                {3,1,5,7,2},
                {1,4,5,2,1},
                {6,7,1,0,3}
        };

        int [][] tab2 = new int[][] {
                {1,2,1,5,6},
                {3,3,5,3,2},
                {1,4,6,2,1},
        };

        assertEquals(12, CommonElements.count(tab2,tab1));
    }
}
