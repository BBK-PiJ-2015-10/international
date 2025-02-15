package jpmorgan;

import org.junit.Assert;
import org.junit.Test;

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

        /*
            @Test
    public void test1(){

        int[] candidates3 = new int[]{1,2,3,4,5};



6


starting with 1 vs 5
sol (1,5)


starting with 1 vs 4
pot (4)

starting with 1 vs 3
pot (4)
if higher replace 4 with 3
pot (3)

starting with 1 vs 2
pot (3)
sol(1,2,3)
pot()

needs to keep going
moving to 3
val pot = (3)
    }

         */

//        int target = 8;
//
//        int[] candidates = new int[]{10,1,2,7,6,1,5};
//
//        int[] candidates2 = new int[]{7,6,5,2,1,1};
//
//        int[] candidates3 = new int[]{1,1,2,5,6,7};
//
//        var l1 = List.of(1,1,6);
//        var l2 = List.of(1,2,5);
//        var l3 = List.of(1,7);
//        var l4 = List.of(2,6);
//
//        var result = combinator.combinationSum2(candidates,target);
//
//        Assert.assertEquals(true,true);

    }


}
