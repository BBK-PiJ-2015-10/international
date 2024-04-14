package com.allpago.delivery.calculator.source;

import com.allpago.delivery.calculator.distance.DistanceCalculatorImpl;
import com.allpago.delivery.calculator.network.Node;
import com.allpago.delivery.calculator.source.mapper.InputMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

@Component
public class SourceImpl implements Source {

    Logger logger = LoggerFactory.getLogger(SourceImpl.class);

    String fileName = "allpago/src/main/resources/input/03.csv";

    private InputMapper inputMapper;


    @Autowired
    public SourceImpl(InputMapper inputMapper) {
        this.inputMapper = inputMapper;
    }

    @Override
    public Set<Node> load() {

        var path = Paths.get(fileName);

        String data = "";

        try {
            data = Files.readString(path);
        } catch (IOException e) {
            logger.error("Error reading data due to {}", data);
        }

        logger.info("Read {}", data);

        var result = inputMapper.toGraph(data);

//        String read = Files.readString(path);
//
//        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//
//            stream.forEach(System.out::println);
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//
        return result;
    }


}
