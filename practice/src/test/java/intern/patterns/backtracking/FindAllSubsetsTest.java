package intern.patterns.backtracking;

import inter.patterns.backtracking.FindAllSubsets;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindAllSubsetsTest {

    private FindAllSubsets calculator = new FindAllSubsets();

    @Test
    public void test1() {

        int[] input = {};
        List<List<Integer>> result = calculator.findAllSubsets(input);

        Set<Set<Integer>> resultSet = result.stream().map(s -> s.stream().collect(Collectors.toSet())).collect(Collectors.toSet());

        Assert.assertEquals(Set.of(Set.of()), resultSet);
    }

    @Test
    public void test2() {

        int[] input = {4};
        List<List<Integer>> result = calculator.findAllSubsets(input);

        Set<Set<Integer>> resultSet = result.stream().map(s -> s.stream().collect(Collectors.toSet())).collect(Collectors.toSet());

        Assert.assertEquals(Set.of(Set.of(4), Set.of()), resultSet);
    }


    @Test
    public void test3() {

        int[] input = {4, 5, 6};
        List<List<Integer>> result = calculator.findAllSubsets(input);

        Set<Set<Integer>> resultSet = result.stream().map(s -> s.stream().collect(Collectors.toSet())).collect(Collectors.toSet());

        Assert.assertEquals(
                Set.of(
                        Set.of(), Set.of(4), Set.of(4, 5), Set.of(4, 5, 6),
                        Set.of(4, 6), Set.of(5), Set.of(5, 6), Set.of(6)

                ), resultSet);
    }
}
