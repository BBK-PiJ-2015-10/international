package matching.transformer;

import matching.dto.Row;

public class TransformerImpl implements Transformer {

    @Override
    public Row transform(Row row) {
        var transformedRow = new Row(
                row.grandParentUuid(), row.parentId(), row.fundingBucketUuid(), row.studentId(), row.studentType(),
                row.currency(), row.studentName()+"cat"
        );
        return transformedRow;
    }
}
