package com.allpago.delivery.calculator.source;

import com.allpago.delivery.calculator.network.Node;
import com.allpago.delivery.calculator.shipment.Shipment;

import java.util.List;
import java.util.Set;

public interface Source {

    void load(String fileName);

    Set<Node> getNetwork();

    List<Shipment> getShipments();

}
