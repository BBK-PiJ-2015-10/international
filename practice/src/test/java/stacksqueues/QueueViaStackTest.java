package stacksqueues;

import org.junit.Assert;
import org.junit.Test;

public class QueueViaStackTest {

    private QueueViaStack<Integer> queueViaStack = new QueueViaStack<>();

    @Test
    public void test1(){
        Integer first = 1;
        queueViaStack.enqueue(first);
        Integer result = queueViaStack.dequeue();
        Assert.assertEquals(first,result);
    }

    @Test
    public void test2(){
        Integer first = 1;
        Integer second = 2;
        queueViaStack.enqueue(first);
        queueViaStack.enqueue(second);
        Assert.assertEquals(2,queueViaStack.size());
        Integer result = queueViaStack.dequeue();
        Assert.assertEquals(first,result);
        Assert.assertEquals(1,queueViaStack.size());
    }

    @Test
    public void test3(){
        Integer first = 1;
        Integer second = 2;
        Integer third = 3;
        queueViaStack.enqueue(first);
        queueViaStack.enqueue(second);
        queueViaStack.enqueue(third);
        Assert.assertEquals(3,queueViaStack.size());
        Integer result = queueViaStack.dequeue();
        Assert.assertEquals(first,result);
        Assert.assertEquals(2,queueViaStack.size());
        Integer result2 = queueViaStack.dequeue();
        Assert.assertEquals(second,result2);
        Assert.assertEquals(1,queueViaStack.size());
    }

    @Test
    public void test4(){
        Integer first = 1;
        Integer second = 2;
        Integer third = 3;
        queueViaStack.enqueue(first);
        queueViaStack.enqueue(second);
        Integer result = queueViaStack.dequeue();
        Assert.assertEquals(first,result);
        queueViaStack.enqueue(third);
        Integer result2 = queueViaStack.dequeue();
        Assert.assertEquals(second,result2);
    }








}
