
import java.util.ArrayList;
import java.util.List;

public class Except {


    public static void outof() {
        int[] array = new int[]{1, 2, 3};
        int error = array[array.length+1];
    }

    public static void concurr() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(42);
        for (int i: list) {
            if (i == 0) {
                list.remove(i); // Badaboum c'est le drame : on peut pas modifier une liste qui est en train d'être itérée
            }
        }
    }

    public static void nullpointer() {
        int[] arrayNull = null;
        int error = arrayNull.length;
    }


}