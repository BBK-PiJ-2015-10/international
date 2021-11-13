package com.hubspot.invitationserviceweb.api;


import com.hubspot.invitationserviceweb.service.InvitationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TriggerApiController implements TriggerApi{

    private InvitationService invitationService;

    @Autowired
    public TriggerApiController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @Override
    public void invitationProcessing() {
        log.info("Received request to process invitations");
        invitationService.processInvitations();
        log.info("Completed request to process invitations");
    }
}
