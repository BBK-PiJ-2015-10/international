package com.allpago.delivery.calculator.shipment;

import lombok.ToString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ToString
public class Shipment {

    private String fromId;

    private String toId;

    private int lenght;

    private int width;

    private int depth;

    private double weight;

    private String expectedCost;

}
