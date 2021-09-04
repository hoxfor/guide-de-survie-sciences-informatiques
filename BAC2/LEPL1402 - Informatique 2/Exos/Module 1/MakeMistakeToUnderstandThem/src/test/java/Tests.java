import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradingRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(GradingRunner.class) // classic "jail runner" from Guillaume's library
public class Tests {

    @Test(expected = ConcurrentModificationException.class)
    @Grade(value = 1, cpuTimeout = 100)
    @GradeFeedback(message = "Your code does not produce a ConcurrentModificationException", onFail = true)
    public void testConcurrentModificationException(){

        Except.concurr();
        
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    @Grade(value = 1, cpuTimeout = 100)
    @GradeFeedback(message = "Your code does not produce a ArrayIndexOutOfBoundsException", onFail = true)
    public void testArrayIndexOutOfBoundsException(){
        
        Except.outof();

    }
    
    @Test(expected = NullPointerException.class)
    @Grade(value = 1, cpuTimeout = 100)
    @GradeFeedback(message = "Your code does not produce a NullPointerException", onFail = true)
    public void testNullPointerException(){
        
        Except.nullpointer();

    }
    

}
