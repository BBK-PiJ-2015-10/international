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

}
