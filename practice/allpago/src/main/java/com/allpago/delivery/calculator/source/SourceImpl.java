package com.allpago.delivery.calculator.source;

import com.allpago.delivery.calculator.distance.DistanceCalculatorImpl;
import com.allpago.delivery.calculator.network.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Stream;


@Component
public class SourceImpl implements Source{

    Logger logger = LoggerFactory.getLogger(SourceImpl.class);

    String fileName = "allpago/src/main/resources/input/03.csv";


    public SourceImpl() {}

    @Override
    public Set<Node> load() {

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return Set.of();
    }



}
