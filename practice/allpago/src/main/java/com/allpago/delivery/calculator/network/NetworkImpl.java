package com.allpago.delivery.calculator.network;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class NetworkImpl implements Network {

    private Set<Node> network;

    @Override
    public Set<Node> getNetwork() {
        return network;
    }

    @Override
    public void setNetwork(Set<Node> network) {
        this.network = network;
    }

}
