package com.allpago;

import com.allpago.delivery.calculator.Coordinator;
import com.allpago.delivery.calculator.distance.DistanceCalculator;
import com.allpago.delivery.calculator.source.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Collectors;

//https://medium.com/edureka/what-is-dependency-injection-5006b53af782

@SpringBootApplication
public class AllpagoApplication {

    private static Logger logger = LoggerFactory.getLogger(AllpagoApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context  = SpringApplication.run(AllpagoApplication.class, args);
        Source c = context.getBean(Source.class);
        c.load();
        var nodes = c.getNetwork();
        DistanceCalculator dc = context.getBean(DistanceCalculator.class);
        dc.setNetwork(c.getNetwork());
        //var md = dc.getMinimumDistance("ME","G");

        logger.info("Have {} number of nodes",nodes.size());
        var cat = nodes.stream().map(n -> n.getId()).collect(Collectors.toSet());
        logger.info("Have {} number of nodes",cat);

        var md = dc.getMinimumDistance("ME","G");

        logger.info("DONE FUCKERS");
        logger.info("The distance from {} to {} is {}","ME","G",md);
        logger.info("DONE FUCKERS");


    }

}
