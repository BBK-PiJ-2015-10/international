package com.hubspot.invitationserviceweb.source;

import com.hubspot.invitationserviceweb.model.Partner;
import com.hubspot.invitationserviceweb.model.Partners;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class PartnerClient {

    private RestTemplate restTemplate;

    private String partnerServiceURL;

    @Autowired
    public PartnerClient(@Value("${app.partner-service.host}") String partnerServiceURL, @Value("${app" +
            ".partner-service.port}") String partnerServicePort,
                         RestTemplateBuilder restTemplateBuilder) {
        //this.partnerServiceURL = "https://" + partnerServiceURL+";
        this.partnerServiceURL = "http://" + partnerServiceURL+":"+partnerServicePort;
        this.restTemplate = restTemplateBuilder.build();
    }


    public List<Partner> fetchPartnerAvailabilities(){
        String queryParam = "?userKey=e90ffe5410d099d885bb3ce51006";
        //String availabilityEndpoint  = partnerServiceURL+"/candidateTest/v3/problem/dataset"+queryParam;
        String availabilityEndpoint  = partnerServiceURL+"/availability"+queryParam;
        log.info(String.format("Sending request to %s",availabilityEndpoint));
        Partners partners= restTemplate.exchange(availabilityEndpoint,
                HttpMethod.GET, null,
                Partners.class).getBody();
        log.info("Retrieved {} partners from {}",partners.getPartners().size(),availabilityEndpoint);
        return partners.getPartners();
    }



}
