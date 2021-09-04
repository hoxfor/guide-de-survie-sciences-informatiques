import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradeFeedbacks;
import com.github.guillaumederval.javagrading.GradingRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.*;

@RunWith(GradingRunner.class) // classic "jail runner" from Guillaume's library
public class Tests {

    private Evaluator evaluator;

    @Before
    public void setUp() {
        evaluator = new Evaluator();
    }

    // generate random number
    //private Supplier<Integer> rng = () -> (int) ((Math.random()*100) + 2); // never generate 0 or 1

    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(message = "", onSuccess = true),
            @GradeFeedback(message = "Your logic gate AND doesn't work as expected\n", onFail = true, onTimeout = true)})
    public void testAND(){

        BiFunction<Boolean, Boolean, Boolean> and_gate = evaluator.and_gate();

        for(Boolean v1: new Boolean[]{false, true}) {
            for(Boolean v2: new Boolean[]{false, true}) {
                boolean actual = and_gate.apply(v1, v2);
                boolean expected = Boolean.logicalAnd(v1, v2);
                assertEquals(expected, actual);
            }
        }
    }

    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(message = "", onSuccess = true),
            @GradeFeedback(message = "Your logic gate OR doesn't work as expected\n", onFail = true, onTimeout = true)})
    public void testOR(){

        BiFunction<Boolean, Boolean, Boolean> or_gate = evaluator.or_gate();

        for(Boolean v1: new Boolean[]{false, true}) {
            for(Boolean v2: new Boolean[]{false, true}) {
                boolean actual = or_gate.apply(v1, v2);
                boolean expected = Boolean.logicalOr(v1, v2);
                assertEquals(expected, actual);
            }
        }
    }

    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(message = "", onSuccess = true),
            @GradeFeedback(message = "Your logic gate XOR doesn't work as expected\n", onFail = true, onTimeout = true)})
    public void testXOR(){

        BiFunction<Boolean, Boolean, Boolean> xor_gate = evaluator.xor_gate();

        for(Boolean v1: new Boolean[]{false, true}) {
            for(Boolean v2: new Boolean[]{false, true}) {
                boolean actual = xor_gate.apply(v1, v2);
                boolean expected = Boolean.logicalXor(v1, v2);
                assertEquals(expected, actual);
            }
        }
    }

    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(message = "", onSuccess = true),
            @GradeFeedback(message = "Your logic gate NOT doesn't work as expected\n", onFail = true, onTimeout = true)})
    public void testNOT(){

        Function<Boolean, Boolean> not_gate = evaluator.not_gate();

        for(Boolean v1: new Boolean[]{false, true}) {
            boolean actual = not_gate.apply(v1);
            boolean expected = !v1;
            assertEquals(expected, actual);
        }
    }

    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(message = "", onSuccess = true),
            @GradeFeedback(message = "Your full adder implementation in evaluate_circuit doesn't work as expected\n", onFail = true, onTimeout = true)})
    public void testEvaluateCircuit(){

        Function<Boolean, Boolean> not = a -> !a;
        BiFunction<Boolean, Boolean, Boolean> and = (a, b) -> a & b;
        BiFunction<Boolean, Boolean, Boolean> or = (a, b) -> a | b;
        BiFunction<Boolean, Boolean, Boolean> xor = (a, b) -> a ^ b;


        for(Boolean a : new Boolean[]{false, true}) {
            for(Boolean b : new Boolean[]{false, true}) {
                for(Boolean cIn : new Boolean[]{false, true}) {

                    // actual result
                    Map<String, Boolean> actual = evaluator.evaluate_circuit(a, b, cIn);
                    Boolean actual_sum = actual.get("SUM");
                    Boolean actual_carryout = actual.get("carry_out");

                    // expected
                    Boolean s = xor.apply(a, b);
                    Boolean cOut = or.apply(and.apply(a, b), and.apply(cIn, s));
                    Boolean sOut = xor.apply(cIn, s);

                    // equals
                    assertEquals(sOut, actual_sum);
                    assertEquals(cOut, actual_carryout);
                }
            }
        }
    }

}
