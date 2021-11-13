package com.hubspot.invitationserviceweb.api;

import org.springframework.web.bind.annotation.PostMapping;

public interface TriggerApi {

    @PostMapping(
            value ="invitation/processing"
    )
    void invitationProcessing();

}
