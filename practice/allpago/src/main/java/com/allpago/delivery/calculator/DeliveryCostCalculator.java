package com.allpago.delivery.calculator;

public interface DeliveryCostCalculator {

    String calculateCosts(String fromId, String toId, int length, int width, int depth, double weight);

}
