import com.github.guillaumederval.javagrading.CustomGradingResult;
import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradeFeedbacks;
import com.github.guillaumederval.javagrading.GradingRunner;
import com.github.guillaumederval.javagrading.TestStatus;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.Random;

import static org.junit.Assert.*;


@RunWith(GradingRunner.class) // classic "jail runner" from Guillaume's library
public class Tests {

    private static Random rng = new Random();

    public static int randomInt(){
        return rng.nextInt(100);
    }

    public static int fTreeSum(FTree<Integer> ft){
        if(ft instanceof Node){
            return ft.value() + fTreeSum(ft.left()) + fTreeSum(ft.right());
        }
        return ft.value();
    }

    @Test()
    @Grade(value=5, custom=true, cpuTimeout=100)
    @GradeFeedback(message = "Your map function doesn't give the expected output", onFail = true, onTimeout = true)
    public void testSimpleMap() throws CustomGradingResult{

        FTree<Integer> root;
        FTree[] firstStage = new FTree[2];
        FTree[] secondStage = new FTree[4];
        FTree[] thirdStage = new FTree[8];
        FTree[] fleafs = new FTree[16];

        for(int i = 0 ; i < 16 ; i++){
            fleafs[i] = new Leaf(1+(2*i));
        }

        for(int i = 0; i<8 ; i++){
            thirdStage[i] = new Node<Integer>(2 + i*4, fleafs[i*2], fleafs[i*2+1]);
        }

        for(int i = 0 ; i <4 ; i++){
            secondStage[i] = new Node<Integer>(((i*8)+4), thirdStage[i*2], thirdStage[i*2+1]);
        }

        firstStage[0] = new Node<Integer>(8, secondStage[0], secondStage[1]);
        firstStage[1] = new Node<Integer>(24, secondStage[2], secondStage[3]);

        root = new Node<Integer>(16, firstStage[0], firstStage[1]);

        FTree<Integer> result = root.map(i -> i*10);

        assertEquals(4960, fTreeSum(result) );



    }

    @Test()
    @Grade(value=5, custom=true, cpuTimeout=100)
    @GradeFeedback(message = "Your map function doesn't give the expected output", onFail = true, onTimeout = true)
    public void testRandomMap() throws CustomGradingResult{

        int elemSum = 0 ;
        int r;

        FTree<Integer> root;
        FTree[] firstStage = new FTree[2];
        FTree[] secondStage = new FTree[4];
        FTree[] thirdStage = new FTree[8];
        FTree[] fleafs = new FTree[16];
        for(int i = 0 ; i < 16 ; i++){
            r = randomInt();
            elemSum += r;
            fleafs[i] = new Leaf(r);
        }

        for(int i = 0; i<8 ; i++){
            r = randomInt();
            elemSum += r;
            thirdStage[i] = new Node<Integer>(r, fleafs[i*2], fleafs[i*2+1]);
        }

        for(int i = 0 ; i <4 ; i++){
            r = randomInt();
            elemSum += r;
            secondStage[i] = new Node<Integer>(r, thirdStage[i*2], thirdStage[i*2+1]);
        }

        r = randomInt();
        elemSum += r;
        firstStage[0] = new Node<Integer>(r, secondStage[0], secondStage[1]);

        r = randomInt();
        elemSum += r;
        firstStage[1] = new Node<Integer>(r, secondStage[2], secondStage[3]);

        r = randomInt();
        elemSum += r;
        root = new Node<Integer>(r, firstStage[0], firstStage[1]);

        FTree<Integer> result = root.map(i -> i*10);

        assertEquals(elemSum*10, fTreeSum(result) );


    }

    @Test()
    @Grade(value=5, custom=true, cpuTimeout=100)
    @GradeFeedback(message = "Your depth function doesn't give the expected output", onFail = true, onTimeout = true)
    public void testDepth() throws CustomGradingResult{


        FTree<Integer> root;
        FTree[] firstStage = new FTree[2];
        FTree[] secondStage = new FTree[4];
        FTree[] thirdStage = new FTree[8];
        FTree[] fleafs = new FTree[16];
        for(int i = 0 ; i < 16 ; i++){
            fleafs[i] = new Leaf(1);
        }

        for(int i = 0; i<8 ; i++){
            thirdStage[i] = new Node<Integer>(1, fleafs[i*2], fleafs[i*2+1]);
        }

        for(int i = 0 ; i <4 ; i++){
            secondStage[i] = new Node<Integer>(1, thirdStage[i*2], thirdStage[i*2+1]);
        }

        firstStage[0] = new Node<Integer>(1, secondStage[0], secondStage[1]);
        firstStage[1] = new Node<Integer>(1, secondStage[2], secondStage[3]);

        root = new Node<Integer>(1, firstStage[0], firstStage[1]);

        assertEquals(4, root.depth());


    }

    @Test()
    @Grade(value=5, custom=true, cpuTimeout=100)
    @GradeFeedback(message = "Your Leaf class is not correctly implemented", onFail = true, onTimeout = true)
    public void testLeaf() throws CustomGradingResult{

        FTree<Integer> l = new Leaf(1);

        if(null!=l.left()) throw new CustomGradingResult(TestStatus.FAILED, 0, "left() on a leaf should return null");

        if(null!=l.right()) throw new CustomGradingResult(TestStatus.FAILED, 0, "right() on a leaf should return null");

        if(1!=l.value()) throw new CustomGradingResult(TestStatus.FAILED, 0, "The value returned by value() is not the one given to the constructor");

        assertEquals(null, l.left());
        assertEquals(null, l.right());


    }

    @Test()
    @Grade(value=5, custom=true, cpuTimeout=100)
    @GradeFeedback(message = "Your Node class is not correctly implemented", onFail = true, onTimeout = true)
    public void testNode() throws CustomGradingResult{

        FTree<Integer> l = new Leaf(1);
        FTree<Integer> r = new Leaf(3);
        FTree<Integer> n = new Node(2, l, r);

        if(l!=n.left()) throw new CustomGradingResult(TestStatus.FAILED, 0, "left() on a leaf should return the child");

        if(r!=n.right()) throw new CustomGradingResult(TestStatus.FAILED, 0, "right() on a leaf should return the child");

        if(2!=n.value()) throw new CustomGradingResult(TestStatus.FAILED, 0, "The value returned by value() is not the one given to the constructor");

        assertEquals(l, n.left());
        assertEquals(r, n.right());


    }

}
