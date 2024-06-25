package codility.tricolorAnalyzer;

import codility.tricolortower.TriColorTowersAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class TriColorTowerAnalyzerSpec {

    private TriColorTowersAnalyzer analyzer = new TriColorTowersAnalyzer();

    @Test
    public void test1() {

        String[] input = new String[]{"aab", "cab", "baa", "baa"};

        var result = analyzer.maxNumberOfTowersSameColorOrderFaster(input);

        Assert.assertEquals(3, result);
    }

    @Test
    public void test2() {

        String[] input = new String[]{"zzz", "zbz", "zbz", "dgf"};

        var result = analyzer.maxNumberOfTowersSameColorOrderFaster(input);

        Assert.assertEquals(2, result);
    }


    @Test
    public void test3() {

        String[] input = new String[]{"abc", "cba", "cab", "bac", "bca"};

        var result = analyzer.maxNumberOfTowersSameColorOrderFaster(input);

        Assert.assertEquals(3, result);
    }

}
