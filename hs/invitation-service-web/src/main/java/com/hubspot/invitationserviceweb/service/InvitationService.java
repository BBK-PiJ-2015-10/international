package com.hubspot.invitationserviceweb.service;

import com.hubspot.invitationserviceweb.sink.ResultClient;
import com.hubspot.invitationserviceweb.source.PartnerClient;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InvitationService {

    private PartnerClient partnerClient;

    private AvailabilityCalculator availabilityCalculator;

    private ResultClient resultClient;

    public InvitationService(PartnerClient partnerClient, AvailabilityCalculator availabilityCalculator, ResultClient resultClient) {
        this.partnerClient = partnerClient;
        this.availabilityCalculator = availabilityCalculator;
        this.resultClient = resultClient;
    }

    public void processInvitations(){
        log.info("Starting to process invitations");
        val availabilities = partnerClient.fetchPartnerAvailabilities();
        availabilityCalculator.processAvailabilities(availabilities);
        val countries = availabilityCalculator.processCountries();
        log.info(String.format("Submitting %s countries dates",countries.size()));
        resultClient.postCountryAvailabilities(countries);
        log.info("Finished processing invitations");
    }
}
