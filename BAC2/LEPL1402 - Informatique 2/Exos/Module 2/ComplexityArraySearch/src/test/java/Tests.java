
import org.junit.Test;

import java.util.function.Supplier;


import static org.junit.Assert.*;

public class Tests{

    // generate random number
    private int tabMaxSize = (int) Math.pow(10, 6);
    private Supplier<Integer> rng = () -> (int) ((Math.random()*tabMaxSize-1)+1);

    private int[] generate_ordered_tab(){
        int[] tab = new int[tabMaxSize];
        int val = -rng.get();
        for(int i = 0; i<tabMaxSize; i++){
            tab[i] = val;
            val += 2;
        }
        return tab;
    }

    @Test
    public void testCorrectness(){
        int[] tab = generate_ordered_tab();
        for(int i = 0; i < 100; i++){
            int random = rng.get();
            assertEquals(Search.search(tab, tab[random]), random);
            assertEquals(Search.search(tab, tab[random]+1), -1);
        }
    }


}
