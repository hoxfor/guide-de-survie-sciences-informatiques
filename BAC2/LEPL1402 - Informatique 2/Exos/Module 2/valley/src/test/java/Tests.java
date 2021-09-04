
import org.junit.Test;


import static org.junit.Assert.*;

public class Tests {


    @Test()
    public void testExampleValley(){

        int[] example = new int[]{1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1};

        int[] result = Valley.valley(example);

        assertEquals(5, result[0]);
    }

    @Test()
    public void testExampleMountain(){

        int[] example = new int[]{1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1};

        int[] result = Valley.valley(example);

        assertEquals(3, result[1]);

    }

    @Test()
    public void testHeightEqualsArraySize(){

        int[] example = new int[]{1,1,1,1,1,-1,-1,-1,-1,-1};

        int[] result = Valley.valley(example);

        assertEquals(5, result[1]);
    }

    @Test()
    public void testDepthEqualsArraySize(){

        int[] example = new int[]{-1,-1,-1,-1,-1,1,1,1,1,1};

        int[] result = Valley.valley(example);

        assertEquals(5, result[0]);
    }


}
