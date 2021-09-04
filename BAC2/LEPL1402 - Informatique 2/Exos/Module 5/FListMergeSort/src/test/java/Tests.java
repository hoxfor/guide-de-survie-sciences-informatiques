import com.github.guillaumederval.javagrading.CustomGradingResult;
import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradeFeedbacks;
import com.github.guillaumederval.javagrading.GradingRunner;
import com.github.guillaumederval.javagrading.TestStatus;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;
import java.util.Arrays;

import static org.junit.Assert.*;



@RunWith(GradingRunner.class) // classic "jail runner" from Guillaume's library
public class Tests{

    private static Random rng = new Random();

    public static int randomInt(){
        return rng.nextInt(10000);
    }

    private static boolean isSorted(FList<Integer> fl) {
        if(fl.isEmpty()) return true;

        if(fl.tail().isEmpty()) return true;

        if(fl.head() <= fl.tail().head()) return isSorted(fl.tail());
        else return false;

    }

    @Test()
    @Grade(value=5, custom=true, cpuTimeout=1000)
    @GradeFeedbacks({@GradeFeedback(message = "Your code was able to sort a short and simple list", onSuccess = true),
            @GradeFeedback(message = "Your code failed to sort a short and simple list", onFail = true, onTimeout = true)})
    public void testBasic() throws CustomGradingResult {

        FList<Integer> fl = FList.nil();
        fl = fl.cons(199);
        fl = fl.cons(249);
        fl = fl.cons(133);
        fl = fl.cons(329);
        fl = fl.cons(592);
        fl = fl.cons(253);
        fl = fl.cons(145);
        fl = fl.cons(700);

        FList<Integer> supposedSorted;
        try {
            supposedSorted = FListMerge.mergeSort(fl);
        }
        catch (Exception e) {
            throw new CustomGradingResult(TestStatus.FAILED, 0, "Your code produced the following exception: " + e);
        }

        assertEquals(133, (int)supposedSorted.head());
        supposedSorted = supposedSorted.tail();
        assertEquals(145, (int)supposedSorted.head());
        supposedSorted = supposedSorted.tail();
        assertEquals(199, (int)supposedSorted.head());
        supposedSorted = supposedSorted.tail();
        assertEquals(249, (int)supposedSorted.head());
        supposedSorted = supposedSorted.tail();
        assertEquals(253, (int)supposedSorted.head());
        supposedSorted = supposedSorted.tail();
        assertEquals(329, (int)supposedSorted.head());
        supposedSorted = supposedSorted.tail();
        assertEquals(592, (int)supposedSorted.head());
        supposedSorted = supposedSorted.tail();
        assertEquals(700, (int)supposedSorted.head());
    }

    @Test()
    @Grade(value=10, custom=true, cpuTimeout=1000)
    public void testGlobal() throws CustomGradingResult{
        FList<Integer> fl = FList.nil();
        int[] array = new int[1000];
        for(int i = 0 ; i < 1000 ; i++){
            int r = randomInt();
            fl = fl.cons(r);
            array[i] = r;
        }
        Arrays.sort(array);

        FList<Integer> supposedSorted = FListMerge.mergeSort(fl);

        /*if(FListMerge.counter<1000){
            throw new CustomGradingResult(TestStatus.FAILED, 0, "mergeSort is not recursive");
        }*/


        if(!isSorted(supposedSorted)){
            throw new CustomGradingResult(TestStatus.FAILED, 0, "mergeSort does not sort correctly");
        }

        FList<Integer> copy = supposedSorted;
        for(int i = 0 ; i < 1000 ; i++){
            if(array[i]!=copy.head()) throw new CustomGradingResult(TestStatus.FAILED, 0 , "Some elements have changed");
            copy = copy.tail();
        }
    }


    @Test()
    @Grade(value=10, custom=true, cpuTimeout=10000)
    @GradeFeedback(message = "Your implementation is too slow", onTimeout = true, onFail = true)
    public void testComplexity() throws CustomGradingResult{
        int size = 10000;

        FList<Integer> fl = FList.nil();
        int[] array = new int[size];
        for(int i = 0 ; i < size ; i++){
            int r = randomInt();
            fl = fl.cons(r);
            array[i] = r;
        }
        Arrays.sort(array);
        long t = System.currentTimeMillis();
        FList<Integer> supposedSorted = FListMerge.mergeSort(fl);
        long timeTaken = System.currentTimeMillis()-t;
        FList<Integer> copy = supposedSorted;
        for(int i = 0 ; i < size ; i++){
            if(array[i]!=copy.head()) throw new CustomGradingResult(TestStatus.FAILED, 0 , "Some elements have changed");
            copy = copy.tail();
        }
        if(timeTaken>4500){
            throw new CustomGradingResult(TestStatus.TIMEOUT, 0 , "Your implementation is too slow: " + timeTaken);
        }
    }
}
