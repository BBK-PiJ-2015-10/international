package com.hs.client.service;

import com.hs.client.model.Recommendation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Component
@Slf4j
public class RecommendationProcessor {

    private String recommendationServiceUrl;

    private RestTemplate restTemplate;

    @Autowired
    public RecommendationProcessor(@Value("${app.recommendation-service.host}") String recommendationServiceHost,
                                   @Value("${app.recommendation-service.port}") int recommendationServicePort,
                                   RestTemplateBuilder restTemplateBuilder) {
        this.recommendationServiceUrl = "http://" + recommendationServiceHost + ":" + recommendationServicePort +
                "/recommendation";
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Recommendation> calculateTopRecommendations(int productId){
        val queryParam = "?productId=" + productId;
        List<Recommendation> recommendations = restTemplate.exchange(recommendationServiceUrl + queryParam,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Recommendation>>() {
                }).getBody()
                .stream()
                .sorted(Comparator.comparing(Recommendation::getRate))
                .limit(10).collect(Collectors.toList());
        log.info("Sending {} recommendations for productId {}",recommendations.size(),productId);
        return recommendations;
    }


}
