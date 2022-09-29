import java.util.Arrays;

public class Anagram {

    /**
     * Count the number of occurrences of each letter of the alphabet
     * (from 'A' to 'Z') in the given string. The function must return
     * an array containing 26 elements: The item with index 0 contains
     * the number of 'A' in the string, the item with index 1 contains
     * the number of 'B', and so on.
     *
     * This function must be case-insensitive, i.e. the character 'f'
     * must be considered as the same as character 'F'.
     *
     * Characters that are neither in the range 'a' to 'z', nor in the
     * range 'A' to 'Z' must be ignored.
     * 
     * @param s The string of interest.
     * @return An array counting the number of occurrences of each
     * letter.
     **/
    public static int[] countAlphabet(String s) {
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {

            int ascii = s.charAt(i);
            if(ascii > 64 && ascii<91){ //maj
                alphabet[ascii-65] += 1;
            }
            if(ascii > 96 && ascii<123){ //min
                alphabet[ascii-97] += 1;
            }
        }

        return alphabet;
    }


    /**
     * Check whether one string is an anagram of another string. It is
     * strongly advised to use the function "countAlphabet()" as a
     * building block for function "isAnagram()".
     * @param s1 The first string.
     * @param s2 The second string.
     * @return <code>true</code> iff. the two strings are anagrams.
     **/
    public static boolean isAnagram(String s1,String s2) {
         int[] s1cout = countAlphabet(s1);
         int[] s2cout = countAlphabet(s2);

         if (Arrays.equals(s1cout,s2cout)) return true;
         return false;
    }

    public static void main(String[] args){
        String s = new String ("abcdefghijklmnopqrstuvwxyz   ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println(Arrays.toString(countAlphabet(s)));

    }
}
