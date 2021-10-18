package com.hs.dataservice.api;


import com.hs.dataservice.model.ProductAggregate;
import com.hs.dataservice.model.Recommendation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DataApiController implements DataApi {

    @Override
    public Recommendation topRecommendation(Recommendation recommendation) {
        log.info("Storing top recommendation for product with id {} and rating {}",recommendation.getProductId(),
                recommendation.getRate());
        return recommendation;
    }

    @Override
    public void createCompositeProduct(ProductAggregate productAggregate) {
        log.info("Creating a composite product aggregate for productId {}" +
                "with name {} and weight {}",productAggregate.getProductId(),productAggregate.getName(),
                productAggregate.getWeight());;
    }
}
