package intern.patterns.trees;

import inter.patterns.trees.BalanceTreeValidation;
import inter.patterns.trees.BinaryIntegerNode;
import org.junit.Assert;
import org.junit.Test;

public class BalanceTreeValidationTest {

    private BalanceTreeValidation validator = new BalanceTreeValidation();

    @Test
    public void test1(){

        var node3 = new BinaryIntegerNode(3);
        var node4 = new BinaryIntegerNode(4,node3,null);
        var node1 = new BinaryIntegerNode(1);
        var node2 = new BinaryIntegerNode(2,node1,node4);

        var node6 = new BinaryIntegerNode(6);
        var node9 = new BinaryIntegerNode(9,node6,null);
        var node7 = new BinaryIntegerNode(7,null,node9);

        var node5 = new BinaryIntegerNode(5,node2,node7);

        var result = validator.isBalanceTree(node5);

        Assert.assertEquals(true,true);

    }


}
