package fourth;

import org.junit.Test;

public class CovarianceTest {

    private Wrapper wrapper = new Wrapper();


    @Test
    public void test1(){

        PrimarySchool school = new PrimarySchool("Hello");

        String result  = school.getName();

        System.out.println(result);

        String result2 = wrapper.introduce(school);

        System.out.println(result2);

        wrapper.bark(school);

    }

}
