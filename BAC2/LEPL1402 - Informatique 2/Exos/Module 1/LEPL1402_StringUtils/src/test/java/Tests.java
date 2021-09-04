
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Tests{


    private char [] markers = {'-',' ', '=', ','};
    private String [] words = {"hello", "world", "test"};

    private Supplier<String []> rsg_split = () -> { // return a random number of repeated  identical string and a marker

        StringBuilder sb = new StringBuilder();
        int nOcc = (int) (Math.random()*30)+2;
        int marker = (int) (Math.random() * 4);

        for(int i = 0; i < nOcc; i++){
            sb.append(words[(int) (Math.random()*3)]);
            sb.append(markers[marker]);
        }
        String val = sb.toString();
        return new String[]{val.substring(0, val.length()-1), String.valueOf(markers[marker])};

    };


    private Supplier<String> rsg = () -> {

        // source : https://www.baeldung.com/java-random-string

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);

        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();

    };


    @Test
    public void testLowerCase(){

        String [] seeds = Stream.generate(rsg).limit(10).toArray(String[]::new);


        for(String seed : seeds){
            String s = seed.toUpperCase();
            assertEquals(StringUtils.toLowerCase(s), s.toLowerCase());
        }

        assertEquals(StringUtils.toLowerCase("HelLo WorLd"), "HelLo WorLd".toLowerCase());
        assertEquals(StringUtils.toLowerCase("Hello World "), "Hello World ".toLowerCase());


    }


    @Test
    public void testPalindrome(){

        String [] seeds = Stream.generate(rsg).limit(10).toArray(String[]::new);

        for(String seed : seeds){
            String reversed = new StringBuilder(seed.substring(0, seed.length()-1)).reverse().toString();
            seed = seed.concat(reversed);
            assertTrue(StringUtils.palindrome(seed));
            seed = seed.concat("#");
            // the '#' char will never be generated, by concatenating it to a palindrome we're sure that seed is not
            // a palindrome anymore
            assertFalse(StringUtils.palindrome(seed));
        }

        assertTrue(StringUtils.palindrome("a")); // base case, a size 1 string should be considered a palindrome

    }


    @Test
    public void testSplit() {
        String[][] seeds = Stream.generate(rsg_split).limit(10).toArray(String[][]::new);

        for (String[] seed : seeds) {
            String[] splitJDK = seed[0].split(seed[1]);
            String[] splitStd = StringUtils.split(seed[0], seed[1].charAt(0));
            assertArrayEquals(splitJDK, splitStd);
        }

    }


    @Test
    public void testIndexOf(){

        String [] seeds = Stream.generate(rsg).limit(10).toArray(String[]::new);

        for(String seed : seeds){

            String begin = seed.substring(0, 2);
            String end = seed.substring(seed.length()-2);
            String middle = seed.substring(3, 6);
            assertEquals(seed.indexOf(begin), StringUtils.indexOf(seed, begin));
            assertEquals(seed.indexOf(end), StringUtils.indexOf(seed, end));
            assertEquals(seed.indexOf(middle), StringUtils.indexOf(seed, middle));

        }

        assertEquals(-1, StringUtils.indexOf("Test", "z"));
        assertEquals(-1, StringUtils.indexOf("test", "T"));
    }



}
