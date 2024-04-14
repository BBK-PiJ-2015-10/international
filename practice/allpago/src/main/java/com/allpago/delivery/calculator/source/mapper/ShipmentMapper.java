package com.allpago.delivery.calculator.source.mapper;

import com.allpago.delivery.calculator.shipment.Shipment;

import java.util.List;

public interface ShipmentMapper {

    List<Shipment> toShipments(List<String> shipmentsInput);
}
