package com.hs.client.api;

import com.hs.client.model.Recommendation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface Advisor {

    @GetMapping(
            value = "/product/{productId}",
            produces = "application/json"
    )
    List<Recommendation> topRecommendations(@PathVariable int productId);

    @PostMapping(
            value ="product/{productId}/recommendation/top"
    )
    void submitTopRecommendation(@PathVariable int productId);


    @PostMapping(
            value = "/recommendation",
            consumes = "application/json",
            produces = "application/json"
    )
    Recommendation createRecommendation(@RequestBody Recommendation recommendation);



}
