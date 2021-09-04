
import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradeFeedbacks;
import com.github.guillaumederval.javagrading.GradingRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.function.Supplier;
import java.util.stream.Stream;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(GradingRunner.class) // classic "jail runner" from Guillaume's library
public class Tests{

    // generate random number
    private Supplier<Integer> rng = () -> (int) ((Math.random()*100) + 1); // never generate 0

    // function to collect elements
    private ArrayList<Integer> collectCons(Cons student) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Cons currentElement = student;
        while(currentElement != null) {
            result.add(currentElement.v);
            currentElement = currentElement.next;
        }
        return result;
    }

    // Test for filter
    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(message = "", onSuccess = true),
                     @GradeFeedback(message = "Your filter function does not work\n", onFail = true, onTimeout = true)})
    public void testFilter(){

        for(int i=0; i<100; i++){


            Integer [] seeds = Stream.generate(rng).limit(3).toArray(Integer[]::new);

            Cons list = new Cons(seeds[0], new Cons(seeds[1], new Cons(seeds[2], null)));

            // result
            int randomValue = rng.get();
            P filterFunction = ( (l) -> l < randomValue);
            Cons filterResult = list.filter(filterFunction);

            // assert
            ArrayList<Integer> elements = collectCons(list);
            ArrayList<Integer> collectedResult = collectCons(filterResult);
            ArrayList<Integer> expectedResult = new ArrayList<Integer>();
            for (Integer element : elements) {
                if ( filterFunction.filter((int) element) ) {
                    expectedResult.add(element);
                }
            }
            assertEquals(expectedResult, collectedResult);
        }
    }

    // Test for map
    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(message = "", onSuccess = true),
                     @GradeFeedback(message = "Your map function does not work\n", onFail = true, onTimeout = true)})
    public void testMap(){
        Integer [] seeds = Stream.generate(rng).limit(3).toArray(Integer[]::new);

        Cons list = new Cons(seeds[0], new Cons(seeds[1], new Cons(seeds[2], null)));

        // results
        int randomValue = rng.get();
        F mapFunction = ((i) -> i*randomValue);
        Cons expectedList = new Cons(seeds[0] * randomValue, new Cons(seeds[1] * randomValue, new Cons(seeds[2] * randomValue, null)));
        Cons mapResult = list.map(mapFunction);

        // assert
        ArrayList<Integer> collectedResult = collectCons(mapResult);
        ArrayList<Integer> expectedResult = collectCons(expectedList);
        assertEquals(expectedResult, collectedResult);
    }

}
