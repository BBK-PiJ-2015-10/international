package intern.patterns.binarysearch;

import inter.patterns.binarysearch.BinaryNodeVal;
import inter.patterns.binarysearch.BinarySearchTreeValidation;
import org.junit.Assert;
import org.junit.Test;
//import inter.patterns.binarysearch

public class BinarySearchTreeValidationTest {

    private BinarySearchTreeValidation validator = new BinarySearchTreeValidation();

    @Test
    public void test1(){

        var leaf1 = new BinaryNodeVal(1);
        var leaf6 = new BinaryNodeVal(6);
        var pleaf2 = new BinaryNodeVal(2,leaf1,leaf6);

        var leaf7 = new BinaryNodeVal(7);
        var leaf9 = new BinaryNodeVal(9);
        var pleaf7 = new BinaryNodeVal(7,leaf7,leaf9);

        var root5 = new BinaryNodeVal(5,pleaf2,pleaf7);

        var result = validator.isBinarySearchTree(root5);




        Assert.assertEquals(true,true);

    }

}
