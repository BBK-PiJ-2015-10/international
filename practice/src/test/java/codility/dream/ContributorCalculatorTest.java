package codility.dream;

import org.junit.Assert;
import org.junit.Test;

public class ContributorCalculatorTest {

    private ContributorCalculator contributorCalculator = new ContributorCalculatorImpl();

    @Test
    public void test1() {

        int[] A = new int[]{4, 2, 1};
        int[] B = new int[]{2, 5, 3};

        var maxContribution = contributorCalculator.maxContribution(A, B, 2);

        System.out.println(maxContribution);

        Assert.assertEquals(10, maxContribution);

    }

    @Test
    public void test2() {

        int[] A = new int[]{7, 1, 4, 4};
        int[] B = new int[]{5, 3, 4, 3};

        var maxContribution = contributorCalculator.maxContribution(A, B, 2);

        System.out.println(maxContribution);

        Assert.assertEquals(18, maxContribution);

    }

    @Test
    public void test3() {

        int[] A = new int[]{5, 5, 5};
        int[] B = new int[]{5, 5, 5};

        var maxContribution = contributorCalculator.maxContribution(A, B, 1);

        System.out.println(maxContribution);

        Assert.assertEquals(15, maxContribution);

    }

    @Test
    public void test4() {

        int[] A = new int[]{5, 4, 3};
        int[] B = new int[]{6, 6, 6};

        var maxContribution = contributorCalculator.maxContribution(A, B, 3);

        System.out.println(maxContribution);

        Assert.assertEquals(12, maxContribution);

    }

    @Test
    public void test5() {

        int[] A = new int[]{5, 4, 3};
        int[] B = new int[]{6, 6, 6};

        var maxContribution = contributorCalculator.maxContribution(A, B, 0);

        System.out.println(maxContribution);

        Assert.assertEquals(18, maxContribution);

    }

    @Test
    public void test6() {

        int[] A = new int[]{7, 7, 7};
        int[] B = new int[]{6, 6, 6};

        var maxContribution = contributorCalculator.maxContribution(A, B, 0);

        System.out.println(maxContribution);

        Assert.assertEquals(18, maxContribution);

    }


}
