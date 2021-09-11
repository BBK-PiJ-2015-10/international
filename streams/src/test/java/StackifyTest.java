import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

//Source : https://stackify.com/streams-guide-java-8/
public class StackifyTest {

    private static Employee[] arraysOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Asshole", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    private static Employee[] arraysOfEmps2 = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(4, "Mark Culonculontonton", 300000.0),
            new Employee(2, "Bill Asshole", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };


    @Test
    public void test1(){
        List<Integer> intList = Stream.of(2,4,5,6,8).collect(Collectors.toList());
        Map<Boolean, List<Integer>> isEvent = intList.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));

        assertEquals(4,isEvent.get(true).size());
        assertEquals(1,isEvent.get(false).size());
    }


    @Test
    public void test2(){
        Map<Character,List<Employee>> groupByAlphabet = Arrays.asList(arraysOfEmps)
            .stream()
            .collect(Collectors.groupingBy(e -> new Character(e.getName().charAt(0))))
        ;

        assertEquals("Bill Asshole",groupByAlphabet.get('B').get(0).getName());
        assertEquals("Jeff Bezos",groupByAlphabet.get('J').get(0).getName());
        assertEquals("Mark Zuckerberg",groupByAlphabet.get('M').get(0).getName());
    }

    @Test
    public void test3(){
        Map<Character,List<Integer>> idGroupedByAlphabet = Arrays.asList(arraysOfEmps)
                .stream()
                .collect(Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
                        Collectors.mapping(Employee::getId,Collectors.toList()))
                );

        assertEquals(idGroupedByAlphabet.get('B').get(0), new Integer(2));
        assertEquals(idGroupedByAlphabet.get('J').get(0), new Integer(1));
        assertEquals(idGroupedByAlphabet.get('M').get(0), new Integer(3));

    }

    //reducing
    @Test
    public void reducingTest(){
        double percentage = 10.0;
        double salIncrOverhead  = Arrays.asList(arraysOfEmps).stream().collect(Collectors.reducing(0.0,
                e -> e.getSalary() * percentage / 100,
                (s1,s2) -> s1+ s2));

        System.out.println(salIncrOverhead);
        assertEquals(new Double(60000),salIncrOverhead,0);

    }

    //reducing 2
    @Test
    public void reducingWithGrouping(){

        Comparator<Employee> byNameLength = Comparator.comparing(e -> e.getName().length());

        Map<Character, Optional<Employee>> longestNameByAlphabet =  Arrays.asList(arraysOfEmps2).stream()
                .collect(
                        Collectors.groupingBy(e -> e.getName().charAt(0),
                        Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(e -> e.getName().length())))
                ));

        assertEquals(longestNameByAlphabet.get('B').get().getName(), "Bill Asshole");
        assertEquals(longestNameByAlphabet.get('J').get().getName(), "Jeff Bezos");
        assertEquals(longestNameByAlphabet.get('M').get().getName(), "Mark Culonculontonton");


    }








}
