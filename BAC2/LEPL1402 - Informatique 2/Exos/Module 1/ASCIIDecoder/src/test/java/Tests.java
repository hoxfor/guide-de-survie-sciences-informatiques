import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {


    @Test
    public void basicTest(){
        String [][] input = new String[][]{{"072" ,"101", "108", "108", "111", "032", "119", "111", "114", "108", "100"}};
        String [] res = Decoder.decode(null, input);
        assertEquals(1, res.length);
        assertEquals(res[0], "Hello world");
    }



    @Test
    public void forbiddenCharsTest(){
        String [] [] input = new String[][]{{"084", "104", "105", "115", "032", "105", "115", "032"},
                {"097", "032", "108", "097", "114", "103", "101", "114"},
                {"115", "101", "116", "032", "111", "102", "032", "115", "101", "110",
                        "116", "101", "110", "099", "101", "115", "046", "046", "046"}};
        String [] res = Decoder.decode(new int[]{32, 101}, input); // e and space char
        assertEquals(3, res.length);
        assertEquals(res[0], "Thisis"); // This is
        assertEquals(res[1], "alargr"); // a larger
        assertEquals(res[2], "stofsntncs..."); // set of sentences
    }

}

