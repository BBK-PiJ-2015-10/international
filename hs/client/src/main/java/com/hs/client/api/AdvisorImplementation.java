package com.hs.client.api;

import com.hs.client.model.Recommendation;
import com.hs.client.service.RecommendationProcessor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class AdvisorImplementation implements Advisor{

    private RecommendationProcessor recommendationProcessor;

    public AdvisorImplementation(RecommendationProcessor recommendationProcessor) {
        this.recommendationProcessor = recommendationProcessor;
    }

    @Override
    public List<Recommendation> topRecommendations(int productId) {
        log.info("Fetching recommendations for productId {}",productId);
        //return Arrays.asList(new Recommendation(1,201,"Herr Kuhl",10,"Pics","www.mailchimp.com"));
        return recommendationProcessor.calculateTopRecommendations(productId);
    }

    @Override
    public Recommendation createRecommendation(Recommendation recommendation) {
        log.info("Creating recommendation {}",recommendation);
        return null;
    }
}
