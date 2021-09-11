import org.junit.Test;

import java.util.List;
import org.junit.Assert;

public class InmutableTest {


    @Test
    public void test1BadImmutable(){

        Person student1 = new Person("alex","palacios");
        List<Person> students = List.of(student1);

        School school = new School("UL","London",students);

        Assert.assertEquals("alex",school.getStudents().get(0).getFirstName());

        student1.setFirstName("alexis");

        Assert.assertEquals("alexis",school.getStudents().get(0).getFirstName());


    }
}
