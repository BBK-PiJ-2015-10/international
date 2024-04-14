package com.allpago.delivery.calculator.source.mapper;

import com.allpago.delivery.calculator.network.Node;

import java.util.Set;

public interface NodeMapper {

    Set<Node> toGraph(String input);


}
