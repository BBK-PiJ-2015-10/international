package patterns;

import org.junit.Test;

public class BuilderTest {


    @Test
    public void test1(){

        Person.PersonBuilder builder = new Person.PersonBuilder()
            .withFirstName("alex")
            .withLastName("palacios");

        Person.PersonBuilder builder2 = new Person.PersonBuilder()
            .withFirstName("diego");

        Person person = builder.build();

        System.out.println(person.getFirstName());

    }


}
