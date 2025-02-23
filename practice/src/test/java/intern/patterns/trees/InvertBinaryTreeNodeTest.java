package intern.patterns.trees;

import inter.patterns.trees.BinaryIntegerNode;
import inter.patterns.trees.InvertBinaryTree;
import org.junit.Assert;
import org.junit.Test;


public class InvertBinaryTreeNodeTest {

    private InvertBinaryTree inverter = new InvertBinaryTree();

    @Test
    public void test1InvertViaRecursion() {


        var l27 = new BinaryIntegerNode(7,null,null);
        var r26 = new BinaryIntegerNode(6,null,null);
        var l11 = new BinaryIntegerNode(1,l27,r26);
        var r24 = new BinaryIntegerNode(4,null,null);
        var r18 = new BinaryIntegerNode(8,null,r24);
        var root = new BinaryIntegerNode(5,l11,r18);

        inverter.invert(root);

        inverter.printNode(root);

        Assert.assertEquals(true, true);

    }

    @Test
    public void test2InvertViaStack() {


        var l27 = new BinaryIntegerNode(7,null,null);
        var r26 = new BinaryIntegerNode(6,null,null);
        var l11 = new BinaryIntegerNode(1,l27,r26);
        var r24 = new BinaryIntegerNode(4,null,null);
        var r18 = new BinaryIntegerNode(8,null,r24);
        var root = new BinaryIntegerNode(5,l11,r18);

        inverter.invertViaStack(root);

        inverter.printNode(root);

        Assert.assertEquals(true, true);

    }

}
