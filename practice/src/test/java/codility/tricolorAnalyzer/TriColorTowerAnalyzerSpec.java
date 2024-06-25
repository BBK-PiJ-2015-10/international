package codility.tricolorAnalyzer;

import codility.tricolortower.TriColorTowersAnalyzer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TriColorTowerAnalyzerSpec {

    private TriColorTowersAnalyzer analyzer = new TriColorTowersAnalyzer();

    @Test
    public void test1() {

        var culon = "culon";

        var other = culon.chars().mapToObj(e -> (char) e)
                .map(c -> c.toString())
                .collect(Collectors.toList());

        var other1 = Arrays.asList(culon.toCharArray())
                .stream()
                .map(c -> c.toString()).collect(Collectors.toList());

                //Arrays.asList(culon.split(""));

        System.out.println("CULON: " + other1.size());

        //int[] A = new int[]{1, 5, 2, 1, 4, 0};

        //var numberOfIntersections = intersectionAnalyzer.numberOfIntersections(A);

        //System.out.println(numberOfIntersections);

        //Assert.assertEquals(11,numberOfIntersections);
    }

}
