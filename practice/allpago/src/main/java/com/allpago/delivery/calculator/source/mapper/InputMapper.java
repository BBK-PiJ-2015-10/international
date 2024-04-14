package com.allpago.delivery.calculator.source.mapper;

import com.allpago.delivery.calculator.network.Node;

import java.util.Set;

public interface InputMapper {

    Set<Node> toGraph(String input);


}
