package com.allpago;

import com.allpago.delivery.calculator.DeliveryCostCalculator;
import com.allpago.delivery.calculator.distance.DistanceCalculator;
import com.allpago.delivery.calculator.shipment.Shipment;
import com.allpago.delivery.calculator.source.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


//https://medium.com/edureka/what-is-dependency-injection-5006b53af782

@SpringBootApplication
public class AllpagoApplication {

    private static Logger logger = LoggerFactory.getLogger(AllpagoApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AllpagoApplication.class, args);
        Source c = context.getBean(Source.class);
        c.load();

        DeliveryCostCalculator dcc = context.getBean(DeliveryCostCalculator.class);
        DistanceCalculator dc = dcc.getDistanceCalculator();
        dc.setNetwork(c.getNetwork());

        for (Shipment shipment : c.getShipments()) {
            var cost = dcc.calculateCosts(shipment.getFromId(), shipment.getToId(), shipment.getLenght(), shipment.getWidth(), shipment.getDepth(), shipment.getWeight());
            String nr = "~";
            String ec = shipment.getExpectedCost().trim();
            if (!nr.contains(ec)) {
                var expectedCost = Double.valueOf(shipment.getExpectedCost());
                var actualCost = Double.valueOf(cost);
                var factor = expectedCost / actualCost;
                logger.info("Factor is {} ", factor);
            }
            logger.info("The cost for {} is expected {} and is {}", shipment, shipment.getExpectedCost(), cost);
        }
        logger.info("Thank you.");

    }

}
