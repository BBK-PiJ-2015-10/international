package intern.patterns.tries;

import inter.patterns.tries.Trie;
import org.junit.Assert;
import org.junit.Test;

public class TrieTest {

    @Test
    public void test1() {

        Trie trie = new Trie();

        trie.insert("top");

        var hasWord = trie.search("top");
        var hasPrefix = trie.hasPrefix("top");


        Assert.assertEquals(true, hasWord);
        Assert.assertEquals(true, hasPrefix);

    }

    @Test
    public void test2() {

        Trie trie = new Trie();

        trie.insert("top");
        trie.insert("bye");

        Assert.assertEquals(true, trie.hasPrefix("to"));
        Assert.assertEquals(false, trie.search("to"));

        trie.insert("to");
        Assert.assertEquals(true, trie.search("to"));

    }


}
