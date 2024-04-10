package com.allpago.delivery.calculator.source.mapper;

import com.allpago.delivery.calculator.network.Node;

public interface InputMapper {

    Node toNode(String input);
}
