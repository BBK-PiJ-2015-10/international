package veinteream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordsFilteringTest {

    public WordsFiltering filtering = new WordsFiltering();

    @Test
    public void test1() {

        String[] words = {"the", "dog", "got", "a", "bone"};

        String letters = "ae";

        List<String> solution = filtering.filterWords(words, letters);

        Assert.assertEquals(List.of("the", "a", "bone"), solution);

    }

}
