import com.github.guillaumederval.javagrading.Grade;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {
    
    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void testCountAlphabet1() {
        int a[] = Anagram.countAlphabet("");
        assertEquals(26, a.length);
        
        for (int j = 0; j < 26; j++) {
            assertEquals(0, a[j]);
        }
    }

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void testCountAlphabet2() {
        for (int i = 0; i < 26; i++) {
            String s = new String();
            s += (char) ('A' + i);
            s += (char) ('a' + i);
            
            int a[] = Anagram.countAlphabet(s);
            assertEquals(26, a.length);

            for (int j = 0; j < 26; j++) {
                if (i == j) {
                    assertEquals(2, a[j]);
                } else {
                    assertEquals(0, a[j]);
                }
            }
        }
    }
    
    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void testCountAlphabet3() {
        int a[] = Anagram.countAlphabet("Hello, world!");
        int b[] = { 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 3, 0,
                    0, 2, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 };

        assertEquals(26, a.length);

        for (int i = 0; i < 26; i++) {
            assertEquals(b[i], a[i]);
        }
    }

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void testAnagram() {
        assertTrue(Anagram.isAnagram("Listen", "Silent"));
        assertFalse(Anagram.isAnagram("Listen", "Silence"));
        assertTrue(Anagram.isAnagram("Madam Curie", "Radium came"));
        assertTrue(Anagram.isAnagram("Madam Curie", "aRidmuc mae"));
        assertFalse(Anagram.isAnagram("Madam Curie", "aRidmuc mad"));
    }

}
