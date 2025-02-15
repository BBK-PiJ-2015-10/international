package jpmorgan;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumTest {

    CombinationSum combinator = new CombinationSum();

    @Test
    public void test1(){

        int target = 8;

        int[] candidates = new int[]{10,1,2,7,6,1,5};

        int[] candidates2 = new int[]{7,6,5,2,1,1};

        int[] candidates3 = new int[]{1,1,2,5,6,7};

        var l1 = List.of(1,1,6);
        var l2 = List.of(1,2,5);
        var l3 = List.of(1,7);
        var l4 = List.of(2,6);

        var result = combinator.combinationSum2(candidates,target);

        Assert.assertEquals(true,true);

    }

    @Test
    public void test2(){

        int[] candidates = new int[]{1,2,3,4,5};
        int target = 6;

        var results = combinator.combinationSum2(candidates,target);

        results.forEach(e -> System.out.println(e));


        Assert.assertEquals(true,true);

    }

    @Test
    public void test3(){

        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;

        var results = combinator.combinationSum2(candidates,target);

        results.forEach(e -> System.out.println(e));


        Assert.assertEquals(true,true);

    }

    @Test
    public void test4(){

        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;

        var results = combinator.combinationSum2(candidates,target);

        results.forEach(e -> System.out.println(e));


        Assert.assertEquals(true,true);

    }

    @Test
    public void test32(){

        List<Integer> list1 = new LinkedList<>();
        list1.add(4);
        list1.add(5);
        List<Integer> list2 = new LinkedList<>();
        list2.add(4);
        list2.add(5);

        var cat  = list1.containsAll(list2);

        System.out.println(String.format("CAT IS %s",cat));


        Assert.assertEquals(true,true);

    }



}
