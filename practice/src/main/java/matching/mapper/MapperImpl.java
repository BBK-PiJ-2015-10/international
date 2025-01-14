package matching.mapper;

import matching.dto.Row;
//import org.slf4j.Logger;
///import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.UUID;
import java.util.logging.Logger;

public class MapperImpl implements Mapper {

    private final Logger logger = Logger.getLogger(MapperImpl.class.getName());

    @Override
    public Row mapToRow(String rowString) {
        logger.info("Mapping row string: "+ rowString);
        var input = Arrays.asList(rowString.split(","));

        var grandParentUuid = UUID.fromString(input.get(0));
        var parentId = Integer.valueOf(input.get(1));
        var fundingBucketUuid = UUID.fromString(input.get(2));
        var studentId = Integer.valueOf(input.get(3));
        var studentType = input.get(4);
        var currency = input.get(5);
        var studentName = input.get(6);
        var row = new Row(
                grandParentUuid, parentId, fundingBucketUuid, studentId, studentType, currency, studentName
        );
        logger.info("Mapped row:" + row);
        return row;
    }
}
