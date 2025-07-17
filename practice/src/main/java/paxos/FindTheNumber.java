package paxos;

import ch.qos.logback.core.joran.conditional.ElseAction;

import java.util.LinkedList;
import java.util.List;

public class FindTheNumber {


    public String findNumber(List<Integer> arr, int k) {
        if (arr.contains(k)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public List<Integer> oddNumbers(int l, int k) {
        List<Integer> result = new LinkedList<>();
        int existing = l;
        boolean isEven = l % 2 == 0;
        if (isEven) {
            existing = l + 1;
        }
        while (existing <= k) {
            result.add(existing);
            existing = existing + 2;
        }
        return result;
    }
    //


}
