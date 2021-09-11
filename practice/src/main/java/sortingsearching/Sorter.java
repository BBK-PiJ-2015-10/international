package sortingsearching;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Sorter {

    public Queue<Integer> sort(Queue<Integer> input){
        return new LinkedList<>(input
            .stream()
            .sorted()
            .collect(Collectors.toList()));
    }
    
}
