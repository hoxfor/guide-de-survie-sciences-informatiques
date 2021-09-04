public class Fibonacci {


    public static int fiboRecursive(int index) {
        if (index <= 1) return index;
        return fiboRecursive(index - 1) + fiboRecursive(index - 2);
    }


    public static int fiboIterative(int index) {
        if (index <= 1) return index;

        int previous1 = 1, previous2 = 1;

        for (int i = 2; i < index; i++) {
            int tmp = previous1;
            previous1 += previous2;
            previous2 = tmp;
        }
        return previous1;
    }

}
