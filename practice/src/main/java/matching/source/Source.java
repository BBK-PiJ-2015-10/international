package matching.source;

import matching.dto.Row;

import java.util.stream.Stream;

public interface Source {

    Stream<Row> fetchInput();

}
