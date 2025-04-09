package inter.patterns.tries;

import java.util.*;

public class FindAllWords {

    public class TrieNode {

        public Map<Character, TrieNode> children = new HashMap<>();

        public Optional<String> word = Optional.empty();

        public TrieNode() {
        }

    }

    public List<String> findAllWords(List<List<Character>> boards, List<String> words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            var charsWord = word.toCharArray();
            for (int i = 0; i < charsWord.length; i++) {
                Character character = charsWord[i];
                var existing = node.children.get(character);
                if (existing == null) {
                    node.children.put(character, new TrieNode());
                }
                node = node.children.get(character);
            }
            node.word = Optional.of(word);
        }
        List<String> result  = new LinkedList<>();
        for (int i=0;i<boards.size();i++){
            var board = boards.get(i);
            for (int k=0;i<board.size();i++){
                var character = board.get(k);
                var existing = root.children.get(character);
                if (existing!=null){

                }
                //root.children.
            }
        }



        return null;
    }

    private void dfs(List<List<Character>> board,int row, int column,TrieNode node,List<String> result){
        if (node.word.isPresent()){
            result.add(node.word.get());
            node.word = Optional.empty();
        }
        var temp = board.get(row).get(column);

    }

}
