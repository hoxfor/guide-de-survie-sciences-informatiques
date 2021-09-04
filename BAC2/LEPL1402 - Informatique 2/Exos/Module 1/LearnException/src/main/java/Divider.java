
public class Divider {

    /*
     * This method receives two integer as argument and return the exact result of the division i1/i2
     * It should throw an ArithmeticException if the second integer is equal to 0
     * */
    public static double divide(int i1, int i2) throws ArithmeticException {
        if (i2 == 0) throw new ArithmeticException();
        return (double) i1 / i2;
    }

    /*
     * Use the function divide to know if the numbers can be divided;
     * If the method divide throws an exception, it should be caught and return false
     * If the method divide doesn't throw an exception, it should return true
     * If you don't use the method divide we will see it and your method will not be tested!
     */
    public static boolean canDivide(int i1, int i2) {
        try {
            double division = divide(i1, i2);
            return true;
        } catch (ArithmeticException exception) {
            return false;
        }
    }

    /*
     * Now that you have understood the way exceptions are used in Java,
     * We ask you to use the exception to pass a message,
     * For example, if you try to divide by 0, you throw an ArithmeticException,
     * But instead of just using throw new ArithmeticException();
     * You can use throw new ArithmeticException("You tried to divide by zero");
     * Change your method divide to tell the reason the exception occurred
     * You can write anything in the message, we are only checking that you used the message properly.
     * */
    public static double betterDivide(int i1, int i2) throws ArithmeticException {
        if (i2 == 0) throw new ArithmeticException("You tried to divide by zero (go back to elementary school)");
        return (double) i1/i2;
    }

    /*
     * Use betterDivide to know if the numbers can be divided
     * Return the message as a String if an exception has been thrown
     * Return the result as a String if the division occurred as expected
     * */
    public static String betterCanDivide(int i1, int i2) {
        try {
            double betterDivision = betterDivide(i1, i2);
            return String.valueOf(betterDivision);
        } catch (ArithmeticException exception) {
            return exception.getMessage();
        }
    }


}