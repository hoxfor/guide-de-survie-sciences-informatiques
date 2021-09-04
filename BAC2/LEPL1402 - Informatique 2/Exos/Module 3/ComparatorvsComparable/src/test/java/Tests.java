import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradingRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.awt.Color;

import java.util.*;

import static org.junit.Assert.*;
import java.util.Random;

@RunWith(GradingRunner.class) // classic "jail runner" from Guillaume's library
public class Tests {


    private int rng(){
        return (new Random().nextInt(200))-100;
    }


    @Test
    @Grade(value=1, cpuTimeout=100)
    @GradeFeedback(message = "CompareTo from Plant is not working as expected", onFail = true, onTimeout = true)
    public void testPlantComparable() {
        Plant p1 = new Plant("poppy", 3);
        Plant p2 = new Plant("rose", 2);
        Plant p3 = new Plant("Poppy", 4);
        Plant p4 = new Plant("poppy", 2);

        List<Plant> list = new ArrayList<Plant>();
        List<Plant> sortedList = new ArrayList<Plant>();

        sortedList.add(p3);
        sortedList.add(p4);
        sortedList.add(p1);
        sortedList.add(p2);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Collections.sort(list);

        assertTrue(list.equals(sortedList));

    }
    @Test
    @Grade(value=1, cpuTimeout=100)
    @GradeFeedback(message = "sortPlantByName is not working as expected", onFail = true, onTimeout = true)
    public void testPlantComparator() {
        Plant p1 = new Plant("poppy", 3);
        Plant p2 = new Plant("rose", 2);
        Plant p3 = new Plant("Poppy", 4);

        List<Plant> list = new ArrayList<Plant>();
        List<Plant> sortedList = new ArrayList<Plant>();

        sortedList.add(p3);
        sortedList.add(p1);
        sortedList.add(p2);
        list.add(p1);
        list.add(p2);
        list.add(p3);

        Sorter.sortPlantByName(list);

        assertTrue(list.equals(sortedList));

    }

    @Test
    @Grade(value=1, cpuTimeout=100)
    @GradeFeedback(message = "CompareTo from Flower is not working as expected", onFail = true, onTimeout = true)
    public void testFlowerComparable() {
        Flower p1 = new Flower("poppy", 3, new Color(1,1,1));
        Flower p2 = new Flower("rose", 2, new Color(2,1,1));
        Flower p3 = new Flower("Poppy", 4, new Color(2,2,1));
        Flower p4 = new Flower("poppy", 2, new Color(2,2,1));
        Flower p5 = new Flower("poppy", 1, new Color(2,2,2));

        List<Flower> list = new ArrayList<Flower>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        List<Flower> sortedList = new ArrayList<Flower>();

        sortedList.add(p3);
        sortedList.add(p5);
        sortedList.add(p4);
        sortedList.add(p1);
        sortedList.add(p2);

        Collections.sort(list);

        assertTrue(list.equals(sortedList));


    }
    @Test
    @Grade(value=1, cpuTimeout=100)
    @GradeFeedback(message = "sortFlowerByColor is not working as expected", onFail = true, onTimeout = true)
    public void testFlowerComparator() {
        Flower p1 = new Flower("poppy", 3, new Color(1,1,1));
        Flower p2 = new Flower("rose", 2, new Color(2,1,1));
        Flower p3 = new Flower("Poppy", 4, new Color(2,2,1));
        Flower p4 = new Flower("poppy", 2, new Color(2,2,1));
        Flower p5 = new Flower("poppy", 1, new Color(2,2,2));

        List<Flower> list = new ArrayList<Flower>();
        list.add(p3);
        list.add(p4);
        list.add(p2);
        list.add(p5);
        list.add(p1);

        List<Flower> sortedList = new ArrayList<Flower>();

        sortedList.add(p1);
        sortedList.add(p2);
        sortedList.add(p3);
        sortedList.add(p4);
        sortedList.add(p5);

        Sorter.sortFlowerByColor(list);

        assertTrue(list.equals(sortedList));

    }

    @Test
    @Grade(value=1, cpuTimeout=100)
    @GradeFeedback(message = "CompareTo from Tree is not working as expected", onFail = true, onTimeout = true)
    public void testTreeComparable() {
        Tree p1 = new Tree("poppy", 3, 10);
        Tree p2 = new Tree("rose", 2, 12);
        Tree p3 = new Tree("Poppy", 4, 9);
        Tree p4 = new Tree("poppy", 2, 11);

        List <Tree> list = new ArrayList <Tree>();
        List <Tree> sortedList = new ArrayList <Tree>();

        sortedList.add(p3);
        sortedList.add(p4);
        sortedList.add(p1);
        sortedList.add(p2);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Collections.sort(list);

        assertTrue(list.equals(sortedList));

    }
    @Test
    @Grade(value=1, cpuTimeout=100)
    @GradeFeedback(message = "sortPlantByName is not working as expected", onFail = true, onTimeout = true)
    public void testTreeComparator() {
        Tree p1 = new Tree("poppy", 3, 10);
        Tree p2 = new Tree("rose", 2, 12);
        Tree p3 = new Tree("Poppy", 4, 9);
        Tree p4 = new Tree("poppy", 2, 11);

        List <Tree> list = new ArrayList <Tree>();
        List <Tree> sortedList = new ArrayList <Tree>();

        sortedList.add(p3);
        sortedList.add(p1);
        sortedList.add(p4);
        sortedList.add(p2);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Sorter.sortTreeByHeight(list);

        assertTrue(list.equals(sortedList));


    }
}
