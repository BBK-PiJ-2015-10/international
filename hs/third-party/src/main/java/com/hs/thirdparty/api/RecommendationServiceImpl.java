package com.hs.thirdparty.api;

import com.hs.thirdparty.model.Recommendation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class RecommendationServiceImpl implements RecommendationService{

    @Override
    public List<Recommendation> getRecommendations(int productId) {
        log.info("Fetching recommendations for product with id {}",productId);
        val reco = new Recommendation(1,201,"Herr Kuhl",10,"Pics","www.mailchimp.com");
        log.info("Returned {}",reco);
        return Arrays.asList(reco);

    }

}
