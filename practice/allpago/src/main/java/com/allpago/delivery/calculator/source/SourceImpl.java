package com.allpago.delivery.calculator.source;

import com.allpago.delivery.calculator.network.Node;
import com.allpago.delivery.calculator.shipment.Shipment;
import com.allpago.delivery.calculator.source.mapper.NodeMapper;
import com.allpago.delivery.calculator.source.mapper.ShipmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class SourceImpl implements Source {

    Logger logger = LoggerFactory.getLogger(SourceImpl.class);

    //String fileName = "allpago/src/main/resources/input/03.csv";

    private NodeMapper nodeMapper;

    private ShipmentMapper shipmentMapper;

    private Set<Node> network;

    private List<Shipment> shipments;

    @Autowired
    public SourceImpl(ShipmentMapper shipmentMapper, NodeMapper nodeMapper) {
        this.shipmentMapper = shipmentMapper;
        this.nodeMapper = nodeMapper;
    }

    @Override
    public Set<Node> getNetwork() {
        return network;
    }

    @Override
    public List<Shipment> getShipments() {
        return shipments;
    }

    @Override
    public void load(String fileName) {

        network = null;
        shipments = null;

        var path = Paths.get(fileName);

        String data = "";

        try {
            data = Files.readString(path);
        } catch (IOException e) {
            logger.error("Error matching data due to {}", data);
        }

        List<String> inputData = new ArrayList<>();
        Arrays.asList(data.split("@")).forEach(i -> inputData.add(i));

        var nodeData = inputData.remove(0);

        network = nodeMapper.toGraph(nodeData);
        shipments = shipmentMapper.toShipments(inputData);

//        String read = Files.readString(path);
//
//        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//
//            stream.forEach(System.out::println);
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }

    }


}
