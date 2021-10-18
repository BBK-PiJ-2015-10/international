package com.hs.dataservice.api;

import com.hs.dataservice.model.ProductAggregate;
import com.hs.dataservice.model.Recommendation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface DataApi {

    //  curl -X POST localhost:9090/data/recommendation -H "Content-Type: application/json" --data '{"productId":123,"name":"product 123","weight":123}'
    @PostMapping(
            value = "/data/recommendation",
            consumes = "application/json",
            produces = "application/json"
    )
    Recommendation topRecommendation(@RequestBody Recommendation recommendation);

    //  curl -X POST localhost:9090/product-composite -H "Content-Type: application/json" --data '{"productId":123,"name":"product 123","weight":123}'
    @PostMapping(
            value = "/product-composite",
            consumes = "application/json"
    )
    void createCompositeProduct(@RequestBody ProductAggregate productAggregate);




}
