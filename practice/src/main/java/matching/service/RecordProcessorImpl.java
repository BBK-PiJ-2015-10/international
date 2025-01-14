package matching.service;

import matching.dto.Row;
import matching.source.Source;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RecordProcessorImpl {

    private Source source;

    private Map<Integer, Row> uuidRowMap = new HashMap();

    public RecordProcessorImpl(Source source) {
        this.source = source;
    }


    public void process() {

        source.fetchInput().forEach(row ->
                uuidRowMap.put(row.studentId(),row)
        );


    }

}
