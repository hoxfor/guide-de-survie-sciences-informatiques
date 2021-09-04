
import org.junit.Test;
import java.util.Stack;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Tests {

    Supplier<Integer> rnd = () -> (int) (Math.random() * 100);

    @Test
    public void randomTreeTest(){

        for(int i = 0; i < 10; i++) {

            Integer[] seeds = Stream.generate(rnd).limit(15).toArray(Integer[]::new);
            Node root = new Node(0);
            Node root2 = new Node(0);
            root = buildTree(root, seeds, 0);
            root2 = buildTree(root2, seeds, 0);
            Tree tree = new Tree(root);
            Tree tree2 = new Tree(root2);

            assertEquals(tree, tree2); // root.equals(root2) == true
        }
    }


    @Test
    public void simpleTreeTest(){

        Integer [] seeds = Stream.generate(rnd).limit(7).toArray(Integer[]::new);

        Node root = new Node(seeds[0]);
        root.left = new Node(seeds[1]);
        root.right = new Node(seeds[2]);
        root.left.left = new Node(seeds[3]);
        root.left.right = new Node(seeds[4]);
        root.right.left = new Node(seeds[5]);
        root.right.right = new Node(seeds[6]);

        Tree tree = new Tree(root);

        Node root2 = new Node(seeds[0]);
        root2.left = new Node(seeds[1]);
        root2.right = new Node(seeds[2]);
        root2.left.left = new Node(seeds[3]);
        root2.left.right = new Node(seeds[4]);
        root2.right.left = new Node(seeds[5]);
        root2.right.right = new Node(seeds[5]);

        Tree tree2 = new Tree(root2);

        assertNotEquals(tree, tree2);

        root2.right.right = new Node(seeds[6]);

        tree2 = new Tree(root2);

        assertEquals(tree, tree2);
    }


    @Test
    public void cornerCasesTest(){

        Tree tree = new Tree(null);
        Tree tree2 = new Tree(null);

        assertEquals(tree, tree2);

        tree2 = new Tree(new Node(1));

        assertNotEquals(tree, tree2);
        assertNotEquals(tree, null);
        assertNotEquals(tree, new Stack<>());

    }




    private Node buildTree(Node root, Integer [] seeds, int idx){

        if(idx < seeds.length){

            root = new Node(seeds[idx]);

            root.left = buildTree(root.left, seeds, 2*idx+1);
            root.right = buildTree(root.right, seeds, 2*idx+2);
        }

        return root;
    }
}