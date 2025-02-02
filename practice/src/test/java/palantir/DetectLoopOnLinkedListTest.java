package palantir;

import org.junit.Assert;
import org.junit.Test;

public class DetectLoopOnLinkedListTest {

    private DetectLoopOnLinkedList loopDetector = new DetectLoopOnLinkedList();

    @Test
    public void test1() {

        var root = new Node(0);
        var result = loopDetector.isThereALoopNaive(root);
        Assert.assertEquals(false, result);

    }

    @Test
    public void test2() {

        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head.next;

        var result = loopDetector.isThereALoopNaive(head);
        Assert.assertEquals(true, result);


    }
}
