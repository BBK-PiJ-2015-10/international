package intern.patterns.linkedlist;

import inter.patterns.linkedlist.Node;
import inter.patterns.linkedlist.RemoveKthLastNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class RemoveKthLastNodeTest {

    private RemoveKthLastNode calculator = new RemoveKthLastNode();

    @Test
    public void test1() {

        Node three = new Node(3);
        Node seven = new Node(7, three);
        Node four = new Node(4, seven);
        Node two = new Node(2, four);
        Node one = new Node(1, two);

        //Node result = calculator.removedKthLastNode(one, 2);
        Node result = calculator.removedKthLastNodeOptimized(one, 2);

        List<Integer> resultFormated = new LinkedList<>();
        while (result != null) {
            System.out.println(String.format("Node is %s with next %s", result, result.next));
            resultFormated.add(result.value);
            result = result.next;
        }

        Assert.assertEquals(resultFormated, List.of(1, 2, 4, 3));

    }

    @Test
    public void test2() {

        Node three = new Node(3);
        Node seven = new Node(7, three);
        Node four = new Node(4, seven);
        Node two = new Node(2, four);
        Node one = new Node(1, two);

        Node result = calculator.removedKthLastNodeOptimized(one, 4);

        List<Integer> resultFormated = new LinkedList<>();
        while (result != null) {
            System.out.println(String.format("Node is %s with next %s", result, result.next));
            resultFormated.add(result.value);
            result = result.next;
        }

        Assert.assertEquals(resultFormated, List.of(1, 4, 7, 3));

    }

    @Test
    public void test3() {

        Node three = new Node(3);
        Node seven = new Node(7, three);
        Node four = new Node(4, seven);
        Node two = new Node(2, four);
        Node one = new Node(1, two);

        Node result = calculator.removedKthLastNodeOptimized(one, 1);

        List<Integer> resultFormated = new LinkedList<>();
        while (result != null) {
            System.out.println(String.format("Node is %s with next %s", result, result.next));
            resultFormated.add(result.value);
            result = result.next;
        }

        Assert.assertEquals(resultFormated, List.of(1, 2, 4, 7));

    }

    @Test
    public void test4() {

        Node three = new Node(3);
        Node seven = new Node(7, three);
        Node four = new Node(4, seven);
        Node two = new Node(2, four);
        Node one = new Node(1, two);

        Node result = calculator.removedKthLastNodeOptimized(one, 5);

        List<Integer> resultFormated = new LinkedList<>();
        while (result != null) {
            System.out.println(String.format("Node is %s with next %s", result, result.next));
            resultFormated.add(result.value);
            result = result.next;
        }

        Assert.assertEquals(resultFormated, List.of(2, 4, 7, 3));

    }

    @Test
    public void test5() {

        Node three = new Node(3);
        Node seven = new Node(7, three);
        Node four = new Node(4, seven);
        Node two = new Node(2, four);
        Node one = new Node(1, two);

        Node result = calculator.removedKthLastNodeOptimized(one, 6);

        List<Integer> resultFormated = new LinkedList<>();
        while (result != null) {
            System.out.println(String.format("Node is %s with next %s", result, result.next));
            resultFormated.add(result.value);
            result = result.next;
        }

        Assert.assertEquals(resultFormated, List.of(1, 2, 4, 7, 3));

    }

}
