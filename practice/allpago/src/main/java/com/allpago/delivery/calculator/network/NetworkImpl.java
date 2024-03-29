package com.allpago.delivery.calculator.network;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class NetworkImpl implements Network {

    private Set<Node> network = new HashSet<>();

    @Override
    public Set<Node> getNetwork() {
        return network;
    }
}
