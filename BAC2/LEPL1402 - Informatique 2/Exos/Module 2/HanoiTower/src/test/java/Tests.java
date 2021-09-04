
import org.junit.Test;

import java.util.Random;
import java.util.Stack;

import static org.junit.Assert.*;


public class Tests {

    private static Random rng = new Random();

    public static int randomInt(){
        return rng.nextInt(10000);
    }

    public static Stack<Disk> buildTower(int size){
        Stack<Disk> tower = new Stack<Disk>();
        for(int i = size ; i > 0 ; i--){
            tower.push(new Disk(i));
        }
        return tower;
    }

    @Test()
    public void testThree() {

        int size = 3;

        Stack<Disk> a = buildTower(size);
        Stack<Disk> b = new Stack<Disk>();
        Stack<Disk> c = new Stack<Disk>();

        TowerOfHanoi.towerOfHanoi(size, a, b, c);

        for(int i = 1; i<=size; i++){
            assertEquals(i, c.pop().getI());
        }
    }


    @Test()
    public void testFour(){
        int size = 4;

        Stack<Disk> a = buildTower(size);
        Stack<Disk> b = new Stack<Disk>();
        Stack<Disk> c = new Stack<Disk>();

        TowerOfHanoi.towerOfHanoi(size, a, b, c);
        for(int i = 1; i<=size; i++){
            assertEquals(i, c.pop().getI());
        }
    }

    @Test()
    public void tesTen(){
        int size = 10;

        Stack<Disk> a = buildTower(size);
        Stack<Disk> b = new Stack<Disk>();
        Stack<Disk> c = new Stack<Disk>();

        TowerOfHanoi.towerOfHanoi(size, a, b, c);
        for(int i = 1; i<=size; i++){
            assertEquals(i, c.pop().getI());
        }
    }

    @Test()
    public void tesTwenty(){
        int size = 20;

        Stack<Disk> a = buildTower(size);
        Stack<Disk> b = new Stack<Disk>();
        Stack<Disk> c = new Stack<Disk>();

        TowerOfHanoi.towerOfHanoi(size, a, b, c);

        for(int i = 1; i<=size; i++){
            assertEquals(i, c.pop().getI());
        }
    }

}
