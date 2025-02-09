package palantir;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreePathCostSearchTest {

    BinaryTreePathCostSearch tree = new BinaryTreePathCostSearch();

    @Test
    public void test1() {


        var iia = new BinaryNode(28, null, null);
        var iib = new BinaryNode(13, null, null);

        var ia = new BinaryNode(10, iia, iib);

        var paths = tree.findPathsMeetingCost(38, ia);

        for (String path : paths) {
            System.out.println(path);
        }


        Assert.assertEquals(1, paths.size());

    }

    @Test
    public void test2() {

        var iva = new BinaryNode(21, null, null);
        var ivb = new BinaryNode(22, null, null);
        var iiia = new BinaryNode(14, iva, ivb);
        var iia = new BinaryNode(28, null, iiia);

        var ivc = new BinaryNode(23, null, null);
        var ivd = new BinaryNode(21, null, null);
        var iiib = new BinaryNode(15, ivc, ivd);
        var iib = new BinaryNode(13, null, iiib);

        var ia = new BinaryNode(10, iia, iib);

        var paths = tree.findPathsMeetingCost(38, ia);

        for (String path : paths) {
            System.out.println(path);
        }

        Assert.assertEquals(1, paths.size());
        Assert.assertEquals("10-28", paths.get(0));

    }

    @Test
    public void test3() {

        var iia = new BinaryNode(20, null, null);

        var ivbaa = new BinaryNode(6, null, null);
        var iiiba = new BinaryNode(4, ivbaa, null);
        var iiibb = new BinaryNode(15, null, null);
        var iib = new BinaryNode(3, iiiba, iiibb);

        var ia = new BinaryNode(10, iia, iib);

        var paths = tree.findPathsMeetingCost(1, ia);

        for (String path : paths) {
            System.out.println(path);
        }

        Assert.assertEquals(0, paths.size());

    }


}
