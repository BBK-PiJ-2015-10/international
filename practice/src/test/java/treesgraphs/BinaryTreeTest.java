package treesgraphs;

import org.junit.Test;

public class BinaryTreeTest {

    private BinaryTree<Integer> numbers = new BinaryTree<>();

    private BinaryIntTree numbers1 = new BinaryIntTree();


    @Test
    public void test1(){

        numbers.add(40);
        numbers.add(47);
        numbers.add(45);
        numbers.add(11);
        numbers.add(13);
        numbers.add(44);
        numbers.add(88);
        numbers.add(3);
        numbers.add(1);


        numbers.BFS();

        Integer first = 50;
        Integer second = 45;

        //System.out.println(first.compareTo(second));

    }

    @Test
    public void test2(){

        numbers1.add(40);
        numbers1.add(47);
        numbers1.add(45);

    }
}
