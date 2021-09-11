import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;


//import static org.junit.matchers.JUnitMatchers.*;

import java.util.ArrayList;
import java.util.List;

public class ProcessorTest {

    private Processor processor = new Processor();

    @Test
    public void test1(){
        String acceptedLanguages = "en-US, fr-CA, fr-FR";
        List<String> supportedLanguages = List.of("fr-FR", "en-US");

        List<String> response = processor.process(acceptedLanguages,supportedLanguages);

        Assert.assertEquals("en-US",response.get(0));
        Assert.assertEquals("fr-FR",response.get(1));
        Assert.assertEquals(2,response.size());
    }

    @Test
    public void test2(){
        String acceptedLanguages = "fr-CA, fr-FR";
        List<String> supportedLanguages = List.of("en-US", "fr-FR");

        List<String> response = processor.process(acceptedLanguages,supportedLanguages);

        Assert.assertEquals("fr-FR",response.get(0));
        Assert.assertEquals(1,response.size());

    }

    @Test
    public void test3(){
        String acceptedLanguages = "en-US";
        List<String> supportedLanguages = List.of("en-US", "fr-CA");

        List<String> response = processor.process(acceptedLanguages,supportedLanguages);

        Assert.assertEquals("en-US",response.get(0));
        Assert.assertEquals(1,response.size());

    }

    @Test
    public void test4Empty(){
        String acceptedLanguages = "     ";
        List<String> supportedLanguages = List.of("en-US", "fr-CA");

        List<String> response = processor.process(acceptedLanguages,supportedLanguages);

        Assert.assertEquals(0,response.size());

    }

    @Test
    public void test5Empty(){

        String acceptedLanguages = "     ";
        List<String> supportedLanguages = new ArrayList<>();

        List<String> response = processor.process(acceptedLanguages,supportedLanguages);

        Assert.assertEquals(0,response.size());

    }

    @Test
    public void test6Empty(){

        String acceptedLanguages = "en-US, fr-CA, fr-FR";
        List<String> supportedLanguages = new ArrayList<>();

        List<String> response = processor.process(acceptedLanguages,supportedLanguages);

        Assert.assertEquals(0,response.size());

    }

    @Test
    public void test6Duplicates(){
        String acceptedLanguages = "en-US, fr-CA, fr-FR, en-US";
        List<String> supportedLanguages = List.of("fr-FR", "en-US");

        List<String> response = processor.process(acceptedLanguages,supportedLanguages);

        Assert.assertEquals("en-US",response.get(0));
        Assert.assertEquals("fr-FR",response.get(1));
        Assert.assertEquals(2,response.size());
    }

}
