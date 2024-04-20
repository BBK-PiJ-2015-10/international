package com.allpago.delivery.calculator;

import com.allpago.delivery.calculator.distance.DistanceCalculator;
import com.allpago.delivery.calculator.network.Node;

import java.util.Set;

public interface DeliveryCostCalculator {

    String calculateCosts(String fromId, String toId, int length, int width, int depth, double weight, Set<Node> network);

    //DistanceCalculator getDistanceCalculator();

}
