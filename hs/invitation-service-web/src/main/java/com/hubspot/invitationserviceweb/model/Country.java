package com.hubspot.invitationserviceweb.model;

import lombok.Data;

import java.util.List;

@Data
public class Country {

    public int attendeeCount;
    public List<String> attendees;
    public String name;
    public String startDate;

}
