package intern.patterns.linkedlist;

import inter.patterns.linkedlist.LinkedListReverser;
import inter.patterns.linkedlist.Node;
import org.junit.Test;

import java.util.List;

public class LinkedListReverserTest {

    private LinkedListReverser calculator = new LinkedListReverser();

    @Test
    public void test1() {

        var fourth = new Node(4);
        var third = new Node(3, fourth);
        var second = new Node(2, third);
        var first = new Node(1, second);

        //calculator.print(first);

       var reversed = calculator.reverseList(first);

        calculator.print(reversed);

       // first.forEach(n -> System.out.print(String.format(",%d",n)));


//        for (int i = start.size() - 1; i >= 0; i--) {
//            var node = new Node(start.get(i));
//            var last = start.get(i);
//            System.out.println(last);
//        }


//        var last = new Node(4);
//        var third = new Node(3,last);
//        var second = new Node(2,third);
//        var first = new Node(1,second);
//
//        var reversed = calculator.reverseList(first);


    }

}
