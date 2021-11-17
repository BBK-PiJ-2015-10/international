package com.hubspot.invitationserviceweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Country {

    public int attendeeCount;
    public List<String> attendees;
    public String name;
    public String startDate;

}
