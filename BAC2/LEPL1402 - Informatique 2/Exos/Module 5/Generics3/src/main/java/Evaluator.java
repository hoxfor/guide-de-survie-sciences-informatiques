import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Evaluator {

    public BiFunction<Boolean, Boolean, Boolean> xor_gate() {
        return (a, b) -> a != b;
    }

    public BiFunction<Boolean, Boolean, Boolean> or_gate() {
        return (a, b) -> a | b;
    }

    public BiFunction<Boolean, Boolean, Boolean> and_gate() {
        return (a, b) -> a && b;
    }

    public Function<Boolean, Boolean> not_gate() {
        return (a) -> !(a);
    }

    // Should return a map containing the computation's results (use HashMap)
    // You're asked to store the results under the following keys: "SUM" & "carry_out"
    // TODO WARNING : ONLY USE the previously defined methods to compute the result
    // (INGInious will prevent you from cheating by directly invoking logical operators)
    public Map<String, Boolean> evaluate_circuit(Boolean a, Boolean b, Boolean carry_in) {
        HashMap<String, Boolean> evaluate = new HashMap<>();
        evaluate.put("SUM", xor_gate().apply(xor_gate().apply(a, b), carry_in));
        evaluate.put("carry_out", or_gate().apply(and_gate().apply(a, b), and_gate().apply(carry_in, xor_gate().apply(a, b))));
        return evaluate;
    }

}