package com.allpago.delivery.calculator.source.mapper;

import com.allpago.delivery.calculator.shipment.Shipment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShipmentMapperImpl implements ShipmentMapper {

    private Logger logger = LoggerFactory.getLogger(ShipmentMapperImpl.class);

    public ShipmentMapperImpl() {
    }

    @Override
    public List<Shipment> toShipments(List<String> shipmentsInput) {
        var shipments = shipmentsInput.stream().map(si -> toShipment(si)).collect(Collectors.toList());
        return shipments;
    }


    private List<Shipment> toShipments(String shipmentsInput) {
        var shipmentsInfo = Arrays.asList(shipmentsInput.split(System.lineSeparator()));
        var shipments = shipmentsInfo.stream().map(si -> toShipment(si)).collect(Collectors.toList());
        return shipments;
    }

    private Shipment toShipment(String shipmentString) {
        logger.info("Processing shipment string: " + shipmentString);
        List<String> shipmentInfo = new ArrayList<>();
        Arrays.asList(shipmentString.split(",")).forEach(si -> shipmentInfo.add(si));
        shipmentInfo.remove("@");
        shipmentInfo.remove("");
        var values = shipmentInfo.stream().collect(Collectors.joining(", "));
        var toId = shipmentInfo.remove(0);
        var volume = shipmentInfo.get(0);
        var dims = Arrays.asList(volume.split("x"));
        int length = Integer.valueOf(dims.get(0));
        int width = Integer.valueOf(dims.get(1));
        int depth = Integer.valueOf(dims.get(2));
        double weight = Double.valueOf(dims.get(3));
        var expectedCost = shipmentInfo.get(1);
        Shipment shipment = new Shipment(
                "ME", toId, length, width, depth, weight, expectedCost);
        logger.info("Creating shipment {}", shipment);
        return shipment;
    }

}
