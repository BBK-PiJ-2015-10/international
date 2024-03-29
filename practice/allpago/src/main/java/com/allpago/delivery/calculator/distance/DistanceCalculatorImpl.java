package com.allpago.delivery.calculator.distance;

import com.allpago.delivery.calculator.network.Network;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistanceCalculatorImpl implements DistanceCalculator {

    private Network network;

    @Autowired
    public DistanceCalculatorImpl(Network network) {
        this.network = network;
    }

    Logger logger = LoggerFactory.getLogger(DistanceCalculatorImpl.class);

    @Override
    public double getMinimumDistance(String startId, String destinationId) {

        logger.info("The network is empty: {}",network.getNetwork().isEmpty());
        logger.info("Calculating mininum distance from: {} to: {}", startId, destinationId);
        return 1;
    }
}
