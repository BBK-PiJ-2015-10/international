package com.hubspot.invitationserviceweb.service;

import com.hubspot.invitationserviceweb.model.Country;
import com.hubspot.invitationserviceweb.model.Partner;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class AvailabilityCalculator {

    Map<String,Map<LocalDate,List<String>>> countriesDatesEmails = new HashMap<>();

    public AvailabilityCalculator() { }

    public void processAvailabilities(List<Partner> partners){
        log.info("Loading availability");
        partners.forEach(this::processAvailability);
    }

    public List<Country> processCountries(){
        List<Country> countries = new LinkedList<>();
        for (String country: countriesDatesEmails.keySet()){
            val dto = new Country();
            dto.setName(country);
            List<String> attendeeList = null;
            val dateParticipants = countriesDatesEmails.get(country);
            val selectedDates =
                    dateParticipants.keySet().stream().sorted(Comparator.comparing(date -> -dateParticipants.get(date).size())).collect(Collectors.toList());
            if (selectedDates.isEmpty()){
                dto.setStartDate(null);
            } else {
                LocalDate selectedDate = selectedDates.get(0);
                dto.setStartDate(selectedDate.toString());
                attendeeList = dateParticipants.get(selectedDate);
            }
            if (attendeeList==null){
                dto.setAttendees(new LinkedList<>());
                dto.setAttendeeCount(0);
            } else {
                dto.setAttendees(attendeeList);
                dto.setAttendeeCount(attendeeList.size());
            }
            countries.add(dto);
        }
        return countries;
    }


    public void processAvailability(Partner partner){
        val country = partner.country;
        val dates  = partner.availableDates.stream().map(this::extractDate).collect(Collectors.toList());
        for (int i=0;i<dates.size()-1;i++){
            val date = dates.get(i);
            val nextDate = dates.get(i+1);
            if (date.plusDays(1).equals(nextDate)){
                val countryMap = countriesDatesEmails.get(country);
                if (countryMap==null){
                    //create countryMap
                    log.info("Creating map for country {}",country);
                    Map<LocalDate,List<String>> datesEmails = new TreeMap<>();
                    //Create emailList for that date
                    List<String> emails = new LinkedList<>();
                    emails.add(partner.email);
                    //Add date to that map
                    datesEmails.put(date,emails);
                    countriesDatesEmails.put(country,datesEmails);
                    log.info("Created date {} for new country {}",date,country);
                    log.info("Added participant {} to new date {} on new country {}",partner.email,date,country);
                } else {
                    //update country map
                    val existingDateList = countryMap.get(date);
                    if (existingDateList==null){
                        List<String> emails = new LinkedList<>();
                        emails.add(partner.email);
                        countryMap.put(date,emails);
                        log.info("Created date {} for existing country {}",date,country);
                        log.info("Added participant {} to new date {} on existing country {}",partner.email,date,
                                country);
                    } else {
                        //update date list
                        existingDateList.add(partner.email);
                        log.info("Added participant {} to existing date {} on existing country {}",partner.email,date,
                                country);
                    }
                }
            }
        }
        //Add country in case no match
        if (countriesDatesEmails.get(country)==null){
            Map<LocalDate,List<String>> datesEmails = new TreeMap<>();
            countriesDatesEmails.put(country,datesEmails);
        }
    }


    private LocalDate extractDate(String date) {
        return LocalDate.parse(date);
    }


}
