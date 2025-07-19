package intern.patterns;

import inter.patterns.Practice;
import org.junit.Assert;
import org.junit.Test;

import javax.sound.midi.SysexMessage;

public class PracticeTest {

    private Practice practice = new Practice();

    @Test
    public void findInsertionIndex(){

        int[] input = {0,-1,2,-3,1};

        var result = practice.findTripletSum(input);

        System.out.println(result);

        //Assert.assertEquals(result,2);
    }


}
