package recurssiondp;

import org.junit.Test;

import java.util.List;

public class PermutationsTest {

    private Permutations permutations = new Permutations();

    @Test
    public void test1(){

        String input = "abc";

        char[] dog = input.toCharArray();

        char[] cat = dog.clone();
        cat[0] = 'L';

        System.out.println(String.valueOf(dog));

        System.out.println(String.valueOf(cat));


        //permutations.permutations(input);

    }

    @Test
    public void test2(){

        String input = "abc";

        List<String> results = permutations.permutations(input);

        results.forEach(System.out::println);

    }

}
