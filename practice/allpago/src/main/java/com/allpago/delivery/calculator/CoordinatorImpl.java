package com.allpago.delivery.calculator;

import com.allpago.delivery.calculator.distance.DistanceCalculator;
import com.allpago.delivery.calculator.distance.DistanceCalculatorImpl;
import com.allpago.delivery.calculator.network.Network;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CoordinatorImpl implements Coordinator {

    private Network network;

    @Autowired
    public CoordinatorImpl(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    private DistanceCalculator distanceCalculator;

    @Override
    public void execute() {

        distanceCalculator.getMinimumDistance("cat", "dog");
    }
}
