package com.allpago.delivery.calculator.shipment;

import lombok.Getter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ToString
public class Shipment {

    private @Getter  String fromId;

    private @Getter String toId;

    private @Getter int lenght;

    private @Getter int width;

    private @Getter int depth;

    private @Getter double weight;

    private @Getter String expectedCost;

}
