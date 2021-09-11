package sortingsearching;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Assert;

public class SorterTest {

    private Sorter sorter = new Sorter();

    @Test
    public void test1() {

        Queue<Integer> input = new LinkedList<>();
        input.offer(5);
        input.offer(2);
        input.offer(7);
        input.offer(1);


        Queue<Integer> result = sorter.sort(input);

        Integer prior = null;
        Integer current = null;

        System.out.println("FUCKER "+result.size());

        while(!result.isEmpty()){
             current = result.poll();
             System.out.println(current);
        }

    }
}
