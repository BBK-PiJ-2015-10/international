package com.allpago.delivery.calculator;

import com.allpago.delivery.calculator.shipment.Shipment;
import com.allpago.delivery.calculator.source.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Component
public class ExecutorImpl implements Executor {

    private static Logger logger = LoggerFactory.getLogger(ExecutorImpl.class);

    private Source source;

    private DeliveryCostCalculator deliveryCostCalculator;

    @Autowired
    public ExecutorImpl(Source source, DeliveryCostCalculator deliveryCostCalculator) {
        this.source = source;
        this.deliveryCostCalculator = deliveryCostCalculator;
    }

    @Override
    public boolean execute(String fileDirectoryPath) {
        try {
            var files = Files.list(Paths.get(fileDirectoryPath)).collect(Collectors.toSet());
            logger.info("Directory has {} files", files.size());
            files.forEach(d -> process(source, deliveryCostCalculator, d));
        } catch (Exception e) {

        }
        return true;
    }

    private void process(Source c, DeliveryCostCalculator dcc, Path filePath) {
        logger.info("Processing file {}", filePath);
        c.load(filePath.toString());
        for (Shipment shipment : c.getShipments()) {
            var cost = dcc.calculateCosts(shipment.getFromId(), shipment.getToId(), shipment.getLenght(), shipment.getWidth(), shipment.getDepth(), shipment.getWeight(), c.getNetwork());
            if (shipment.getExpectedCost().trim().equals(cost.trim())) {
                logger.info("The cost for {} matches expected {} and is {}", shipment, shipment.getExpectedCost(), cost);
            } else {
                logger.error("The cost for {} does not match expected {} and is {}", shipment, shipment.getExpectedCost(), cost);
            }
        }
        logger.info("Thank you.");
    }
}
