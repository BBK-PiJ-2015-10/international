package com.hs.client.source;

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

import java.util.List;

@Component
@Slf4j
public class SourceClient {

    private RestTemplate restTemplate;

    private String recommendationServiceUrl;

    @Autowired
    public SourceClient(@Value("${app.recommendation-service.host}") String recommendationServiceHost,
                                   @Value("${app.recommendation-service.port}") int recommendationServicePort,
                                   RestTemplateBuilder restTemplateBuilder) {
        this.recommendationServiceUrl = "http://" + recommendationServiceHost + ":" + recommendationServicePort +
                "/recommendation";
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Recommendation> getRecommendations(int productId){
        val queryParam = "?productId=" + productId;
        List<Recommendation> recommendations = restTemplate.exchange(recommendationServiceUrl + queryParam,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Recommendation>>() {
                }).getBody();
        log.info("Retrieved {} recommendations from {}",recommendations.size(),recommendationServiceUrl);
        return recommendations;
    }
}
