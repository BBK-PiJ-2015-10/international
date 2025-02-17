package intern.patterns.heaps;

import inter.patterns.twopointers.PairSum;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

public class KMostFrequentStringTest {

    @Test
    public void test1() {

        Comparator<Integer> myComparator = (first, second) -> -first.compareTo(second);

        Queue<Integer> queue = new PriorityQueue<>(myComparator);
        queue.add(3);
        queue.add(1);
        queue.add(2);

        System.out.println(queue.poll());
        System.out.println(queue.poll());


        Assert.assertEquals(true, true);

    }


}
