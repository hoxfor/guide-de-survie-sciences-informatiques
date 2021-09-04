
import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradeFeedbacks;
import com.github.guillaumederval.javagrading.GradingRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.*;


@RunWith(GradingRunner.class)
public class Tests {

    Supplier<Integer> rng = () -> (int) (Math.random() * 100);

    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(onSuccess = true, message = ""),
            @GradeFeedback(onFail = true, message = "The size is not correctly initialized and/or updated in your code")})
    public void testSize(){

        MyArrayList<Integer> list = new MyArrayList<Integer>(4);

        assertEquals(0, list.size());
        list.enqueue(1);
        assertEquals(1, list.size());
        list.enqueue(1);
        assertEquals(2, list.size());
        list.enqueue(2);
        assertEquals(3, list.size());
        list.remove(2);
        assertEquals(2, list.size());

    }


    @Test
    @Grade
    @GradeFeedback(onFail = true, message = "Enqueuing more elements than \"initSize\" and/or does not work in your code. You need to resize ! ")
    public void testResize(){

        int init = rng.get();
        MyArrayList<Integer> list = new MyArrayList<Integer>(init);

        Integer [] elements = Stream.generate(rng).limit(init*3).toArray(Integer[]::new);
        Arrays.stream(elements).forEach(list::enqueue);

        assertEquals(3*init, list.size());


    }


    @Test
    @Grade
    @GradeFeedback(onFail = true, message = "You should not leave \"blanks\" in your array when you remove an element")
    public void testRemove(){

        MyArrayList<Integer> simple = new MyArrayList<Integer>(5);
        simple.enqueue(1);
        simple.enqueue(2);
        simple.enqueue(3);
        simple.enqueue(4);
        simple.enqueue(5);
        Integer res = simple.remove(1); // removes "2"

        assertEquals(2, (int)res);
        assertEquals((int)simple.remove(1), 3);

        MyArrayList<Integer> list = new MyArrayList<Integer>(20);
        Integer [] elements = Stream.generate(rng).limit(10).toArray(Integer[]::new);
        Arrays.stream(elements).forEach(list::enqueue);



        for(int i = 0; i < 10; i++){
            list.remove(i);
            assertEquals(9, list.size());
            assertNull(list.getList()[9]);
            for(int j = 0; j < 9; j++){
                Integer ret = list.remove(0);
                assertNotNull(ret);
            }
            assertEquals(0, list.size());
            list = new MyArrayList<Integer>(20);
            Arrays.stream(elements).forEach(list::enqueue);
        }


    }



    @Test
    @Grade
    @GradeFeedback(onFail = true, message = "The iterator does not give all elements from the list and/or gives " +
            "wrong informations about remaining items in the list")
    public void testIterator(){

        MyArrayList<Integer> list = new MyArrayList<Integer>(30);
        Integer[] elements = Stream.generate(rng).limit(30).toArray(Integer[]::new);
        Arrays.stream(elements).forEach(list::enqueue);

        Iterator<Integer> it = list.iterator();

        for(int i = 0; i < 30; i++){
            assertTrue(it.hasNext());
            assertEquals(elements[i], it.next());
        }

        assertFalse(it.hasNext());

    }


    @Test(expected = IndexOutOfBoundsException.class)
    @Grade
    @GradeFeedback(onFail = true, message = "Your code does not throw IndexOutOfBoundsException when it should. Read the exercise again")
    public void testOutOfBoundsConstructor(){
        MyArrayList<Integer> list = new MyArrayList<Integer>(-1);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    @Grade
    @GradeFeedback(onFail = true, message = "Your code does not throw IndexOutOfBoundsException when it should. Read the exercise again")
    public void testOutOfBoundsRemove(){
        MyArrayList<Integer> list = new MyArrayList<Integer>(2);
        list.enqueue(1);
        list.remove(2);
    }


    @Test(expected = ConcurrentModificationException.class)
    @Grade
    @GradeFeedback(onFail = true, message = "Your code does not throw ConcurrentModificationException when it should. Read the exercise again")
    public void testConcurrentModification(){
        MyArrayList<Integer> list = new MyArrayList<Integer>(2);
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);

        Iterator<Integer> it = list.iterator();

        list.enqueue(4);
        it.next();
    }

}