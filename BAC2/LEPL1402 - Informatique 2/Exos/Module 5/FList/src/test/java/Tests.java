import com.github.guillaumederval.javagrading.CustomGradingResult;
import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradeFeedbacks;
import com.github.guillaumederval.javagrading.GradingRunner;
import com.github.guillaumederval.javagrading.TestStatus;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(GradingRunner.class) // classic "jail runner" from Guillaume's library
public class Tests {

    private Supplier<Integer> rng = () -> (int) (new Random().nextInt(100));

    private int[] randomNumberSup(int size){
        return Stream.generate(rng).limit(size).mapToInt(i->i).toArray();
    }
    private Object[] asArray(FList list){
        Object[] array = new Object[list.length()];
        int index= 0;
        for(Object o : list){
            array[index++] = o;
        }
        return array;
    }

    @Test()
    @Grade(value=5, cpuTimeout=100)
    @GradeFeedbacks({@GradeFeedback(message = "Your isEmpty() works as expected", onSuccess = true),
            @GradeFeedback(message = "Your code has an issue with isEmpty()", onFail = true, onTimeout = true)})
    public void testIsEmpty() {
        FList<Integer> list = FList.nil(); // list = nil
        assertTrue(list.isEmpty());

        list = list.cons(1); // list = 1|nil
        assertFalse(list.isEmpty());
    }

    @Test()
    @Grade(value=5, cpuTimeout=100)
    @GradeFeedbacks({@GradeFeedback(message = "Both head() and tail() seem to work correctly", onSuccess = true),
            @GradeFeedback(message = "Your code has an issue with head() or tail()", onFail = true, onTimeout = true)})
    public void testHeadTail() {
        FList<Integer> list = FList.nil(); // list = nil

        // test whether head() throws the exception
        boolean noSuch = false;
        try {
            list.head();
        }
        catch(NoSuchElementException e) {
            noSuch = true;
        }
        if(!noSuch) {
            fail();
        }

        // test whether tail() throws the exception
        noSuch = false;
        try {
            list.tail();
        }
        catch(NoSuchElementException e) {
            noSuch = true;
        }
        if(!noSuch) {
            fail();
        }

        // test whether we can access elements correctly through head() and tail()
        for(int i = 9; i >= 0; i--) {
            list = list.cons(i);
        } // list = 0|1|2|3|4|5|6|7|8|9|nil
        for(int expectedValue = 0; expectedValue < 10; expectedValue++) {
            int actualValue = list.head();
            assertEquals(actualValue, expectedValue);
            list = list.tail();
        }
    }

    @Test()
    @Grade(value=5, cpuTimeout=100)
    @GradeFeedbacks({@GradeFeedback(message = "Your code succesfully performed a simple map operation", onSuccess = true),
            @GradeFeedback(message = "Your code failed to perform a simple map operation", onFail = true, onTimeout = true)})
    public void testMapBasic() {
        FList<Integer> list = FList.nil();
        // list = nil

        for(int i = 9; i >= 0; i--) {
            list = list.cons(i);
        }
        // list = 0|1|2|3|4|5|6|7|8|9|nil

        list = list.map(i -> i+1);
        // list = 1|2|3|4|5|6|7|8|9|10|nil

        for(int expectedValue = 1; expectedValue <= 10; expectedValue++) {
            int actualValue = list.head();
            assertEquals(actualValue, expectedValue);
            list = list.tail();
        }
    }

    @Test()
    @Grade(value=5, cpuTimeout=100)
    @GradeFeedbacks({@GradeFeedback(message = "Your code succesfully performed a simple filter operation", onSuccess = true),
            @GradeFeedback(message = "Your code failed to perform a simple filter operation", onFail = true, onTimeout = true)})
    public void testFilterBasic() {
        FList<Integer> list = FList.nil();
        // list = nil

        for(int i = 10; i > 0; i--) {
            list = list.cons(i);
        }
        // list = 1|2|3|4|5|6|7|8|9|10|nil

        list = list.filter(i -> i%2 == 0);
        // list = 2|4|6|8|10|nil

        for(int expectedValue = 2; expectedValue <= 10; expectedValue+=2) {
            int actualValue = list.head();
            assertEquals(actualValue, expectedValue);
            list = list.tail();
        }
    }

    @Test()
    @Grade(value=10, cpuTimeout=100)
    @GradeFeedbacks({@GradeFeedback(message = "Your length() is working as expected", onSuccess = true),
            @GradeFeedback(message = "The length you return is incorrect", onFail = true, onTimeout = true)})
    public void testLength() {

        int[] sizes = randomNumberSup(100);

        for(int i = 0 ; i<100 ; i++){
            FList<Integer> list = FList.nil();
            for(int j = 0 ; j < sizes[i] ; j++){
                list = list.cons(new Random().nextInt(100));
            }
            assertEquals(list.length(), sizes[i]);
        }

        FList<Integer> list = FList.nil();
        assertEquals(list.length(), 0);
    }


    @Test()
    @Grade(value=10, custom=true, cpuTimeout=100)
    @GradeFeedbacks({@GradeFeedback(message = "Your iterator is working as expected", onSuccess = true),
            @GradeFeedback(message = "Your iterator doesn't work as expected", onFail = true, onTimeout = true)})
    public void testIterator() {
        FList<Integer> list = FList.nil();

        int[] values = randomNumberSup(100);

        for(int i = 0 ; i < 100; i++) {
            list = list.cons(values[i]);
        }
        int index= 99;
        for(Integer i : list) {
            assertEquals(values[index--],i.intValue());
        }

        boolean noSuch = false, unsupported=false;

        try {
            FList<Integer> fl = FList.nil();
            Iterator it = fl.iterator();
            it.next();
        }
        catch(NoSuchElementException e) {
            noSuch = true;
        }

        try {
            FList<Integer> fl = FList.nil();
            Iterator it = fl.iterator();
            fl = fl.cons(1);
            it.remove();
        }
        catch(UnsupportedOperationException e) {
            unsupported = true;
        }

        if(!unsupported && !noSuch) {
            fail("You forgot about the exceptions");
        }
        if(!unsupported) {
            fail("You forgot about the UnsupportedOperationException");
        }
        if(!noSuch) {
            fail("You forgot about the NoSuchElementException");
        }
    }
}
