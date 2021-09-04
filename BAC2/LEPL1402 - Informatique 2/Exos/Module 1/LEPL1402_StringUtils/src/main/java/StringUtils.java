
public class StringUtils {


    /**
     * Split a strin according to a delimiter
     *
     * @param str       The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     * between two consecutive occurence of the delimiter.
     * If there is no occurence of the delimiter, it should
     * return an array of size 1 with the string at element 0
     */
    public static String[] split(String str, char delimiter) {
        int numberOfDelimiter = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) numberOfDelimiter++;
        }

        if (numberOfDelimiter == 1) return new String[]{};

        String[] splited = new String[numberOfDelimiter];

        for (int i = 0; i < numberOfDelimiter - 1; i++) {
            int index = StringUtils.indexOf(str, String.valueOf(delimiter));
            splited[i] = str.substring(0, index);
            str = str.substring(index + 1);
        }

        splited[splited.length - 1] = str;

        return splited;
    }


    /**
     * Find the first occurence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     * the substring in str or -1 if sub does not appear
     * in str
     */
    public static int indexOf(String str, String sub) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == sub.charAt(0)) {
                if (str.startsWith(sub, i)) return i;
            }
        }
        return -1;
    }


    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     * character put to lower case.
     */
    public static String toLowerCase(String str) {
        StringBuilder lower = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                lower.append((char) (str.charAt(i) + 32));
            } else {
                lower.append(str.charAt(i));
            }
        }
        return lower.toString();
    }


    /**
     * Check if a string is a palyndrome
     * <p>
     * A palyndrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palyndrome, false otherwise
     */
    public static boolean palindrome(String str) {
        if (str.length() <= 1) return true;
        if (str.charAt(0) != str.charAt(str.length() - 1)) return false;
        return palindrome(str.substring(1, str.length() - 1));
    }

}
