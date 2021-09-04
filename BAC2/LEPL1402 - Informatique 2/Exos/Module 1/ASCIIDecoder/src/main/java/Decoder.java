import java.util.ArrayList;

public class Decoder {

    /**
     * Forbidden characters are passed as an array of int.
     * Each element of this array correspond to the decimal ASCII code
     * of a forbidden character OR null if there's no forbidden character
     * If you encounter one of these forbidden character
     * you must ignore it when you translate your sentence.
     * <p>
     * the 2D array "sentences" contain a set of decimal ASCII code we want you
     * to translate. Each sub-element of this array is a different sentence.
     * Ex : if we pass this array : [ ["42", "72", "88"], ["98", "99", "111", "47", "55"]]
     * to your decode method, you should return : [ "*HX", "bco/7" ]
     * <p>
     * You should NEVER return null or an array containing null
     */
    public static String[] decode(int[] forbidden, String[][] sentences) {
        StringBuilder builder = new StringBuilder();
        ArrayList<StringBuilder> list = new ArrayList<>();

        for (String[] sentence : sentences) {
            for (String letter : sentence) {
                int parsed = Integer.parseInt(letter);
                boolean isForbidden = false;
                if (forbidden != null) {
                    for (int forbiddenLetter : forbidden) {
                        if (parsed == forbiddenLetter) isForbidden = true;
                    }
                }
                if (!isForbidden) builder.append((char) parsed);
            }
            list.add(builder);
            builder = new StringBuilder();
        }

        String[] array = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = String.valueOf(list.get(i));
        }
        return array;
    }

}