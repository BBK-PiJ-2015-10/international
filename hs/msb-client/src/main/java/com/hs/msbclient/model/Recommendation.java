package com.hs.msbclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class Recommendation {

    public Recommendation() { }

    public Recommendation(int productId, int recommendationId, String author, int rate, String content, String serviceAddress) {
        this.productId = productId;
        this.recommendationId = recommendationId;
        this.author = author;
        this.rate = rate;
        this.content = content;
        this.serviceAddress = serviceAddress;
    }

    private int productId;

    private int recommendationId;

    private String author;

    private int rate;

    private String content;

    private String serviceAddress;

}
