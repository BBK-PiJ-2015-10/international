package jpmorgan;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumTest {

    CombinationSum combinator = new CombinationSum();

    @Test
    public void example1() {

        List<Integer> l1 = Arrays.asList(1, 1, 6).stream().sorted().toList();
        List<Integer> l2 = Arrays.asList(1, 2, 5).stream().sorted().toList();
        List<Integer> l3 = Arrays.asList(1, 7).stream().sorted().toList();
        List<Integer> l4 = Arrays.asList(2, 6).stream().sorted().toList();
        List<List<Integer>> expectedSolution = List.of(l1, l2, l3, l4);

        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        var results = combinator.combinationSum2(candidates, target);

        var compare = results.containsAll(expectedSolution) && expectedSolution.containsAll(results);

        Assert.assertEquals(true, compare);

    }

    @Test
    public void example2() {

        List<Integer> l1 = Arrays.asList(1, 2, 2).stream().sorted().toList();
        List<Integer> l2 = Arrays.asList(5).stream().sorted().toList();
        List<List<Integer>> expectedSolution = List.of(l1, l2);

        int[] candidates = new int[]{2, 5, 2, 1, 2};
        int target = 5;
        var results = combinator.combinationSum2(candidates, target);

        var compare = results.containsAll(expectedSolution) && expectedSolution.containsAll(results);

        Assert.assertEquals(true, compare);

    }

    @Test
    public void example3() {

        List<Integer> l1 = Arrays.asList(1,1,1,5).stream().sorted().toList();
        List<Integer> l2 = Arrays.asList(1,1,3,3).stream().sorted().toList();
        List<Integer> l3 = Arrays.asList(3,5).stream().sorted().toList();
        List<List<Integer>> expectedSolution = List.of(l1, l2,l3);

        int[] candidates = new int[]{3,1,3,5,1,1};
        int target = 8;
        var results = combinator.combinationSum2(candidates, target);

        results.forEach(r -> System.out.println(r));

        var compare = results.containsAll(expectedSolution) && expectedSolution.containsAll(results);

        Assert.assertEquals(true, compare);


    }

    @Test
    public void example4() {

        List<List<Integer>> expectedSolution = new LinkedList<>();

        int[] candidates = new int[]{1};
        int target = 2;
        var results = combinator.combinationSum2(candidates, target);

        results.forEach(r -> System.out.println(r));

        var compare = results.containsAll(expectedSolution) && expectedSolution.containsAll(results);

        Assert.assertEquals(true, compare);


    }

    @Test
    public void example5() {

        List<List<Integer>> expectedSolution = new LinkedList<>();

        int[] candidates = new int[]{1,2};
        int target = 4;
        var results = combinator.combinationSum2(candidates, target);

        results.forEach(r -> System.out.println(r));

        var compare = results.containsAll(expectedSolution) && expectedSolution.containsAll(results);

        Assert.assertEquals(true, compare);


    }




}
