package com.hs.msbwclient;

import com.hs.msbwclient.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsbwClientApplication implements CommandLineRunner {

    @Autowired
    private RecommendationService recommendationService;


    public static void main(String[] args) {

        SpringApplication.run(MsbwClientApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        recommendationService.processTopRecommendation(4);
    }
}
