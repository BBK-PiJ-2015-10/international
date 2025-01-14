package matching.dto;

import java.util.Optional;

public record RowDifference(Optional<Row> input, Optional<Row> output, Optional<Boolean> row1IsDiff) {
}
