import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Processor {

    public List<String> process(String acceptedLanguages, List<String> supportedLanguages) {

        return Arrays.asList(StringUtils.deleteWhitespace(acceptedLanguages).split(","))
            .stream().distinct().filter(supportedLanguages::contains).collect(Collectors.toList());

    }

}
