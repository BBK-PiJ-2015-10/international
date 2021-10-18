package com.hs.client.sink;

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

@Component
@Slf4j
public class SinkClient {

    private RestTemplate restTemplate;

    private String dataServiceUrl;

    @Autowired
    public SinkClient(@Value("${app.data-service.host}") String dataServiceHost,
                        @Value("${app.data-service.port}") int dataServicePort,
                        RestTemplateBuilder restTemplateBuilder) {
        this.dataServiceUrl = "http://" + dataServiceHost + ":" + dataServicePort +
                "/data";
        this.restTemplate = restTemplateBuilder.build();
    }


    public void submitTopRecommendation(Recommendation recommendation){
        val endpoint = "/recommendation";
        String response = restTemplate.postForObject(dataServiceUrl+endpoint,recommendation,String.class);
        log.info("Submitted recommendation for product {} with rating and response  {}",recommendation.getProductId(),
                recommendation.getRate(),response);
    }

}
