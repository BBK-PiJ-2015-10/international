package jerry;

import org.junit.Assert;
import org.junit.Test;
import paxos.Practical;

import java.util.List;

public class PracticalTest {

    private Practical practical = new Practical();

    @Test
    public void test1() {

        var result = practical.minimalOperations(List.of("add", "book", "break"));

        Assert.assertEquals(result, List.of(1, 1, 0));

    }

    @Test
    public void test2() {

        var input = List.of(
                "zqzcdhefjzuqfkigwydqalimitpkwduxsauxslqanstag",
                "vmggduj scxesizsjycskimjtqfcoctyrgxjdpyeowavlriojizsrggnywkijdodicyhfreurltzaouzksugugn",
                "ouoj rgpgkuixdbuddltrvfpjzzwafmqdmmku",
                "zqbfnhbabvfavoztvohurpgicqtczwnxvlxxtvuglaqltafawjcwgagj inrdmobhnauebvgdufxegtbgaqysfwdqyhsgloahwnb",
                "lasoembsbtjgwacvuvygavlwfuedjwwhyhyjwxkfbtofjogogkjojyxncfmekmowcjmk",
                "rdfrxmmwwgyfwrboqfnwpngroegtkfoyypektjj",
                "gpslaqj tcxixtsucjvjolxjbndilpdtzxdndlow",
                "xwrhmpcsqmednmqzthrtjlnggvfpmdqkfadhe"
        );

        var result = practical.minimalOperations(input);

        System.out.println(result);

        Assert.assertEquals(result, List.of(0,2,3,1,1,4,0,1));

    }

    @Test
    public void test3() {

        var input = List.of(
                "ggrgg"
        );

        var result = practical.minimalOperations(input);

        Assert.assertEquals(List.of(2),result);

    }

}
