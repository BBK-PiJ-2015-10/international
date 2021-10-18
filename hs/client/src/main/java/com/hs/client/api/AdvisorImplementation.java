package com.hs.client.api;

import com.hs.client.model.Recommendation;
import com.hs.client.service.RecommendationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class AdvisorImplementation implements Advisor{

    private RecommendationService recommendationService;



    public AdvisorImplementation(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @Override
    public void submitTopRecommendation(int productId) {
        log.info("Submitting top recommendation for product with id {}",productId);
        recommendationService.processTopRecommendation(productId);
    }



    @Override
    public List<Recommendation> topRecommendations(int productId) {
        log.info("Fetching recommendations for productId {}",productId);
        //return Arrays.asList(new Recommendation(1,201,"Herr Kuhl",10,"Pics","www.mailchimp.com"));
        //return recommendationProcessor.calculateTopRecommendations(productId);
        return null;
    }

    @Override
    public Recommendation createRecommendation(Recommendation recommendation) {
        log.info("Creating recommendation {}",recommendation);
        return null;
    }
}
