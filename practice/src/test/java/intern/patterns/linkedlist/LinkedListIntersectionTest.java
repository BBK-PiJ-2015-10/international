package intern.patterns.linkedlist;

import inter.patterns.linkedlist.LinkedListIntersection;
import inter.patterns.linkedlist.Node;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListIntersectionTest {

    LinkedListIntersection calculator = new LinkedListIntersection();

    @Test
    public void test1() {

        Node two = new Node(2);
        Node seven = new Node(7, two);
        Node eight = new Node(8, seven);
        Node four1 = new Node(4, eight);
        Node tree1 = new Node(3, four1);
        Node one1 = new Node(1, tree1);
        Node four2 = new Node(4, eight);
        Node six2 = new Node(6, four2);


        var result = calculator.findIntersectionNode(one1, six2);


        Assert.assertEquals(8, result.value);

    }

}
