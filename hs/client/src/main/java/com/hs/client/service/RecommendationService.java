package com.hs.client.service;

import com.hs.client.model.Recommendation;
import com.hs.client.sink.SinkClient;
import com.hs.client.source.SourceClient;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
@Slf4j
public class RecommendationService {

    private SourceClient sourceClient;

    private SinkClient sinkClient;

    public RecommendationService(SourceClient sourceClient, SinkClient sinkClient) {
        this.sourceClient = sourceClient;
        this.sinkClient = sinkClient;
    }

    public void processTopRecommendation(int productId){
        val recommendations = sourceClient.getRecommendations(productId);
        val topRecommendation = recommendations
                .stream()
                .max(Comparator.comparing(Recommendation::getRate)).get();
        sinkClient.submitTopRecommendation(topRecommendation);
        log.info("Done processing top recommendation for product with id {}",productId);
    }



    /*

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

     */


}
