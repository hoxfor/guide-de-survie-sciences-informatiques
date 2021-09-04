import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void testExample(){

        int i1 = 25, i2 = 0;
        boolean correct=false;
        double res= 0.0;
        try{
            res = Divider.divide(i1, i2);
        }catch(ArithmeticException e){
            correct = true;
        }

        assertTrue(correct);


        correct = false;
        i1 = 25;
        i2 = 5;

        try{
            res = Divider.divide(i1, i2);
        }catch(ArithmeticException e){
            correct = true;
        }

        assertFalse(correct);
        assertTrue(almostEquals(res, 5.0));


        correct = false;
        i1 = 5;
        i2 = 2;

        try{
            res = Divider.divide(i1, i2);
        }catch(ArithmeticException e){
            correct = true;
        }

        assertFalse(correct);
        assertTrue(almostEquals(res, 2.5));

        i1 = 5;
        i2 = 0;
        correct = Divider.canDivide(i1, i2);

        assertFalse(correct);

        i1 = 5;
        i2 = 2;
        correct = Divider.canDivide(i1, i2);

        assertTrue(correct);


        correct = true;
        i1 = 5;
        i2 = 2;
        try{
            res = Divider.betterDivide(i1, i2);
        }catch(ArithmeticException e){
            correct = false;
        }

        assertTrue(almostEquals(res, 2.5));

        correct = false;
        i1 = 5;
        i2 = 0;
        String message = null;
        try{
            res = Divider.betterDivide(i1, i2);
        }catch(ArithmeticException e){
            message = e.getMessage();
            correct = e.getMessage()!=null;
        }

        assertTrue(correct);


        i1 = 5;
        i2 = 2;
        String s = Divider.betterCanDivide(i1, i2);
        assertTrue(almostEquals(2.5, Double.valueOf(s)));

        s=null;
        i1 = 5;
        i2 = 0;
        s = Divider.betterCanDivide(i1, i2);

        assertTrue(message.equals(s));



    }

    public static boolean almostEquals(double d1, double d2){
        return Math.abs(d1-d2) < 0.000001;
    }

}