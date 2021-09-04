
import org.junit.Test;
import java.util.Random;

import static org.junit.Assert.*;

public class Tests {

    @Test()
    public void testComplete(){

        int[] array = randomArray(10000);
        MergeSort.sort(array);

        assertTrue(isArraySorted(array));

    }


    private static boolean isArraySorted(int[] array){
        for(int i = 0 ; i < array.length -1; i++){
            if(array[i]>array[i+1])
                return false;

        }
        return true;
    }

    private static int[] randomArray(int size){
        int[] array = new int[size];
        Random rng = new Random();
        for(int i = 0 ; i < size ; i++){
            array[i]= rng.nextInt(Integer.MAX_VALUE);
        }
        return array;
    }

}
