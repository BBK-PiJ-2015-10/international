package paxos;

import java.util.*;
import java.util.logging.Logger;

public class Practical {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    // Min operations to substitute NPA
    public List<Integer> minimalOperations(List<String> words) {
        List<Integer> operations = new LinkedList<>();
        for (int i = 0; i < words.size(); i++) {
            var characters = words.get(i).trim().toLowerCase().toCharArray();
            int substitutedCount = 0;
            Character priorCharacter = null;
            Character lastSubstituted = null;
            for (int k = 0; k < characters.length; k++) {
                Character currentCharacter = characters[k];
                //logger.info(String.format("Current %s prior %s lastSubstituted %s", currentCharacter, priorCharacter, lastSubstituted));
                if (priorCharacter == currentCharacter) {
                    if (lastSubstituted != priorCharacter) {
                        substitutedCount++;
                    }
                    lastSubstituted = currentCharacter;
                } else {
                    lastSubstituted = null;
                }
                priorCharacter = currentCharacter;
            }
            operations.add(substitutedCount);
        }
        return operations;
    }

    public List<Integer> merge(List<Integer> sortedArray1, List<Integer> sortedArray2) {
        List<Integer> result = new LinkedList<>();
        int array1Pointer = 0;
        int array2Pointer = 0;
        while (array1Pointer <= sortedArray1.size() - 1 || array2Pointer <= sortedArray2.size() - 1) {
            var array1Value = sortedArray1.get(array1Pointer);
            var array2Value = sortedArray1.get(array2Pointer);
            //var comparison = array1Value.compareTo(array1Value);
            if (array1Value == array2Value) {
                if (array1Pointer <= array2Pointer) {
                    result.add(array1Value);
                    array1Pointer++;
                } else {
                    result.add(array2Value);
                    array2Pointer++;
                }
            } else if (array1Value < array2Value) {
                result.add(array1Value);
                array1Pointer++;
            } else {
                result.add(array2Value);
                array2Pointer++;
            }
        }
        return result;
    }

}
