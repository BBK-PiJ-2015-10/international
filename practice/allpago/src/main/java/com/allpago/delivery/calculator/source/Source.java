package com.allpago.delivery.calculator.source;

import com.allpago.delivery.calculator.network.Node;

import java.util.Set;

public interface Source {

    Set<Node> load();

}
