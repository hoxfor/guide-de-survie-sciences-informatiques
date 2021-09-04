import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradingRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(GradingRunner.class)
public class Tests{

    private Supplier<Integer> rng = () -> (int) ((Math.random()*100) + 1); // never generate 0

    @Test
    @Grade
    @GradeFeedback(message = "Your code couldn't handle a simple expression of type (a operand b)", onFail = true)
    public void testBasicTrees(){

        Visitor calculator = new Evaluation();
        Integer [] seeds = Stream.generate(rng).limit(2).toArray(Integer[]::new);

        Node root = new Add(new Leaf(seeds[0]), new Leaf(seeds[1]));
        assertEquals(seeds[0] + seeds[1], calculator.visit((Add)root));

        root = new Div(new Leaf(seeds[0]), new Leaf(seeds[1]));
        assertEquals(seeds[0] / seeds[1], calculator.visit((Div)root));

        root = new Mult(new Leaf(seeds[0]), new Leaf(seeds[1]));
        assertEquals(seeds[0] * seeds[1], calculator.visit((Mult)root));

        root = new Sub(new Leaf(seeds[0]), new Leaf(seeds[1]));
        assertEquals(seeds[0] - seeds[1], calculator.visit((Sub)root));
    }

    @Test
    @Grade
    @GradeFeedback(message = "Your code couldn't handle a more complex expression", onFail = true)
    public void testTrees(){

        Visitor calculator = new Evaluation();

        Integer [] seeds = Stream.generate(rng).limit(3).toArray(Integer[]::new);
        Node root = new Add(new Mult(new Leaf(seeds[0]), new Leaf(seeds[1])), new Leaf(seeds[2]));

        int expression = calculator.visit((Add)root);

        assertEquals(expression, (seeds[0] * seeds[1]) + seeds[2]);

        seeds = Stream.generate(rng).limit(6).toArray(Integer[]::new);
        root = new Mult( new Add(
                new Mult( new Leaf(seeds[0]), new Leaf(seeds[1])),
                new Leaf(seeds[2]) ),
                new Sub(
                        new Div( new Leaf(seeds[3]), new Leaf(seeds[4]) ),
                        new Leaf(seeds[5]) ) );

        expression = calculator.visit((Mult)root);
        assertEquals(expression, ( (seeds[0] * seeds[1]) + seeds[2] ) * ( (seeds[3] / seeds[4]) - seeds[5] ) );

    }

    @Test
    @Grade
    @GradeFeedback(message = "You should not be able to divide by 0, read the assignment about what we expect from your code in that specific case", onFail = true)
    public void testDivByZero(){

        Visitor calculator = new Evaluation();

        Integer rand = rng.get();
        Node root = new Div(new Leaf(rand), new Leaf(0));

        try{
            int expression = calculator.visit((Div)root);
        } catch (IllegalArgumentException e){
            // this is what we expect.
        } catch (Exception e){
            fail();
        }
    }

    @Test
    @Grade
    @GradeFeedback(message = "Your code couldn't handle the example input given above", onFail = true)
    public void testExample(){
        Node root = new Add(
                new Div(
                        new Sub(new Leaf(6), new Leaf(2)),
                        new Add(new Leaf(1), new Leaf(1))),
                new Mult(new Leaf(5), new Leaf(2)));

        Visitor calculator = new Evaluation();

        int expression = calculator.visit((Add)root);
        assertEquals(expression, ((6-2)/(1+1))+(5*2));
    }
}
