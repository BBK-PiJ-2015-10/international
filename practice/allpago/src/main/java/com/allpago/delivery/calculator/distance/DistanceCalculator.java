package com.allpago.delivery.calculator.distance;

//import com.allpago.delivery.calculator.network.Network;
import com.allpago.delivery.calculator.network.Node;

import java.util.Set;

public interface DistanceCalculator {

    double getMinimumDistance(String startId, String destinationId,Set<Node> network);

   // void setNetwork(Set<Node> network);

}
