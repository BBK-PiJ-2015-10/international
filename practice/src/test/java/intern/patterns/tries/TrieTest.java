package intern.patterns.tries;

import inter.patterns.tries.Trie;
import org.junit.Assert;
import org.junit.Test;

public class TrieTest {

    private Trie trie = new Trie();

    @Test
    public void test1() {

        trie.insert("top");

        var hasWord = trie.search("top");

        var hasPrefix = trie.search("top");


        Assert.assertEquals(true, hasWord);
        Assert.assertEquals(true, hasPrefix);

    }


}
