package intern.patterns.linkedlist;

import inter.patterns.linkedlist.LinkedListReverser;
import inter.patterns.linkedlist.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListReverserTest {

    private LinkedListReverser calculator = new LinkedListReverser();

    @Test
    public void test1() {

        var fourth = new Node(4);
        var third = new Node(3, fourth);
        var second = new Node(2, third);
        var first = new Node(1, second);

        var reversed = calculator.reverseList(first);

        var result = calculator.print(reversed, new LinkedList<>()).stream().map(d -> d.value).collect(Collectors.toList());

        Assert.assertEquals(List.of(4, 3, 2, 1), result);

    }

    @Test
    public void test3() {

        var fourth = new Node(4);
        var third = new Node(3, fourth);
        var second = new Node(2, third);
        var first = new Node(1, second);

        var reversed = calculator.reverseNodeRecurs(first);

        var result = calculator.print(reversed, new LinkedList<>()).stream().map(d -> d.value).collect(Collectors.toList());

        Assert.assertEquals(List.of(4, 3, 2, 1), result);

    }

}
