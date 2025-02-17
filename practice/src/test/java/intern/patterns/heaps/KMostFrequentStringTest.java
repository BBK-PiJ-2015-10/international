package intern.patterns.heaps;

import inter.patterns.heaps.KMostFrequentString;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class KMostFrequentStringTest {

    private KMostFrequentString counter = new KMostFrequentString();

    @Test
    public void test1() {

        String[] words = {"go", "coding", "byte", "byte", "go", "interview", "go"};
        int top = 2;

        var result = counter.getKthMostFrequentStrings(words, top);

        var expectedResult = List.of("go", "byte");

        result.forEach(System.out::println);

//        Comparator<Integer> myComparator = (first, second) -> -first.compareTo(second);
//
//        Queue<Integer> queue = new PriorityQueue<>(myComparator);
//        queue.add(3);
//        queue.add(1);
//        queue.add(2);
//
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());


        Assert.assertEquals(expectedResult, result);

    }


}
