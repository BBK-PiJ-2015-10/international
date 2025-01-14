package matching.source;

import matching.dto.Row;
import matching.mapper.Mapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class SourceImpl implements Source {

    private Logger logger = Logger.getLogger(SourceImpl.class.getName());

    private String fileAddress;

    private final Mapper mapper;

    public SourceImpl(String fileAddress, Mapper mapper) {
        this.fileAddress = fileAddress;
        this.mapper = mapper;
    }

    @Override
    public Stream<Row> fetchInput() {
        logger.info("Fetching input from" + fileAddress);
        try (Stream<String> lines = Files
                .lines(Path.of(fileAddress))) {
            var rows = lines.parallel()
                    .filter(l -> l.startsWith("grand_parent_uuid"))
                    .map(line -> mapper.mapToRow(line));
            return rows;
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error while reading " + fileAddress, e);
            throw new RuntimeException(e);
        }
    }

}
