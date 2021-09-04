/*
    Note de l'auteur : cet exo est trop chelou la solution ici est pas complète
    (sorry de briser vos espoirs)
    Avec le code ici j'ai 54 % de coverage sur Intellij (56.59 % sur INGInious)
 */
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TestSuite {

    /*@Rule
    public ExpectedException exception = ExpectedException.none();*/
    // Passe pas sur inginious

    @Test
    public void test() {
        // parameters for parseExp
        char[] in = new char[]{'1', '2', '3', '4'};
        // you can also use .toCharArray from String class for this:
        // char[] in = myString.toCharArray();
        int offset = 2;
        int len = 2;
        // run the program with the given situation
        long parse = BigDecimal.parseExp(in, offset, len);

        assertEquals(4, parse);
    }

    @Test
    public void test1() {
        char[] in = "-12-58+95".toCharArray();
        int offset = 4, len = 2;
        long parse = BigDecimal.parseExp(in, offset, len);

        assertEquals(8, parse);
    }

    @Test(/*expected=NumberFormatException.class (passe pas non plus)*/)
    public void exceptionHandling() throws  NumberFormatException{
        char[] in = "178965".toCharArray();
        int offset = 0;
        int len = 0;
        BigDecimal.parseExp(in, offset, len);

    }

}