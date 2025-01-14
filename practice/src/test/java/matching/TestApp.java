package matching;

import org.junit.Test;
import org.junit.Assert;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class TestApp {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Test
    public void firstTest() {

        var fileAddress= "src/test/java/matching/input/input_list.csv";



        try (Stream<String> lines = Files
                .lines(Path.of(fileAddress))) {
            var rows = lines.parallel()
                    .filter(l -> !l.startsWith("grand_parent_uuid"));
            rows.forEach(d -> logger.info(d));

                    //.map(line -> mapper.mapToRow(line));
        } catch (IOException e) {
            logger.log(Level.WARNING,"Error while reading" + fileAddress, e);
            throw new RuntimeException(e);
        }


        Assert.assertEquals(true, true);

    }


}
