package com.hubspot.invitationserviceweb.sink;

import com.hubspot.invitationserviceweb.model.Countries;
import com.hubspot.invitationserviceweb.model.Country;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class ResultClient {

    RestTemplate restTemplate;

    private String resultServiceURL;

    @Autowired
    public ResultClient(@Value("${app.result-service.host}") String partnerServiceURL,
                         RestTemplateBuilder restTemplateBuilder) {
        this.resultServiceURL = "https://" + partnerServiceURL;
        this.restTemplate = restTemplateBuilder.build();
    }


    public void postCountryAvailabilities(List<Country> countryList){
        val countries = new Countries();
        countries.setCountries(countryList);
        log.info("Submitting {}",countries);
        String queryParam = "?userKey=e90ffe5410d099d885bb3ce51006";
        String resultEndpoint  = resultServiceURL+"/candidateTest/v3/problem/result"+queryParam;
        //String response = restTemplate.postForObject(resultEndpoint,countries,String.class);
        //log.info("Received response {} on submission",response);
    }
}
