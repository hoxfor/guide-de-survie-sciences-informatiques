public class Valley {

    /**
     * Compute the deepest valley and highest mountain
     *
     * @param slopes A non-empty array of slope
     * @return An array of two element. The first is the
     * depth of the deepest valley and the second
     * the height of the highest mountain
     */
    public static int[] valley(int[] slopes) {
        int pos = 0, neg = 0;
        int rise = 0, descent = 0;
        int[] output = new int[2];

        for (int i = 0; i < slopes.length - 1; i++) {
            if (slopes[i] > 0) {
                pos++;
            } else {
                neg++;
            }

            if (neg > 0 && neg <= descent && neg > output[1]) {
                output[1] = neg;
            }
            if (pos > 0 && pos <= rise && pos > output[0]) {
                output[0] = pos;
            }

            if (slopes[i] > slopes[i + 1]) {
                descent = pos;
                pos = 0;
                neg = 0;
            } else if (slopes[i] < slopes[i + 1]) {
                rise = neg;
                pos = 0;
                neg = 0;
            }
        }
        if (slopes[slopes.length - 1] > 0 && pos + slopes[slopes.length - 1] > output[1]) {
            output[0] = pos + slopes[slopes.length - 1];
        } else if (neg - slopes[slopes.length - 1] > output[0]) {
            output[1] = neg - slopes[slopes.length - 1];
        }
        return output;
    }
}
