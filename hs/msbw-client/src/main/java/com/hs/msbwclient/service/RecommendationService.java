package com.hs.msbwclient.service;

import com.hs.msbwclient.source.SourceClient;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
@Slf4j
public class RecommendationService {

    private SourceClient sourceClient;

    public RecommendationService(SourceClient sourceClient) {
        this.sourceClient = sourceClient;
    }

    public void processTopRecommendation(int productId){
        val recommendations = sourceClient.getRecommendations(productId);
    }


}
